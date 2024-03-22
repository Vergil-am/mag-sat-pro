package com.example.magsatpro.data.repository

import android.util.Log
import com.example.magsatpro.data.remote.MoviesAPI
import com.example.magsatpro.data.remote.dto.movies.CategoriesDTO
import com.example.magsatpro.data.remote.dto.movies.MovieInfoDTO
import com.example.magsatpro.data.remote.dto.movies.MoviesDTO
import com.example.magsatpro.domain.repository.MovieRepo
import com.example.magsatpro.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepoImplementation @Inject constructor(
    private val api: MoviesAPI
) : MovieRepo {
    override suspend fun getMovies(category: Int?): Flow<Resource<MoviesDTO>> = flow {
        Log.e("Function repo", "Ran")
        try {
            val res = api.getMovies(category = category)
            emit(Resource.Success(res.body()))

        } catch (e :Exception) {
            emit(Resource.Error(""))
        }
    }

    override suspend fun getMovieInfo(id: Int): Flow<Resource<MovieInfoDTO>> = flow {
        try {
            val res = api.getMovieInfo(id = id)
            emit(Resource.Success(res.body()))

        } catch (e :Exception) {
            emit(Resource.Error(""))
        }
    }

    override suspend fun getMovieCategories(): Flow<Resource<CategoriesDTO >> = flow {
        try {
            val res = api.getMovieCategories()
            emit(Resource.Success(res.body()))

        } catch (e :Exception) {
            emit(Resource.Error(""))
        }
    }
}