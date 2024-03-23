package com.example.magsatpro.ui.navigation

sealed class Route (
    val route : String
) {
    data object Home : Route("home")
    data object Channels : Route("channels")
    data object Movies : Route("movies")
    data object Series: Route("series")
    data object Settings: Route("settings")


    data object MovieDetails : Route("movies/{id}")
    data object ShowDetails : Route("series/{id}")
}