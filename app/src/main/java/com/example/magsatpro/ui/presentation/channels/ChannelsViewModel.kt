package com.example.magsatpro.ui.presentation.channels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.magsatpro.domain.repository.ChannelsRepo
import com.example.magsatpro.stateModel.ChannelsState
import com.example.magsatpro.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class ChannelsViewModel (
    val repo: ChannelsRepo
): ViewModel() {

    private val _state = MutableStateFlow(ChannelsState())
    val state = _state.asStateFlow()
    init {
        getChannels()
    }
    private fun getChannels() {
        viewModelScope.launch {
            repo.getChannels(null).onEach {
                when (it) {
                    is Resource.Loading -> _state.value = _state.value.copy(isLoading = true)
                    is Resource.Success-> _state.value = _state.value.copy(isLoading = false, channels = it.data)
                    is Resource.Error -> _state.value = _state.value.copy(isLoading = false, error = it.message)
                }
            }.launchIn(viewModelScope)

        }
    }
    fun selectCategory(cat: Int) {
        _state.value = _state.value.copy(cat = cat)

    }
}