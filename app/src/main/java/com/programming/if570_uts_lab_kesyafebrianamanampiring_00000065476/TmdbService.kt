package com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476

import com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476.model.MovieDetail
import com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476.model.MovieResponse
import io.reactivex.Single
import retrofit2.http.*

interface TmdbService {

    @GET("movie/now_playing")
    fun getNowPlayingMovies(
        @Query("api_key") apiKey: String,
    ): Single<MovieResponse>


    @GET("movie/{movie_id}")
    fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String,
        @Query("append_to_response") appendToResponse: String = "videos"
    ): Single<MovieDetail>


}
