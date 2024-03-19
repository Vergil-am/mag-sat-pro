package com.example.magsatpro.data.remote.dto.channels

import com.example.magsatpro.data.remote.model.Channel

class ChannelsDTO : ArrayList<ChannelsDTOItem>()


data class ChannelsDTOItem(
    val id: Int,
    val list: List<Channel>,
    val nm: String,
    val pid: Int
)