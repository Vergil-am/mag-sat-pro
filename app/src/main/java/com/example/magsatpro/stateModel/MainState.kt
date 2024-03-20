package com.example.magsatpro.stateModel

import com.example.magsatpro.ui.navigation.Route
import kotlinx.coroutines.flow.MutableStateFlow

data class MainState(
    val startDestination : String = Route.Home.route,
    val startIndex : Int? = 0
)