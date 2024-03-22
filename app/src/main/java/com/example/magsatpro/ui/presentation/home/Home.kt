package com.example.magsatpro.ui.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.magsatpro.data.remote.model.Category
import com.example.magsatpro.ui.components.MovieRow
import org.koin.androidx.compose.koinViewModel

@Composable
fun Home() {

    val viewModel = koinViewModel<HomeViewModel>()
    val state = viewModel.state.collectAsState()


    Column (

        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
    state.value.channels?.data?.map {
        Category(
            id = it.id,
            nm = it.nm
        )
    }?.let { MovieRow("channels",it) }

    state.value.movies?.data?.map {
        Category(
            id = it.id,
            nm = it.nm
        )
    }?.let { MovieRow( "movies",it) }



    state.value.series?.data?.map {
        Category(
            id = it.id,
            nm = it.nm
        )
    }?.let { MovieRow("series",it) }

    }
}