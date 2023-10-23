package com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476.databinding.ActivityDetailMovieBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailMovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailMovieBinding
    private val viewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieId = intent.getStringExtra("movie_id")

        if (!movieId.isNullOrEmpty()){
            viewModel.getMoviesDetail(movieId.toInt())
        }

        viewModel.movie.observe(this) {
            if (it!=null){
                binding.movieDesc.text = it.synopsis
                binding.movieTitle.text = it.title
                Glide.with(this@DetailMovieActivity)
                    .load(getPosterUrl(it.posterUrl))
                    .into(binding.movieImage)
                var genres = ""
                it.genres.forEach{item->
                    genres += item.name + " "
                }

                binding.movieGenre.text = "Genre: $genres"
            }
        }
    }

    fun getPosterUrl(posterPath: String?): String? {
        return if (!posterPath.isNullOrBlank()) {
            "https://image.tmdb.org/t/p/w500$posterPath" // Adjust the size as needed
        } else {
            null
        }
    }
}