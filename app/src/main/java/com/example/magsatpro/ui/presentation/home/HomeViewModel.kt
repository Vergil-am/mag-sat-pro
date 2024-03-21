package com.example.magsatpro.ui.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.magsatpro.domain.repository.MovieRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movies: MovieRepo
) : ViewModel() {

    init {
        Log.e("Home viewModel", "Initialized")
    }


}