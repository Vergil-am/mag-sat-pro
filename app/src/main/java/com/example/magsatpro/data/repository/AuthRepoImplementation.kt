package com.example.magsatpro.data.repository

import android.util.Log
import com.example.magsatpro.data.remote.AuthAPI
import com.example.magsatpro.data.remote.dto.auth.LoginDTO
import com.example.magsatpro.domain.repository.AuthRepo
import com.example.magsatpro.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthRepoImplementation (
    private val api: AuthAPI
) : AuthRepo {
    override suspend fun login(code: Long, mac: String, model: String): Flow<Resource<LoginDTO>>  = flow {
        try {
            val res = api.login(code, mac, model)
            Log.e("Response", res.body().toString())
            emit(Resource.Success(res.body()))

        } catch (e :Exception) {
            emit(Resource.Error(""))

        }

    }
}