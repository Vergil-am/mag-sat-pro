package com.example.magsatpro.domain.repository

import com.example.magsatpro.data.remote.dto.auth.LoginDTO
import com.example.magsatpro.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepo {
    suspend fun login(
        code: Long,
        mac: String,
        model: String,

        ): Flow<Resource<LoginDTO>>
}