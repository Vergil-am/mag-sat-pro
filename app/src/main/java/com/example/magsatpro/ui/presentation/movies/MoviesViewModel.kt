package com.example.magsatpro.ui.presentation.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.magsatpro.domain.repository.MovieRepo
import com.example.magsatpro.stateModel.MovieState
import com.example.magsatpro.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val repo: MovieRepo,
) : ViewModel() {
    private val _state = MutableStateFlow(MovieState())
    val state = _state.asStateFlow()


    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            repo.getMovies(null).onEach {
                when (it) {
                    is Resource.Loading -> {
                        _state.value = _state.value.copy(isLoading = true)
                    }

                    is Resource.Error -> {
                        _state.value = _state.value.copy(isLoading = false, error = it.message)
                    }

                    is Resource.Success -> {
                        _state.value = _state.value.copy(isLoading = false, movies = it.data)
                    }
                }
            }.launchIn(viewModelScope)
        }
    }

    fun selectCategory(id: Int) {
        _state.value = _state.value.copy(cat = id)
    }
}


