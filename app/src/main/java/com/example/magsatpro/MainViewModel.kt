package com.example.magsatpro

import androidx.lifecycle.ViewModel
import com.example.magsatpro.stateModel.MainState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    fun updateStartIndex(index: Int) {
        _state.value = _state.value.copy(startIndex = index)
    }

}