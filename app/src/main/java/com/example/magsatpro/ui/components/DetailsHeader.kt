package com.example.magsatpro.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.magsatpro.R
import com.google.common.base.Ascii

@Composable
fun DetailsHeader(
    id: Int,
    title: String,
    backDrop: String,
    poster: String,
    type: String,
    navController: NavController
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        if (screenWidth < 600) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .blur(5.dp),
                contentScale = ContentScale.Crop,
                painter = rememberAsyncImagePainter(model = backDrop), contentDescription = title
            )
        }
        Box(
            modifier = if (screenWidth < 600) {
                Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                MaterialTheme.colorScheme.background
                            ),
                        )
                    )
            } else {
                Modifier.fillMaxSize()
            }
        ) {
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(10.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.Bottom
        ) {

            Image(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .height(150.dp)
                    .width(100.dp),
                painter = rememberAsyncImagePainter(
                    poster
                ),
                contentDescription = title,
                alignment = Alignment.BottomStart,
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = Ascii.toUpperCase(title),
                    style = MaterialTheme.typography.titleMedium,
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    if (type == "movie") {
                        Button(onClick = {
                            navController.navigate("exoplayer/movie/$id")
                        }) {
                            Text(text = "Watch now")
                        }
                    }
                    IconButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        onClick = {
                        },
                        colors = IconButtonColors(
                            containerColor = MaterialTheme.colorScheme.background,
                            contentColor = MaterialTheme.colorScheme.primary,
                            disabledContainerColor = MaterialTheme.colorScheme.background,
                            disabledContentColor = MaterialTheme.colorScheme.background
                        )
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.heart_svgrepo_com),
                            contentDescription = "Add to favorites"
                        )

                    }
                }

            }
        }
    }

}