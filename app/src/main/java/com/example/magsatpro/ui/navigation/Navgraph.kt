package com.example.magsatpro.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.magsatpro.ui.presentation.channels.Channels
import com.example.magsatpro.ui.presentation.details.Details
import com.example.magsatpro.ui.presentation.home.Home
import com.example.magsatpro.ui.presentation.movies.Movies
import com.example.magsatpro.ui.presentation.series.Series
import com.example.magsatpro.ui.presentation.settings.Settings

@Composable
fun NavGraph(
    startDestination: String,
) {
    val navController = rememberNavController()

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        NavHost(navController = navController, startDestination = startDestination) {
            composable(Route.Home.route) {
                Home(
                    navController
                )
            }
            composable(Route.Channels.route) {
                Channels()
            }
            composable(Route.Movies.route) {
                Movies()
            }
            composable(Route.Series.route) {
                Series()
            }
            composable(Route.MovieDetails.route) {
                Details()
            }
            composable(Route.ShowDetails.route) {
                Details()
            }
            composable(Route.Settings.route) {
                Settings()
            }



        }

    }

}