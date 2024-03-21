package com.example.magsatpro.domain.repository

import com.example.magsatpro.data.remote.dto.channels.CategoriesDTO
import com.example.magsatpro.data.remote.dto.channels.ChannelsDTO
import com.example.magsatpro.util.Resource
import kotlinx.coroutines.flow.Flow

interface ChannelsRepo {
    suspend fun getChannels(
        category: Int?,
    ): Flow<Resource<ChannelsDTO>>

    suspend fun getChannelCategories(
    ): Flow<Resource<CategoriesDTO>>


}