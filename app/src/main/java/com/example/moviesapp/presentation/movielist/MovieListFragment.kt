package com.example.moviesapp.presentation.movielist

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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.data.model.Movie
import com.example.moviesapp.databinding.FragmentMovieListBinding
import com.example.moviesapp.presentation.common.MovieFilter
import com.example.moviesapp.presentation.common.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieListFragment : Fragment() {

    private val viewModel: MovieListViewModel by viewModels()

    // ViewBinding reference
    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()
        setupRecyclerView()
        setupChips()
        observeViewModel()
        
        // Set navigation callback in ViewModel
        viewModel.setOnMovieClick { movie ->
            navigateToMovieDetail(movie)
        }
    }

    private fun setupViews() {
        binding.retryButton.setOnClickListener {
            viewModel.retry()
        }

        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.retry()
        }
    }

    private fun setupRecyclerView() {
        // Use adapter from ViewModel
        binding.recyclerView.apply {
            adapter = viewModel.adapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setupChips() {
        binding.chipAll.setOnClickListener {
            viewModel.setFilter(MovieFilter.ALL)
        }

        binding.chipFavorites.setOnClickListener {
            viewModel.setFilter(MovieFilter.FAVORITES)
        }
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {

                launch {
                    viewModel.uiState.collect { state ->
                        handleUiState(state)
                    }
                }

                launch {
                    viewModel.filter.collect { filter ->
                        updateFilterChips(filter)
                    }
                }

            }
        }
    }

    private fun handleUiState(state: UiState<List<Movie>>) {
        when (state) {
            is UiState.Loading -> showLoading()
            is UiState.Success -> {
                hideLoading()
                if (state.data.isEmpty()) showEmpty() else showMovies(state.data)
            }
            is UiState.Error -> {
                hideLoading()
                showError(state.message)
            }
        }
    }

    private fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
        binding.errorLayout.visibility = View.GONE
        binding.emptyMessage.visibility = View.GONE
        binding.swipeRefreshLayout.visibility = View.GONE
        binding.swipeRefreshLayout.isRefreshing = false
    }

    private fun hideLoading() {
        binding.progressBar.visibility = View.GONE
        binding.swipeRefreshLayout.isRefreshing = false
    }

    private fun showError(message: String?) {
        binding.errorMessage.text = message ?: "An error occurred"
        binding.errorLayout.visibility = View.VISIBLE
        binding.emptyMessage.visibility = View.GONE
        binding.swipeRefreshLayout.visibility = View.GONE
    }

    private fun showEmpty() {
        val filter = viewModel.filter.value
        binding.emptyMessage.text = if (filter == MovieFilter.FAVORITES) {
            "No favorite movies yet"
        } else {
            "No movies available"
        }
        binding.emptyMessage.visibility = View.VISIBLE
        binding.errorLayout.visibility = View.GONE
        binding.swipeRefreshLayout.visibility = View.GONE
    }

    private fun showMovies(movies: List<Movie>) {
        // Adapter is updated by ViewModel
        binding.swipeRefreshLayout.visibility = View.VISIBLE
        binding.errorLayout.visibility = View.GONE
        binding.emptyMessage.visibility = View.GONE
    }

    private fun updateFilterChips(filter: MovieFilter) {
        binding.chipAll.isChecked = filter == MovieFilter.ALL
        binding.chipFavorites.isChecked = filter == MovieFilter.FAVORITES
    }

    private fun navigateToMovieDetail(movie: Movie) {
        val action = MovieListFragmentDirections.actionMovieListToMovieDetail(movie.id)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
