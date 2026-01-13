package com.example.moviesapp.presentation.movielist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.model.Movie
import com.example.moviesapp.domain.repository.MovieRepository
import com.example.moviesapp.presentation.common.MovieFilter
import com.example.moviesapp.presentation.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<Movie>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<Movie>>> = _uiState.asStateFlow()

    private val _filter = MutableStateFlow(MovieFilter.ALL)
    val filter: StateFlow<MovieFilter> = _filter.asStateFlow()

    private val _allMovies = MutableStateFlow<List<Movie>>(emptyList())
    private val _favoriteMovies = MutableStateFlow<List<Movie>>(emptyList())

    // Adapter managed by ViewModel
    val adapter = MovieAdapter(
        onMovieClick = { movie ->
            _onMovieClick(movie)
        },
        onFavoriteClick = { movie ->
            toggleFavorite(movie)
        }
    )

    private var _onMovieClick: (Movie) -> Unit = {}
    fun setOnMovieClick(callback: (Movie) -> Unit) {
        _onMovieClick = callback
    }

    init {
        loadMovies()
        observeFavorites()
    }

    private fun loadMovies() {
        viewModelScope.launch {
            try {
                _uiState.value = UiState.Loading
                val movies = repository.getMovies()
                _allMovies.value = movies
                updateDisplayedMovies()
            } catch (e: Exception) {
                val errorMessage = when (e) {
                    is HttpException -> {
                        when (e.code()) {
                            404 -> "Movies not found. Please try again."
                            500 -> "Server error. Please try again later."
                            503 -> "Service unavailable. Please try again later."
                            else -> "HTTP error ${e.code()}: ${e.message()}"
                        }
                    }
                    is IOException -> "Network error. Please check your internet connection."
                    else -> e.message ?: "An unexpected error occurred. Please try again."
                }
                _uiState.value = UiState.Error(errorMessage)
            }
        }
    }

    private fun observeFavorites() {
        viewModelScope.launch {
            repository.getFavoriteMovies().collect { favorites ->
                _favoriteMovies.value = favorites
                updateDisplayedMovies()
            }
        }
    }

    private suspend fun updateDisplayedMovies() {
        val moviesToShow = when (_filter.value) {
            MovieFilter.ALL -> {
                // Merge favorite status from database with API movies
                _allMovies.value.map { movie ->
                    val isFavorite = try {
                        repository.isFavorite(movie.id)
                    } catch (e: Exception) {
                        false
                    }
                    movie.copy(isFavorite = isFavorite)
                }
            }
            MovieFilter.FAVORITES -> _favoriteMovies.value
        }
        _uiState.value = UiState.Success(moviesToShow)
        // Update adapter when movies change
        adapter.submitList(moviesToShow)
    }

    fun setFilter(filter: MovieFilter) {
        _filter.value = filter
        viewModelScope.launch {
            updateDisplayedMovies()
        }
    }

    fun toggleFavorite(movie: Movie) {
        viewModelScope.launch {
            try {
                val isFavorite = repository.isFavorite(movie.id)
                if (isFavorite) {
                    repository.removeFromFavorites(movie.id)
                } else {
                    repository.addToFavorites(movie)
                }
                // Update displayed movies to reflect the change
                updateDisplayedMovies()
            } catch (e: Exception) {
                // Handle error silently for better UX
            }
        }
    }

    fun retry() {
        loadMovies()
    }
}