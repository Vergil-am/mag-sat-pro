package com.example.magsatpro.data.repository

import com.example.magsatpro.data.remote.AuthAPI
import com.example.magsatpro.data.remote.dto.auth.LoginDTO
import com.example.magsatpro.domain.repository.AuthRepo
import com.example.magsatpro.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepoImplementation @Inject constructor(
    private val api: AuthAPI
) : AuthRepo {
    override suspend fun login(code: Int, mac: String, model: String): Flow<Resource<LoginDTO>>  = flow {
        try {
            val res = api.login(code, mac, model)
            emit(Resource.Success(res.body()))

        } catch (e :Exception) {
            emit(Resource.Error(""))

        }

    }
}