package com.example.magsatpro.stateModel

import com.example.magsatpro.data.remote.dto.movies.MovieInfoDTO
import com.example.magsatpro.data.remote.dto.series.SeriesInfoDTO
import com.example.magsatpro.data.remote.model.Episode

data class DetailsState(
    val isLoading : Boolean = false,
    val movie: MovieInfoDTO? = null,
    val serie : SeriesInfoDTO? = null,
    val error: String? = null,
    val type : String? = null,
    val episodes: EpisodeStateModel = EpisodeStateModel(isLoading = false, episodes = null, error = null)
)


data class EpisodeStateModel(
    val isLoading: Boolean = false,
    val episodes: List<Episode>?,
    val error: String? = null
)