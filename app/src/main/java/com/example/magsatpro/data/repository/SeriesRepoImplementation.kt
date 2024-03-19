package com.example.magsatpro.data.repository

import com.example.magsatpro.data.remote.SeriesAPI
import com.example.magsatpro.data.remote.dto.series.SeriesDTO
import com.example.magsatpro.data.remote.dto.series.SeriesInfoDTO
import com.example.magsatpro.domain.repository.SeriesRepo
import javax.inject.Inject

class SeriesRepoImplementation @Inject constructor(
    private val api: SeriesAPI
) : SeriesRepo {
    override fun getSeries(category: Int?): SeriesDTO {
        return api.getSeries(category = category)
    }

    override fun getSeriesInfo(id: Int): SeriesInfoDTO {
        return api.getSeriesInfo(id = id)
    }

    override fun getSeriesCategories(): SeriesDTO {
        return api.getSeriesCategories()
    }
}