package com.example.magsatpro.ui.presentation.details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel

@Composable
fun Details(
    type: String,
    id: Int,
    navController: NavController
) {
    val viewModel = koinViewModel<DetailsViewModel>()
    viewModel.getDetails(type, id)
    val state = viewModel.state.collectAsState().value

    when (state.isLoading) {
        true -> Text(text = "Loading ...")
        false -> {
            when (type) {
                "serie" -> {

                }
                "movie" -> {

                }

            }
        }
    }


}