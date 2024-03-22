package com.example.magsatpro.di

import com.example.magsatpro.data.remote.AuthAPI
import com.example.magsatpro.data.remote.ChannelsAPI
import com.example.magsatpro.data.remote.MoviesAPI
import com.example.magsatpro.data.remote.SeriesAPI
import com.example.magsatpro.data.repository.AuthRepoImplementation
import com.example.magsatpro.data.repository.ChannelRepoImplementation
import com.example.magsatpro.data.repository.MovieRepoImplementation
import com.example.magsatpro.data.repository.SeriesRepoImplementation
import com.example.magsatpro.domain.repository.AuthRepo
import com.example.magsatpro.domain.repository.ChannelsRepo
import com.example.magsatpro.domain.repository.MovieRepo
import com.example.magsatpro.domain.repository.SeriesRepo
import com.example.magsatpro.ui.presentation.home.HomeViewModel
import com.example.magsatpro.util.Constants
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val KoinAppModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoviesAPI::class.java)
    }
    single<MovieRepo> {
        MovieRepoImplementation(get())
    }

    single {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SeriesAPI::class.java)
    }
    single<SeriesRepo> {
        SeriesRepoImplementation(get())
    }

    single {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ChannelsAPI::class.java)
    }
    single<ChannelsRepo> {
        ChannelRepoImplementation(get())
    }

    single {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthAPI::class.java)
    }
    single<AuthRepo> {
        AuthRepoImplementation(get())
    }

    viewModel<HomeViewModel> {
        HomeViewModel(get())

    }
}