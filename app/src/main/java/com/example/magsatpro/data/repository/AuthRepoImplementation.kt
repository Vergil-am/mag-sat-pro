package com.example.magsatpro.data.repository

import com.example.magsatpro.data.remote.AuthAPI
import com.example.magsatpro.data.remote.dto.auth.LoginDTO
import com.example.magsatpro.domain.repository.AuthRepo
import javax.inject.Inject

class AuthRepoImplementation @Inject constructor(
    private val api: AuthAPI
) : AuthRepo {
    override suspend fun login(code: Int, mac: String, model: String): LoginDTO {
        return api.login(code, mac, model)
    }
}