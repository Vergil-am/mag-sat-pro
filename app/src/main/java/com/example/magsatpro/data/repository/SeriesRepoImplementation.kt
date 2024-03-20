package com.example.magsatpro.data.repository

import com.example.magsatpro.data.remote.SeriesAPI
import com.example.magsatpro.data.remote.dto.series.SeriesDTO
import com.example.magsatpro.data.remote.dto.series.SeriesInfoDTO
import com.example.magsatpro.domain.repository.SeriesRepo
import javax.inject.Inject

class SeriesRepoImplementation @Inject constructor(
    private val api: SeriesAPI
) : SeriesRepo {
    override suspend fun getSeries(category: Int?): SeriesDTO {
        return api.getSeries(category = category)
    }

    override suspend fun getSeriesInfo(id: Int): SeriesInfoDTO {
        return api.getSeriesInfo(id = id)
    }

    override suspend fun getSeriesCategories(): SeriesDTO {
        return api.getSeriesCategories()
    }
}