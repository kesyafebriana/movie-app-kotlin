package com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476.di

import com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476.MovieRepository
import com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476.TmdbService
import dagger.*
import dagger.hilt.*
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.*

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {
    @Provides
    @Singleton
    fun provideTmdbService(): TmdbService {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(TmdbService::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(tmdbService: TmdbService): MovieRepository {
        return MovieRepository(tmdbService)
    }
}