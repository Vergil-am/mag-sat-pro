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
import com.example.magsatpro.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMoviesAPI(): MoviesAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoviesAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideMoviesRepo(api: MoviesAPI) : MovieRepo {
        return MovieRepoImplementation(api)

    }

    @Provides
    @Singleton
    fun provideSeriesAPI(): SeriesAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SeriesAPI::class.java)
    }
    @Provides
    @Singleton
    fun provideSeriesRepo(api: SeriesAPI) : SeriesRepo {
        return SeriesRepoImplementation(api)

    }

    @Provides
    @Singleton
    fun provideChannelsAPI(): ChannelsAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ChannelsAPI::class.java)
    }
    @Provides
    @Singleton
    fun provideChannelsRepo(api: ChannelsAPI) : ChannelsRepo{
        return ChannelRepoImplementation(api)

    }


    @Provides
    @Singleton
    fun provideAuthAPI(): AuthAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthAPI::class.java)
    }
    @Provides
    @Singleton
    fun provideAuthRepo(api: AuthAPI) : AuthRepo{
        return AuthRepoImplementation(api)

    }
}