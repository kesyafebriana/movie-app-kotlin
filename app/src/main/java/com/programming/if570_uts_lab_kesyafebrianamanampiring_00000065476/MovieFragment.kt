package com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476.databinding.FragmentMovieBinding

class MovieFragment : Fragment() {

    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MovieViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMovieBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.movieList.observe(viewLifecycleOwner) {
            if (it != null) {
                val adapter = MovieAdapter(it) { movie->
                    val intent = Intent(this@MovieFragment.requireContext(), DetailMovieActivity::class.java)
                    intent.putExtra("movie_id",movie.id.toString())
                    startActivity(intent)
                }
                binding.rvMovieList.layoutManager = GridLayoutManager(requireContext(),2)
                binding.rvMovieList.adapter = adapter

            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}