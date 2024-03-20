package com.example.magsatpro.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.magsatpro.ui.components.BottomNavBar
import com.example.magsatpro.ui.presentation.browse.Browse
import com.example.magsatpro.ui.presentation.details.Details
import com.example.magsatpro.ui.presentation.home.Home
import com.example.magsatpro.ui.presentation.home.HomeViewModel
import com.example.magsatpro.ui.presentation.list.Watchlist
import com.example.magsatpro.ui.presentation.settings.Settings

@Composable
fun NavGraph(
    startDestination: String,
    startIndex: Int?,
    updateIndex: (index: Int) -> Unit,
    homeViewModel: HomeViewModel
) {
    val navController = rememberNavController()
    Scaffold (
        bottomBar = {
            BottomNavBar(navController, startIndex, updateIndex)

        }
    ) {
        Surface (modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            NavHost(navController = navController, startDestination = startDestination) {
                composable(Route.Home.route) {
                    Home(
                        homeViewModel
                    )
                }
                composable(Route.Browse.route) {
                    Browse()
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
                composable(Route.List.route) {
                    Watchlist()
                }


            }

        }
    }

}