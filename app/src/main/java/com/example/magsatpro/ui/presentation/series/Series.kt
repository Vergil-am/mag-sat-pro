package com.example.magsatpro.ui.presentation.series

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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.magsatpro.util.Constants
import org.koin.androidx.compose.koinViewModel

@Composable
fun Series(
    navController: NavController
) {
    val viewModel = koinViewModel<SeriesViewModel>()
    val state = viewModel.state.collectAsState()
    val series = if (state.value.cat == null) {
        state.value.series
    } else {
        state.value.series?.filter { state.value.cat == it.id }
    }


    when (state.value.isLoading) {
        true -> Text(text = "Loading ... ")
        false ->
            Column {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())
                ) {
                    state.value.series?.map {
                        FilterChip(
                            modifier = Modifier.padding(10.dp),
                            selected = state.value.cat == it.id, onClick = {
                                viewModel.selectCategory(it.id)
                            }, label = {
                                Text(text = it.nm)
                            })

                    }

                }
                LazyVerticalGrid(
                    state = rememberLazyGridState(),
                    columns = GridCells.Adaptive(100.dp),
                    modifier = Modifier.padding(
                        horizontal = 20.dp
                    )
                ) {
                    series?.map { seriesDTO ->
                        seriesDTO.list.map {
                            item {
                                Card(
                                    modifier = Modifier
                                        .padding(6.dp)
                                        .height(150.dp),
                                    onClick = {navController.navigate("details/serie/${it.id}")}
                                ) {
                                    Image(
                                        modifier = Modifier.fillMaxSize(),
                                        painter = rememberAsyncImagePainter(model = "${Constants.LOGO_BASE_URL}/serie/${it.id}"),
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