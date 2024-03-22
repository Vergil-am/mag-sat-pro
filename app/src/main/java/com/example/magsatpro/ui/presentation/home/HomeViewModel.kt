package com.example.magsatpro.ui.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.magsatpro.domain.repository.MovieRepo
import com.example.magsatpro.stateModel.HomeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class HomeViewModel (
    private val movies : MovieRepo
) : ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()
    init {
        viewModelScope.launch {
            getMovies()
        }
    }

    private suspend fun getMovies() {
        Log.e("Function", "Ran")
            movies.getMovies(null).onEach {
                Log.e("Test", it.data.toString())
                _state.value = _state.value.copy(movies = it)
            }.launchIn(viewModelScope)
    }


}