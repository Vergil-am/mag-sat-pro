package com.example.magsatpro.domain.repository

import com.example.magsatpro.data.remote.dto.series.SeriesDTO
import com.example.magsatpro.data.remote.dto.series.SeriesInfoDTO

interface SeriesRepo {
    fun getSeries(
        category: Int?,
    ): SeriesDTO

    fun getSeriesInfo(
        id: Int,
    ): SeriesInfoDTO

    fun getSeriesCategories(
    ): SeriesDTO


}