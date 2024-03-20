package com.example.magsatpro.data.repository

import com.example.magsatpro.data.remote.MoviesAPI
import com.example.magsatpro.data.remote.dto.movies.CategoriesDTO
import com.example.magsatpro.data.remote.dto.movies.MovieInfoDTO
import com.example.magsatpro.data.remote.dto.movies.MoviesDTO
import com.example.magsatpro.domain.repository.MovieRepo
import javax.inject.Inject

class MovieRepoImplementation @Inject constructor(
    private val api: MoviesAPI
) : MovieRepo {
    override suspend fun getMovies(category: Int?): MoviesDTO {
        return api.getMovies(category = category)
    }

    override suspend fun getMovieInfo(id: Int): MovieInfoDTO {
        return api.getMovieInfo(id = id)
    }

    override suspend fun getMovieCategories(): CategoriesDTO {
        return api.getMovieCategories()
    }
}