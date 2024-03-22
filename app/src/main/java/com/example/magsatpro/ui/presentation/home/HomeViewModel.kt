package com.example.magsatpro.ui.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.magsatpro.domain.repository.MovieRepo
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class HomeViewModel (
    private val movies : MovieRepo
) : ViewModel() {

    init {
        getMovies()
    }

    fun getMovies() {
        Log.e("Function", "Ran")
        viewModelScope.launch {
            movies.getMovies(null).onEach {
                Log.e("Movies", it.toString())
            }
        }
    }


}