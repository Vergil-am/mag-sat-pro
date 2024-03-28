package com.example.magsatpro.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ListItem
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.magsatpro.data.remote.model.Episode
import com.example.magsatpro.util.Constants

@Composable
fun Episodes(
    episodes: List<Episode>,
    navController: NavController
) {
    var selectedTab by remember {
        mutableIntStateOf(0)
    }

    val groupedEpisodes = episodes.groupBy { it.sz }

    Column(
        modifier = Modifier
    ) {
        TabRow(
            selectedTabIndex = selectedTab
        ) {
            groupedEpisodes.keys.forEachIndexed { index, season ->
                Tab(
                    modifier = Modifier
                        .height(50.dp)
                    ,
                    selected = selectedTab == index, onClick = {
                    selectedTab = index
                }) {
                    Text(text = "Season $season")
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        groupedEpisodes.values.elementAtOrNull(selectedTab)?.let {epis ->
            LazyColumn(
                state = rememberLazyListState()
            ) {
                items(epis) {
                    ListItem(
                        modifier = Modifier.clickable {
                            navController.navigate("exoplayer/serie/${it.id}")
                        },
                        leadingContent = {
                            Box(
                                modifier = Modifier
                                    .width(200.dp)
                                    .height(100.dp)
                            ) {
                                Image(
                                    modifier = Modifier.fillMaxSize(),
                                    painter = rememberAsyncImagePainter(
                                        model = "${Constants.LOGO_BASE_URL}/vod/${it.id}"
                                    ), contentDescription = it.nm
                                )
                            }

                        },
                        headlineContent = {
                            Text(text = it.nm)
                        })
                }
            }

        }
    }
}