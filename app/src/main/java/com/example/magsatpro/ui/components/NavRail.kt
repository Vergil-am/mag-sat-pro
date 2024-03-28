package com.example.magsatpro.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.magsatpro.domain.model.NavItem
import com.example.magsatpro.ui.navigation.Route


@Composable
fun NavRail(
    items: List<NavItem>,
    selected: String?,
    onNavigate: (String) -> Unit
) {
    NavigationRail(
        header = {
            IconButton(onClick = {
                onNavigate(Route.Exoplayer.route)
            }) {
                Icon(Icons.Filled.Menu, "Menu")
            }
        }
    ) {
        items.onEach {
            NavigationRailItem(selected = selected == it.value, onClick = {
                onNavigate(it.value)
            }, icon = {
                Icon(
                    modifier = Modifier.height(30.dp),
                    painter = painterResource(id = it.icon),
                    contentDescription = it.title
                )
            })
        }

    }
}