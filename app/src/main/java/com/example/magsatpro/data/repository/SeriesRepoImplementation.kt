package com.example.magsatpro.data.repository

import android.util.Log
import com.example.magsatpro.data.remote.SeriesAPI
import com.example.magsatpro.data.remote.dto.series.SeriesDTO
import com.example.magsatpro.data.remote.dto.series.SeriesInfoDTO
import com.example.magsatpro.data.remote.model.Episode
import com.example.magsatpro.domain.repository.SeriesRepo
import com.example.magsatpro.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SeriesRepoImplementation (
    private val api: SeriesAPI
) : SeriesRepo {
    override suspend fun getSeries(category: Int?): Flow<Resource<SeriesDTO>> = flow {
        try {
            val res = api.getSeries(category = category)
            emit(Resource.Success(res.body()))

        } catch (e :Exception) {
            emit(Resource.Error(""))
        }

    }

    override suspend fun getSeriesInfo(id: Int): Flow<Resource<SeriesInfoDTO >> = flow {

        try {
            val res = api.getSeriesInfo(id = id)
            emit(Resource.Success(res.body()))

        } catch (e :Exception) {
            emit(Resource.Error(""))
        }

    }

    override suspend fun getSeriesCategories(): Flow<Resource<SeriesDTO >> = flow {

        try {
            val res = api.getSeriesCategories()
            emit(Resource.Success(res.body()))

        } catch (e :Exception) {
            emit(Resource.Error(""))
        }

    }

    override suspend fun getEpisodes(pid: Int): Flow<Resource<List<Episode>>>  = flow {
        emit(Resource.Loading())
        try {
            val res = api.getEpisodes(pid)
            Log.e("Episodes", res.body().toString())
            emit(Resource.Success(res.body()))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Resource.Error("Fetching episodes failed ${e.message}"))
        }
    }
}