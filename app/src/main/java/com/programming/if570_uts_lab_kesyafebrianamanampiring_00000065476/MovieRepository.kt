package com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476

import com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476.model.MovieDetail
import com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476.model.MovieResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(private val tmdbService: TmdbService)  {

    fun getMovies(apiKey:String) : Single<MovieResponse> {
        return tmdbService.getNowPlayingMovies(apiKey).subscribeOn(Schedulers.io())
            .observeOn((AndroidSchedulers.mainThread()))
    }

    fun getMovieDetail(apiKey: String, id:Int): Single<MovieDetail>{
        return tmdbService.getMovieDetail(id,apiKey).subscribeOn(Schedulers.io()).observeOn((AndroidSchedulers.mainThread()))
    }
}