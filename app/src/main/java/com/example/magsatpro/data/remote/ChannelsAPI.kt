package com.example.magsatpro.data.remote

import com.example.magsatpro.data.remote.dto.channels.CategoriesDTO
import com.example.magsatpro.data.remote.dto.channels.ChannelsDTO
import com.example.magsatpro.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ChannelsAPI {
    @GET("android/live")
    suspend fun getChannels(
        @Query("action") action: String = "streams",
        @Query("pid") category : Int?,
        @Query("hash") hash: String = Constants.HASH
    ) : Response<ChannelsDTO>

    @GET("android/live")
    suspend fun getChannelCategories(
        @Query("action") action: String = "categories",
        @Query("hash") hash: String = Constants.HASH
    ) : Response<CategoriesDTO>


}