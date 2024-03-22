package com.example.magsatpro.stateModel

import com.example.magsatpro.data.remote.dto.movies.MoviesDTO
import com.example.magsatpro.util.Resource

data class HomeState(
    val movies : Resource<MoviesDTO>? = null
)
