package com.example.magsatpro.stateModel

import com.example.magsatpro.data.remote.dto.channels.ChannelsDTO

data class ChannelsState(
    val isLoading: Boolean = false,
    val channels: ChannelsDTO? = null,
    val error: String? = null,
    val cat: Int? = null
)

