package com.example.moviesapp.presentation.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.data.model.Movie
import com.example.moviesapp.databinding.FragmentMovieDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {

    private val args: MovieDetailFragmentArgs by navArgs()
    private val viewModel: MovieDetailViewModel by viewModels()

    // ViewBinding reference
    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.initialize(args.movieId)
        setupViews()
        observeViewModel()
    }

    private fun setupViews() {
//        binding.toolbar.setNavigationOnClickListener {
//            findNavController().popBackStack()
//        }

        binding.fabFavorite.setOnClickListener {
            viewModel.toggleFavorite()
        }
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {

                launch {
                    viewModel.movie.collect { movie ->
                        movie?.let { showMovieDetails(it) }
                    }
                }

                launch {
                    viewModel.isFavorite.collect { isFavorite ->
                        updateFavoriteButton(isFavorite)
                    }
                }

            }
        }
    }

    private fun showMovieDetails(movie: Movie) {
        binding.progressBar.visibility = View.GONE
        binding.contentScrollView.visibility = View.VISIBLE

        // Set movie details
        binding.movieTitle.text = movie.title
        binding.movieReleaseDate.text = movie.releaseDate
        binding.movieDirector.text = movie.director
        binding.movieProducer.text = movie.producer
        binding.movieRunningTime.text = "${movie.runningTime} minutes"
        binding.movieRtScore.text = movie.rtScore
        binding.movieDescription.text = movie.description

        // Show original title if different
        if (movie.originalTitle != movie.title) {
            binding.movieOriginalTitle.text = movie.originalTitle
            binding.movieOriginalTitle.visibility = View.VISIBLE
        } else {
            binding.movieOriginalTitle.visibility = View.GONE
        }

        // Load poster image
        Glide.with(this)
            .load(movie.image)
            .placeholder(android.R.color.background_light)
            .error(android.R.color.background_light)
            .into(binding.moviePoster)

        // Update toolbar title
       // binding.toolbar.title = movie.title
    }

    private fun updateFavoriteButton(isFavorite: Boolean) {
        val iconRes = if (isFavorite) {
            R.drawable.ic_favorite_filled
        } else {
            R.drawable.ic_favorite_border
        }
        binding.fabFavorite.setImageResource(iconRes)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
