package com.example.magsatpro.domain.repository

import com.example.magsatpro.data.remote.dto.channels.CategoriesDTO
import com.example.magsatpro.data.remote.dto.channels.ChannelsDTO

interface ChannelsRepo {
    fun getChannels(
        category: Int?,
    ): ChannelsDTO

    fun getChannelCategories(
    ): CategoriesDTO


}