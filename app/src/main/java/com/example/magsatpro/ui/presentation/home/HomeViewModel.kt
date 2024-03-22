package com.example.magsatpro.ui.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.magsatpro.domain.repository.ChannelsRepo
import com.example.magsatpro.domain.repository.MovieRepo
import com.example.magsatpro.domain.repository.SeriesRepo
import com.example.magsatpro.stateModel.HomeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class HomeViewModel(
    private val movies: MovieRepo,
    private val series: SeriesRepo,
    private val channels: ChannelsRepo
) : ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    init {
        getMovies()
        getSeries()
        getChannels()
    }

    private fun getMovies() {
        viewModelScope.launch {
            movies.getMovies(null).onEach {
                Log.e("Movies", it.data?.size.toString())
                _state.value = _state.value.copy(movies = it)
            }.launchIn(viewModelScope)
        }

    }

    private fun getSeries() {
        viewModelScope.launch {
            series.getSeries(null).onEach {
                Log.e("Series", it.data.toString())
                _state.value = _state.value.copy(series = it)
            }.launchIn(viewModelScope)
        }
    }

    private fun getChannels() {
        viewModelScope.launch {
            channels.getChannels(null).onEach {

                Log.e("Channels", it.data.toString())
                _state.value = _state.value.copy(channels = it)
            }.launchIn(viewModelScope)
        }
    }

}