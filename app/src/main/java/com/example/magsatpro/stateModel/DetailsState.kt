package com.example.magsatpro.stateModel

import com.example.magsatpro.data.remote.dto.movies.MovieInfoDTO
import com.example.magsatpro.data.remote.dto.series.SeriesInfoDTO

data class DetailsState(
    val isLoading : Boolean = false,
    val movie: MovieInfoDTO? = null,
    val serie : SeriesInfoDTO? = null,
    val error: String? = null,
    val type : String? = null
)
