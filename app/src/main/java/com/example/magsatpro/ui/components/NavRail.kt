package com.example.magsatpro.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.magsatpro.domain.model.NavItem


@Composable
fun NavRail(
    items: List<NavItem>,
    selected: String,
    onNavigate: (String) -> Unit
) {
    NavigationRail(
        header = {
            IconButton(onClick = { /*TODO*/ }) {
                Text(text = "test")
                Icon(Icons.Filled.Menu, "Menu")
            }
        }
    ) {
        items.onEach {
            NavigationRailItem(selected = selected == it.value, onClick = {
                onNavigate(it.value)
            }, icon = {
                Icon(imageVector = Icons.Filled.Settings, contentDescription = it.title)
            })
        }

    }
}