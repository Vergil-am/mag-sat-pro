package com.example.magsatpro.data.remote

import com.example.magsatpro.data.remote.dto.series.SeriesDTO
import com.example.magsatpro.data.remote.dto.series.SeriesInfoDTO
import com.example.magsatpro.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface SeriesAPI {
    @GET("android/serie")
    suspend fun getSeries(
        @Query("action") action: String = "categories",
        @Query("pid") category : Int?,
        @Query("hash") hash: String = Constants.HASH
    ) : SeriesDTO

    @GET("android/serie")
    suspend fun getSeriesInfo(
        @Query("action") action: String = "infoSerie",
        @Query("id") id: Int,
        @Query("hash") hash: String = Constants.HASH
    ) : SeriesInfoDTO

    @GET("android/serie")
    suspend fun getSeriesCategories(
        @Query("action") action: String = "categories",
        @Query("hash") hash: String = Constants.HASH
    ) : SeriesDTO


}