package com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476.model.Movie
import com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476.model.MovieDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class MovieViewModel  @Inject constructor(private val repository: MovieRepository): ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>> = _movieList

    private val _movie = MutableLiveData<MovieDetail>()
    val movie: LiveData<MovieDetail> = _movie


    fun getMovies() {
        compositeDisposable.add(
            repository.getMovies(BuildConfig.TMDB_API_KEY).subscribe(
                {
                    _movieList.postValue(it.results)
                    Log.e("MOVIE",it.results.toString())
                },
                {
                    Log.e("error", it.message.toString())
                }
            )
        )
    }

    fun getMoviesDetail(id:Int) {
        compositeDisposable.add(
            repository.getMovieDetail(BuildConfig.TMDB_API_KEY,id).subscribe(
                {
                    _movie.postValue(it)
                },
                {
                    Log.e("error", it.message.toString())
                }
            )
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}