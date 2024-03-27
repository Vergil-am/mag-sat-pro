package com.example.magsatpro.ui.presentation.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.magsatpro.util.Constants.LOGO_BASE_URL
import org.koin.androidx.compose.koinViewModel

@Composable
fun Details(
    type: String,
    id: Int,
    navController: NavController
) {
    val viewModel = koinViewModel<DetailsViewModel>()
    LaunchedEffect(id, type) {
        viewModel.getDetails(type, id)
    }
    val state = viewModel.state.collectAsState().value
    val screenWidth = LocalConfiguration.current.screenWidthDp

    when (state.isLoading) {
        true -> Text(text = "Loading ...")
        false -> {
            when (type) {
                "serie" -> {
                    val serie = state.serie
                    serie?.get(0)?.let {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 20.dp)
                        ) {
                            Image(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp),
                                painter = rememberAsyncImagePainter(model = "${LOGO_BASE_URL}/vod/${it.id}"),
                                contentDescription = it.nm
                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = it.date)
                                Text(text = it.director)
//                            Text(text = it.)
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                it.genre.split(",").map {
                                    AssistChip(
                                        modifier = Modifier.padding(horizontal = 6.dp),
                                        onClick = { /*TODO*/ },
                                        label = { Text(text = it) })
                                }

                            }
                            Text(text = it.plot)
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                Button(onClick = { /*TODO*/ }) {
                                    Text(text = "Add to favorites")
                                }
                            }

                            val episodes = state.episodes


                            when (episodes.isLoading) {
                                true -> Text(text = "Loading ... ")
                                false -> episodes.episodes?.map {
                                    LazyColumn(
                                        state = rememberLazyListState()
                                    ) {
                                        items(episodes.episodes) {

                                            ListItem(
                                                modifier = Modifier.clickable {
                                                    navController.navigate("exoplayer/serie/${it.id}")
                                                },
                                                leadingContent = {
                                                    Box(
                                                        modifier = Modifier
                                                            .width(200.dp)
                                                            .height(100.dp)
                                                    ) {
                                                        Image(
                                                            modifier = Modifier.fillMaxSize(),
                                                            painter = rememberAsyncImagePainter(
                                                                model = "$LOGO_BASE_URL/vod/${it.id}"
                                                            ), contentDescription = it.nm
                                                        )
                                                    }

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

                "movie" -> {
                    val movie = state.movie
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp)
                    ) {

                        movie?.let {
                            Row {
                                Image(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(150.dp),
                                    painter = rememberAsyncImagePainter(model = "${LOGO_BASE_URL}/vod/${it.id}"),
                                    contentDescription = it.nm
                                )

                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = it.year)
                                Text(text = it.director)
                                Text(text = it.rating)
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                it.genre.split(",").map {
                                    AssistChip(
                                        modifier = Modifier.padding(horizontal = 6.dp),
                                        onClick = { /*TODO*/ },
                                        label = { Text(text = it) })
                                }

                            }
                            Text(text = it.plot)
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                Button(onClick = { /*TODO*/ }) {
                                    Text(text = "Add to favorites")
                                }
                                Button(onClick = {
                                    navController.navigate("exoplayer/movie/$id")
                                }) {
                                    Text(text = "Watch now")
                                }

                            }

                        }
                    }
                }

            }
        }
    }


}