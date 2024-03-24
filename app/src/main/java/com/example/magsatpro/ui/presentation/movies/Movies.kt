package com.example.magsatpro.ui.presentation.movies

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.magsatpro.util.Constants
import org.koin.androidx.compose.koinViewModel

@Composable
fun Movies() {

    val viewModel = koinViewModel<MoviesViewModel>()
    val state = viewModel.state.collectAsState()
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(vertical = 10.dp)
        ) {
            state.value.movies?.map {
                FilterChip(
                    modifier = Modifier.padding(6.dp),
                    selected = state.value.cat == it.id, onClick = {
                        viewModel.selectCategory(it.id)
                    }, label = {
                        Text(text = it.nm)
                    })

            }

        }

        when (state.value.isLoading) {
            true -> Text(text = "Loading...")
            false ->
                LazyVerticalGrid(
                    state = rememberLazyGridState(),
                    columns = GridCells.Adaptive(100.dp),
                    modifier = Modifier.padding(
                        horizontal = 20.dp
                    )
                ) {
                    val movies = if (state.value.cat == null) {
                        state.value.movies
                    } else {
                        state.value.movies?.filter { state.value.cat == it.id }
                    }
                    movies?.map { movieDTOItem ->
                        movieDTOItem.list.map {
                            item {
                                Card(
                                    modifier = Modifier
                                        .padding(6.dp)
                                        .height(150.dp)
                                        .fillMaxWidth()
                                ) {
                                    Image(
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop,
                                        painter = rememberAsyncImagePainter(model = "${Constants.LOGO_BASE_URL}/vod/${it.id}"),
                                        contentDescription = it.nm
                                    )
                                }
                            }

                        }
                    }

                }

        }
    }
}