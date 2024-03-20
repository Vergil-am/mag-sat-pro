package com.example.magsatpro.data.remote

import com.example.magsatpro.data.remote.dto.movies.CategoriesDTO
import com.example.magsatpro.data.remote.dto.movies.MovieInfoDTO
import com.example.magsatpro.data.remote.dto.movies.MoviesDTO
import com.example.magsatpro.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesAPI {
    @GET("android/movie")
    suspend fun getMovies(
        @Query("action") action: String = "streams",
        @Query("pid") category : Int?,
        @Query("hash") hash: String = Constants.HASH
    ) : MoviesDTO

    @GET("android/movie")
    suspend fun getMovieInfo(
        @Query("action") action: String = "infoMovie",
        @Query("id") id: Int,
        @Query("hash") hash: String = Constants.HASH
    ) : MovieInfoDTO

    @GET("android/movie")
    suspend fun getMovieCategories(
        @Query("action") action: String = "infoMovie",
        @Query("hash") hash: String = Constants.HASH
    ) : CategoriesDTO

}