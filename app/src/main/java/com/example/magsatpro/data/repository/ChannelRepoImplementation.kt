package com.example.magsatpro.data.repository

import com.example.magsatpro.data.remote.ChannelsAPI
import com.example.magsatpro.data.remote.dto.channels.CategoriesDTO
import com.example.magsatpro.data.remote.dto.channels.ChannelsDTO
import com.example.magsatpro.domain.repository.ChannelsRepo
import javax.inject.Inject

class ChannelRepoImplementation @Inject constructor(
    private val api: ChannelsAPI
) : ChannelsRepo {
    override suspend fun getChannels(category: Int?): ChannelsDTO {
        return api.getChannels(category = category)
    }

    override suspend fun getChannelCategories(): CategoriesDTO {
        return api.getChannelCategories()
    }
}