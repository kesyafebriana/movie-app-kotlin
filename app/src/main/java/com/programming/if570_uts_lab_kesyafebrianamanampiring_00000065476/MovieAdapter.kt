package com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476.databinding.ItemMovieBinding
import com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476.model.Movie

class MovieAdapter(private val movieList: List<Movie>, private val listener: (Movie) -> Unit): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
    val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    return ViewHolder(binding)
  }

  override fun getItemCount(): Int {
    return movieList.size
  }

  override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
    with(holder) {
     with(movieList[position]) {
       binding.movieTitle.text = this.title
       Glide.with(holder.itemView.context)
         .load(getPosterUrl(this.posterUrl))
         .into(binding.movieImage)
       binding.root.setOnClickListener {
          listener(this)
       }
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

  inner class ViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)
}