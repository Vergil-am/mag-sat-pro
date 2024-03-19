package com.example.magsatpro.data.remote.dto.series

class SeriesInfoDTO : ArrayList<SeriesInfoDTOItem>()


data class SeriesInfoDTOItem(
    val cast: String,
    val cover: String,
    val date: String,
    val director: String,
    val genre: String,
    val id: Int,
    val nm: String,
    val onm: String,
    val plot: String,
    val tmdb_id: String
)