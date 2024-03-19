package com.example.magsatpro.data.remote.dto.series

import com.example.magsatpro.data.remote.model.Serie

class SeriesDTO : ArrayList<SeriesDTOItem>()


data class SeriesDTOItem(
    val id: Int,
    val list: List<Serie>,
    val nm: String
)