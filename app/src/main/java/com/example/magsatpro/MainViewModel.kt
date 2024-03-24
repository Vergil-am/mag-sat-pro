package com.example.magsatpro

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.magsatpro.domain.repository.AuthRepo
import com.example.magsatpro.stateModel.MainState
import com.example.magsatpro.util.Constants.CODE
import com.example.magsatpro.util.Constants.MAC
import com.example.magsatpro.util.Constants.MODEL
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainViewModel(
    private val auth: AuthRepo
) : ViewModel() {
    private val _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()


    init {
        login()
    }

    private fun login() {
        viewModelScope.launch {
            auth.login(
                code = CODE,
                mac = MAC,
                model = MODEL
            ).onEach {
                _state.value = _state.value.copy(hash = it.data?.hash)
            }.launchIn(viewModelScope)
        }
    }
}