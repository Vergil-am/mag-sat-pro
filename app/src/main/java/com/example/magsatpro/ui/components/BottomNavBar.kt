package com.example.magsatpro.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.magsatpro.R
import com.example.magsatpro.ui.navigation.Route
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius
import com.exyte.animatednavbar.items.wigglebutton.WiggleButton

@Composable
fun BottomNavBar(
    navController: NavController
) {
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    AnimatedNavigationBar(
        selectedIndex = selectedIndex,
        barColor = Color.Blue,
        cornerRadius = shapeCornerRadius(34.dp),
        modifier = Modifier.padding(10.dp),
        ballColor = MaterialTheme.colorScheme.secondary
    ) {


        WiggleButton(
            modifier = Modifier.height(50.dp),
            isSelected = navController.currentDestination?.route == Route.Home.route,
            onClick = { navController.navigate(Route.Home.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
                      selectedIndex = 0},
            icon = R.drawable.home_svgrepo_com,
            backgroundIcon = R.drawable.home_svgrepo_com
        )
        WiggleButton(

            modifier = Modifier.height(50.dp),
            isSelected = navController.currentDestination?.route == Route.Browse.route,
            onClick = {navController.navigate(Route.Browse.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
                selectedIndex = 1},
            icon = R.drawable.browse_list_svgrepo_com,
            backgroundIcon = R.drawable.browse_list_svgrepo_com
        )
        WiggleButton(

            modifier = Modifier.height(50.dp),
            isSelected = navController.currentDestination?.route == Route.List.route,
            onClick = {navController.navigate(Route.List.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
                selectedIndex  = 2 },
            icon = R.drawable.heart_svgrepo_com,
            backgroundIcon = R.drawable.heart_svgrepo_com
        )
        WiggleButton(
            modifier = Modifier.height(50.dp),
            isSelected = navController.currentDestination?.route == Route.Settings.route,
            onClick = {navController.navigate(Route.Settings.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
                selectedIndex = 3},
            icon = R.drawable.user_svgrepo_com,
            backgroundIcon = R.drawable.user_svgrepo_com
        )
    }
}