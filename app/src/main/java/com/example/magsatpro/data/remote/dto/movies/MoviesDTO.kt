package com.example.magsatpro.data.remote.dto.movies

import com.example.magsatpro.data.remote.model.Movie

class MoviesDTO : ArrayList<MoviesDTOItem>()


data class MoviesDTOItem(
    val id: Int,
    val list: List<Movie>,
    val nm: String,
    val pid: Int
)