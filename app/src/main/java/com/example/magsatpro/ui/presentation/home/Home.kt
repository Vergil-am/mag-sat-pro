package com.example.magsatpro.ui.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.magsatpro.R
import com.example.magsatpro.ui.navigation.Route

data class MenuItem(
    val title: String,
    val icon: Int,
    val value: String
)

val items = listOf(
    MenuItem("Live tv", R.drawable.tv_svgrepo_com, "channels"),
    MenuItem("Movies", R.drawable.video_frame_svgrepo_com__2_, "movies") ,
    MenuItem("Series", R.drawable.album_svgrepo_com__1_, "series")

)

@Composable
fun Home(
    navController: NavController
) {


    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Mag sat pro",
                style = MaterialTheme.typography.headlineMedium
            )

            IconButton(
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp),
                onClick = {
                    navController.navigate(Route.Settings.route)
                }) {
                Icon(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(
                        id = R.drawable.settings_svgrepo_com
                    ),
                    contentDescription = "Settings"
                )
            }


        }

        Row {
            items.onEach {
                Card(
                    modifier = Modifier
                        .height(250.dp)
                        .width(200.dp)
                        .padding(10.dp),
                    onClick = {
                        navController.navigate(it.value)
                    }
                ) {
                    Icon(
                        modifier = Modifier.height(80.dp),
                        painter = painterResource(id = it.icon), contentDescription = it.title
                    )
                    Text(
                        text = it.title,
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }
        }

    }
}