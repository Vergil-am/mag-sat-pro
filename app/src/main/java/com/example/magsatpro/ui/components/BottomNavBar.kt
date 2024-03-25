package com.example.magsatpro.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.magsatpro.domain.model.NavItem

@Composable
fun BottomNavBar(
    items: List<NavItem>,
    selected: String?,
    onNavigate: (String) -> Unit
) {

    BottomAppBar {
        items.onEach {
            NavigationBarItem(
                selected = selected == it.value,
                onClick = {
                    onNavigate(it.value)
                }, icon = {
                    Icon(
                        modifier = Modifier.height(30.dp),
                        painter =
                        painterResource(id = it.icon), contentDescription = it.title
                    )
                })
        }
    }
}