package com.example.magsatpro.domain.repository

import com.example.magsatpro.data.remote.dto.movies.CategoriesDTO
import com.example.magsatpro.data.remote.dto.movies.MovieInfoDTO
import com.example.magsatpro.data.remote.dto.movies.MoviesDTO

interface MovieRepo {
    fun getMovies(
        category: Int?,
    ): MoviesDTO

    fun getMovieInfo(
        id: Int,
    ): MovieInfoDTO

    fun getMovieCategories(
    ): CategoriesDTO

}