package com.example.magsatpro.ui.layouts

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import com.example.magsatpro.R
import com.example.magsatpro.domain.model.NavItem
import com.example.magsatpro.ui.components.BottomNavBar
import com.example.magsatpro.ui.components.NavRail

val navItems = listOf(
    NavItem("Live TV", R.drawable.tv_svgrepo_com, "channels"),
    NavItem("Movies", R.drawable.video_frame_svgrepo_com__2_, "movies"),
    NavItem("Series", R.drawable.album_svgrepo_com__1_, "series"),
    NavItem("Settings", R.drawable.settings_svgrepo_com, "settings"),
)

@Composable
fun HomeLayout(
    composable: @Composable () -> Unit
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    Scaffold(
        bottomBar = {
            if (screenWidth < 600) {
                BottomNavBar(items = navItems, selected = "channels", onNavigate = {})
            }
        }
    ) {
        Row(
            modifier = Modifier.padding(it)
        ) {
            if (screenWidth >= 600) {
                NavRail(items = navItems, selected = "channels", onNavigate = {})
            }
            composable()
        }
    }
}