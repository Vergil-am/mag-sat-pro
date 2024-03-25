package com.example.magsatpro.stateModel

import com.example.magsatpro.ui.navigation.Route

data class MainState(
    val startDestination : String = Route.Exoplayer.route,
    val hash : String? = null
)