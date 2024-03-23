package com.example.magsatpro.stateModel

import com.example.magsatpro.data.remote.dto.series.SeriesDTO

data class SeriesState(
    val isLoading: Boolean = false,
    val series : SeriesDTO? = null,
    val error : String? = null,
    val cat : Int? = null
)
