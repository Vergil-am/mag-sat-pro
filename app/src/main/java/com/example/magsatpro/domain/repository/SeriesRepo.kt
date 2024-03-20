package com.example.magsatpro.domain.repository

import com.example.magsatpro.data.remote.dto.series.SeriesDTO
import com.example.magsatpro.data.remote.dto.series.SeriesInfoDTO

interface SeriesRepo {
    suspend fun getSeries(
        category: Int?,
    ): SeriesDTO

    suspend fun getSeriesInfo(
        id: Int,
    ): SeriesInfoDTO

    suspend fun getSeriesCategories(
    ): SeriesDTO


}