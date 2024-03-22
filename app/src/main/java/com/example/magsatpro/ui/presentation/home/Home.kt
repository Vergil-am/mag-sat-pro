package com.example.magsatpro.ui.presentation.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.koin.androidx.compose.getViewModel

@Composable
fun Home(
//    homeViewModel: HomeViewModel
) {

    val homeViewModel = getViewModel<HomeViewModel>()

    homeViewModel.getMovies()

    Text(text = "Home screen")
}