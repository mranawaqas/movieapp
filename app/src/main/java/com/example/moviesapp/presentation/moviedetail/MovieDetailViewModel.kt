package com.example.moviesapp.presentation.moviedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.model.Movie
import com.example.moviesapp.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private var movieId: String = ""
    
    private val _movie = MutableStateFlow<Movie?>(null)
    val movie: StateFlow<Movie?> = _movie.asStateFlow()

    private val _isFavorite = MutableStateFlow(false)
    val isFavorite: StateFlow<Boolean> = _isFavorite.asStateFlow()

    fun initialize(movieId: String) {
        this.movieId = movieId
        loadMovie()
    }

    private fun loadMovie() {
        viewModelScope.launch {
            try {
                // Get all movies to find the one with matching ID
                val movies = repository.getMovies()
                val foundMovie = movies.find { it.id == movieId }
                
                // Merge favorite status from database
                val movieWithFavoriteStatus = foundMovie?.let { movie ->
                    val isFavorite = try {
                        repository.isFavorite(movie.id)
                    } catch (e: Exception) {
                        false
                    }
                    movie.copy(isFavorite = isFavorite)
                }
                
                _movie.value = movieWithFavoriteStatus
                _isFavorite.value = movieWithFavoriteStatus?.isFavorite ?: false
            } catch (e: Exception) {
                // Handle error
            }
        }
        
        // Observe favorite status changes
        observeFavoriteStatus()
    }
    
    private fun observeFavoriteStatus() {
        viewModelScope.launch {
            repository.getFavoriteMovies().collect { favorites ->
                val isFavorite = favorites.any { it.id == movieId }
                _isFavorite.value = isFavorite
                // Update movie with favorite status
                _movie.value = _movie.value?.copy(isFavorite = isFavorite)
            }
        }
    }

    fun toggleFavorite() {
        viewModelScope.launch {
            try {
                val currentMovie = _movie.value ?: return@launch
                
                if (_isFavorite.value) {
                    repository.removeFromFavorites(currentMovie.id)
                    _isFavorite.value = false
                } else {
                    repository.addToFavorites(currentMovie)
                    _isFavorite.value = true
                }
            } catch (e: Exception) {
                // Handle error silently for better UX
            }
        }
    }
}