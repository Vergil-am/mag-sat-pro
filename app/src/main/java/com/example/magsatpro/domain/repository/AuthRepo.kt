package com.example.magsatpro.domain.repository

import com.example.magsatpro.data.remote.dto.auth.LoginDTO

interface AuthRepo {
    suspend fun login(
        code: Int,
        mac: String,
        model: String,

        ): LoginDTO
}