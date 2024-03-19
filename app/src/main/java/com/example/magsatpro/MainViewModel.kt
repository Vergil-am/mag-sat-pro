package com.example.magsatpro

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.magsatpro.stateModel.MainState
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : ViewModel() {
    private val _state = MutableStateFlow(MainState())
    val state = _state

}