package com.example.magsatpro.ui.layouts

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.magsatpro.R
import com.example.magsatpro.domain.model.NavItem
import com.example.magsatpro.ui.components.BottomNavBar
import com.example.magsatpro.ui.components.NavRail
import com.example.magsatpro.ui.navigation.Route

val navItems = listOf(
    NavItem("Live TV", R.drawable.tv_svgrepo_com, Route.Channels.route),
    NavItem("Movies", R.drawable.video_frame_svgrepo_com__2_, Route.Movies.route),
    NavItem("Series", R.drawable.album_svgrepo_com__1_, Route.Series.route),
    NavItem("Settings", R.drawable.settings_svgrepo_com, Route.Settings.route),
)

@Composable
fun HomeLayout(
    navController: NavController,
    composable: @Composable () -> Unit
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val currentRoute = navController.currentBackStackEntry?.destination?.route
    fun onNavigate(route: String) {
        navController.navigate(route = route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    Scaffold(
        bottomBar = {
            if (screenWidth < 600) {
                BottomNavBar(items = navItems,
                    selected = currentRoute,
                    onNavigate = {
                        route -> onNavigate(route)
                    })
            }
        }
    ) {
        Row(
            modifier = Modifier.padding(it)
        ) {
            if (screenWidth >= 600) {
                NavRail(items = navItems,
                    selected = currentRoute,
                    onNavigate = {
                        route -> onNavigate(route)
                    })
            }
            composable()
        }
    }
}