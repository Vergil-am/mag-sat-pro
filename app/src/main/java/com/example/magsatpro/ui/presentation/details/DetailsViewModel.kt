package com.example.magsatpro.ui.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.magsatpro.domain.repository.MovieRepo
import com.example.magsatpro.domain.repository.SeriesRepo
import com.example.magsatpro.stateModel.DetailsState
import com.example.magsatpro.stateModel.EpisodeStateModel
import com.example.magsatpro.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val movieRepo: MovieRepo,
    private val seriesRepo: SeriesRepo
) : ViewModel() {

    private val _state = MutableStateFlow(DetailsState())
    val state = _state.asStateFlow()


    fun getDetails(
        type: String,
        id: Int
    ) {
        _state.value = _state.value.copy(type = type)

        viewModelScope.launch {
            when (type) {
                "serie" -> {
                    seriesRepo.getSeriesInfo(id).onEach {
                        when (it) {
                            is Resource.Loading -> _state.value =
                                _state.value.copy(isLoading = true)

                            is Resource.Success -> _state.value =
                                _state.value.copy(isLoading = false, movie = null, serie = it.data)

                            is Resource.Error -> _state.value = _state.value.copy(
                                isLoading = false,
                                movie = null,
                                serie = null,
                                error = it.message
                            )
                        }
                    }.launchIn(viewModelScope)
                    seriesRepo.getEpisodes(id).onEach {
                        when (it) {
                            is Resource.Loading -> _state.value =
                                _state.value.copy(
                                    episodes = EpisodeStateModel(
                                        isLoading = true,
                                        episodes = null
                                    )
                                )

                            is Resource.Success -> _state.value =
                                _state.value.copy(
                                    episodes = EpisodeStateModel(
                                        isLoading = false,
                                        episodes = it.data
                                    )
                                )

                            is Resource.Error -> _state.value = _state.value.copy(
                                episodes = EpisodeStateModel(
                                    isLoading = false,
                                    episodes = null,
                                    error = it.message
                                )
                            )
                        }

                    }.launchIn(viewModelScope)
                }

                "movie" -> movieRepo.getMovieInfo(id).onEach {
                    when (it) {
                        is Resource.Loading -> _state.value = _state.value.copy(isLoading = true)
                        is Resource.Success -> _state.value =
                            _state.value.copy(isLoading = false, movie = it.data, serie = null)

                        is Resource.Error -> _state.value = _state.value.copy(
                            isLoading = false,
                            movie = null,
                            serie = null,
                            error = it.message
                        )
                    }
                }.launchIn(viewModelScope)
            }
        }

    }
}