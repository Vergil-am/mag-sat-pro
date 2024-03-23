package com.example.magsatpro.ui.presentation.series

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.magsatpro.domain.repository.SeriesRepo
import com.example.magsatpro.stateModel.SeriesState
import com.example.magsatpro.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class SeriesViewModel (
    private val repo: SeriesRepo
): ViewModel() {
    private val _state = MutableStateFlow(SeriesState())
    val state = _state.asStateFlow()

    init {
        getSeries()
    }

    private fun getSeries() {
        viewModelScope.launch {
            repo.getSeries(null).onEach {
                when (it) {
                    is Resource.Loading -> {
                        _state.value = _state.value.copy(isLoading = true)
                    }
                    is Resource.Error-> {
                        _state.value = _state.value.copy(isLoading = false , error = it.message)
                    }
                    is Resource.Success-> {
                        _state.value = _state.value.copy(isLoading = false, series = it.data)
                    }
                }
            }.launchIn(viewModelScope)
        }
    }
    fun selectCategory(id: Int) {
        _state.value = _state.value.copy(cat = id)
    }
}