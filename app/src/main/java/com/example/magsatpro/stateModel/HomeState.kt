package com.example.magsatpro.stateModel

import com.example.magsatpro.data.remote.dto.channels.ChannelsDTO
import com.example.magsatpro.data.remote.dto.movies.MoviesDTO
import com.example.magsatpro.data.remote.dto.series.SeriesDTO
import com.example.magsatpro.util.Resource

data class HomeState(
    val movies : Resource<MoviesDTO>? = null,
    val series: Resource<SeriesDTO>? = null,
    val channels: Resource<ChannelsDTO>? = null
)
