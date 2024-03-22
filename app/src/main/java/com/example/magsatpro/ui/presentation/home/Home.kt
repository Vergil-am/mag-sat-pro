package com.example.magsatpro.ui.presentation.home

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.koin.androidx.compose.koinViewModel

@Composable
fun Home() {

    val viewModel = koinViewModel<HomeViewModel>()

    val state = viewModel.state.collectAsState()

    Text(text = "Home screen")

    Log.e("State", state.value.movies.toString())

}