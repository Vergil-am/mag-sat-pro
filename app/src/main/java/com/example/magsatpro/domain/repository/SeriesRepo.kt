package com.example.magsatpro.domain.repository

import com.example.magsatpro.data.remote.dto.series.SeriesDTO
import com.example.magsatpro.data.remote.dto.series.SeriesInfoDTO
import com.example.magsatpro.data.remote.model.Episode
import com.example.magsatpro.util.Resource
import kotlinx.coroutines.flow.Flow

interface SeriesRepo {
    suspend fun getSeries(
        category: Int?,
    ): Flow<Resource<SeriesDTO>>

    suspend fun getSeriesInfo(
        id: Int,
    ): Flow<Resource<SeriesInfoDTO>>

    suspend fun getSeriesCategories(
    ): Flow<Resource<SeriesDTO>>

    suspend fun getEpisodes(
        pid: Int
    ): Flow<Resource<List<Episode>>>


}