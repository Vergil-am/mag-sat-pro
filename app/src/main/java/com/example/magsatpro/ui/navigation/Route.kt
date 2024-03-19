package com.example.magsatpro.ui.navigation

sealed class Route (
    val route : String
) {
    data object Home : Route("home")
    data object Browse : Route("browse")
    data object List : Route("list")
    data object Settings: Route("settings")


    data object MovieDetails : Route("movie/{id}")
    data object ShowDetails : Route("show/{id}")
}