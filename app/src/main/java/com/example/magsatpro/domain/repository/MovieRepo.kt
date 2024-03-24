package com.example.magsatpro.domain.repository

import com.example.magsatpro.data.remote.dto.movies.CategoriesDTO
import com.example.magsatpro.data.remote.dto.movies.MovieInfoDTO
import com.example.magsatpro.data.remote.dto.movies.MoviesDTO
import com.example.magsatpro.util.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepo {
    suspend fun getMovies(
        category: Int?,
//        hash: String
    ): Flow<Resource<MoviesDTO>>

    suspend fun getMovieInfo(
        id: Int,
//        hash: String
    ): Flow<Resource<MovieInfoDTO>>

    suspend fun getMovieCategories(
//        hash: String
    ): Flow<Resource<CategoriesDTO>>

}