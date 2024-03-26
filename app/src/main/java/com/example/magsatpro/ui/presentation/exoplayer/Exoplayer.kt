package com.example.magsatpro.ui.presentation.exoplayer

import android.os.Build
import android.util.Log
import androidx.annotation.OptIn
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory
import androidx.media3.ui.PlayerView
import com.example.magsatpro.util.Constants.BASE_URL
import com.example.magsatpro.util.Constants.HASH

@RequiresApi(Build.VERSION_CODES.R)
@OptIn(UnstableApi::class)
@Composable
fun Exoplayer(
    type: String?,
    id: String?,
    windowCompat: WindowInsetsControllerCompat
) {
    val source = "$BASE_URL/android/$type?action=link&id=$id&hash=$HASH"
    Log.e("Source", source)
    windowCompat.hide(WindowInsetsCompat.Type.systemBars())
    windowCompat.systemBarsBehavior =
        WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

    var player by remember {
        mutableStateOf<ExoPlayer?>(null)
    }

    var lifecycle by remember {
        mutableStateOf(Lifecycle.Event.ON_CREATE)
    }

    val lifecycleOwner = LocalContext.current as LifecycleOwner

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            lifecycle = event
            when (event) {
                Lifecycle.Event.ON_START -> player?.play()
                Lifecycle.Event.ON_STOP -> player?.pause()
                Lifecycle.Event.ON_DESTROY -> player?.release()
                else -> {}
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        AndroidView(
            factory = { context ->
                PlayerView(context).apply {
                    setBackgroundColor(Color.Black.toArgb())
                    val dataSourceFactory = DefaultHttpDataSource.Factory()
                    val mediaSourceFactory =
                        DefaultMediaSourceFactory(context).setDataSourceFactory(dataSourceFactory)
                    val mediaItem = MediaItem.Builder()
                        .setUri(source)
                        .build()
                    this.player = ExoPlayer.Builder(context)
                        .setMediaSourceFactory(mediaSourceFactory).build().also { player = it }
                    player?.setMediaItem(mediaItem)
                    player?.prepare()

                    useController = type != "live"

                    setShowPreviousButton(false)
                    setShowNextButton(false)
                    setShowSubtitleButton(false)
                }
            },
            modifier = Modifier.fillMaxSize(),
        )


    }
}