package com.example.magsatpro.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.magsatpro.ui.layouts.HomeLayout
import com.example.magsatpro.ui.presentation.channels.Channels
import com.example.magsatpro.ui.presentation.details.Details
import com.example.magsatpro.ui.presentation.exoplayer.Exoplayer
import com.example.magsatpro.ui.presentation.home.Home
import com.example.magsatpro.ui.presentation.movies.Movies
import com.example.magsatpro.ui.presentation.series.Series
import com.example.magsatpro.ui.presentation.settings.Settings

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun NavGraph(
    startDestination: String,
    windowCompat: WindowInsetsControllerCompat
) {
    val navController = rememberNavController()

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        NavHost(navController = navController, startDestination = startDestination) {
            composable(Route.Home.route) {
                HomeLayout(
                    navController
                ) {
                    Home(
                        navController
                    )
                }

            }
            composable(Route.Channels.route) {

                HomeLayout(
                    navController
                ) {
                    Channels(
                        navController
                    )
                }
            }
            composable(Route.Movies.route) {

                HomeLayout(
                    navController
                ) {
                    Movies(
                        navController
                    )
                }
            }
            composable(Route.Series.route) {

                HomeLayout(
                    navController
                ) {
                    Series(
                        navController
                    )
                }
            }
            composable(Route.Details.route) {
                val type = it.arguments?.getString("type")
                val id = it.arguments?.getString("id")?.toIntOrNull()
                HomeLayout(
                    navController
                ) {
                    if (type != null && id != null) {
                        Details(
                            type,
                            id,
                            navController
                        )
                    }
                }
            }
            composable(Route.Settings.route) {

                HomeLayout(
                    navController
                ) {
                    Settings()
                }
            }
            composable(Route.Exoplayer.route) {
                val type = it.arguments?.getString("type")
                val id = it.arguments?.getString("id")
                Exoplayer(
                    type,
                    id,
                    windowCompat
                )
            }


        }

    }

}