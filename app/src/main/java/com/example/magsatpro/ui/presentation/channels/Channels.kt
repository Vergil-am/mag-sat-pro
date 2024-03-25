package com.example.magsatpro.ui.presentation.channels

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.FilterChip
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.magsatpro.util.Constants.LOGO_BASE_URL
import org.koin.androidx.compose.koinViewModel

@Composable
fun Channels(
    navController: NavController
) {
    val viewModel = koinViewModel<ChannelsViewModel>()
    val state = viewModel.state.collectAsState().value
    Column {
        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            state.channels?.map {
                FilterChip(
                    modifier = Modifier.padding(6.dp),
                    selected = state.cat == it.id, onClick = {
                        viewModel.selectCategory(it.id)
                    }, label = {
                        Text(text = it.nm)
                    })


            }
        }

        when (state.isLoading) {
            true -> Text(text = "Loading ...")
            false -> {
                val channels = if (state.cat == null) {
                    state.channels
                } else {
                    state.channels?.filter { state.cat == it.id }
                }
                LazyColumn {
                    channels?.map { channelsDTO ->
                        channelsDTO.list.map {


                            item {
                                ListItem(
                                    modifier = Modifier.clickable {
                                        navController.navigate("exoplayer/live/${it.id}")

                                    },
                                    leadingContent = {
                                        Image(
                                            modifier = Modifier
                                                .height(50.dp)
                                                .width(50.dp),
                                            painter = rememberAsyncImagePainter(
                                                model =
                                                "$LOGO_BASE_URL/chn/${it.id}"
                                            ),
                                            contentDescription = it.nm
                                        )
                                    },
                                    headlineContent = {
                                        Text(text = it.nm)
                                    })
                            }
                        }

                    }
                }
            }
        }
    }
}