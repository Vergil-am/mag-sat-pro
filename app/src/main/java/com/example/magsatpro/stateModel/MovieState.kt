package com.example.magsatpro.stateModel

import com.example.magsatpro.data.remote.dto.movies.MoviesDTO

data class MovieState(
    val isLoading: Boolean = false,
    val movies : MoviesDTO? = null,
    val error : String? = null,
    val cat : Int? = null
)
