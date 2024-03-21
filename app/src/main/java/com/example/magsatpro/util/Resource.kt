package com.example.magsatpro.util

sealed class Resource<T> (
    val data: T?,
    val message: String? = null
) {
    class Success<T>(data: T?) : Resource<T>(data)
    class Loading<T>(val isLoading: Boolean = true) : Resource<T>(null)

    class Error<T>(message: String) : Resource<T>(null, message)
}
