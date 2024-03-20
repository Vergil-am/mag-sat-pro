package com.example.magsatpro.domain.repository

import com.example.magsatpro.data.remote.dto.movies.CategoriesDTO
import com.example.magsatpro.data.remote.dto.movies.MovieInfoDTO
import com.example.magsatpro.data.remote.dto.movies.MoviesDTO

interface MovieRepo {
    suspend fun getMovies(
        category: Int?,
    ): MoviesDTO

    suspend fun getMovieInfo(
        id: Int,
    ): MovieInfoDTO

    suspend fun getMovieCategories(
    ): CategoriesDTO

}