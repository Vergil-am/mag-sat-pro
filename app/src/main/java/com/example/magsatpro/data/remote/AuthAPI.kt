package com.example.magsatpro.data.remote

import com.example.magsatpro.data.remote.dto.auth.LoginDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AuthAPI {
    @GET("android/login")
    suspend fun login(
        @Query("code") code: Int,
        @Query("mac") mac: String,
        @Query("model") model : String,

    ) : Response<LoginDTO>
}