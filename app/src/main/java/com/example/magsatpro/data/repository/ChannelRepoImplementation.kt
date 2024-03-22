package com.example.magsatpro.data.repository

import com.example.magsatpro.data.remote.ChannelsAPI
import com.example.magsatpro.data.remote.dto.channels.CategoriesDTO
import com.example.magsatpro.data.remote.dto.channels.ChannelsDTO
import com.example.magsatpro.domain.repository.ChannelsRepo
import com.example.magsatpro.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ChannelRepoImplementation (
    private val api: ChannelsAPI
) : ChannelsRepo {
    override suspend fun getChannels(category: Int?): Flow<Resource<ChannelsDTO >> = flow {
        try {
            val res = api.getChannels( category = category)
            emit(Resource.Success(res.body()))

        } catch (e :Exception) {
            emit(Resource.Error(""))

        }
    }

    override suspend fun getChannelCategories(): Flow<Resource<CategoriesDTO >> = flow{
        try {
            val res = api.getChannelCategories()
            emit(Resource.Success(res.body()))

        } catch (e :Exception) {
            emit(Resource.Error(""))

        }
    }
}