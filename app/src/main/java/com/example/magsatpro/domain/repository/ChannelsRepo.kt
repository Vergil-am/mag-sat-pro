package com.example.magsatpro.domain.repository

import com.example.magsatpro.data.remote.dto.channels.CategoriesDTO
import com.example.magsatpro.data.remote.dto.channels.ChannelsDTO

interface ChannelsRepo {
    suspend fun getChannels(
        category: Int?,
    ): ChannelsDTO

    suspend fun getChannelCategories(
    ): CategoriesDTO


}