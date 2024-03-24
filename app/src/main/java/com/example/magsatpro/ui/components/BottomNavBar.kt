package com.example.magsatpro.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import com.example.magsatpro.domain.model.NavItem

@Composable
fun BottomNavBar(
    items: List<NavItem>,
    selected: String,
    onNavigate: (String) -> Unit
) {
    BottomAppBar {
        items.onEach {
            NavigationBarItem(selected = selected == it.value, onClick = {
                onNavigate(it.value)
            }, icon = {

                Icon(imageVector = Icons.Filled.Settings, contentDescription = it.title)
            })
        }
    }
}