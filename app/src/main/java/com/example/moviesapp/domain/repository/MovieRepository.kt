package com.example.moviesapp.domain.repository

import com.example.moviesapp.data.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getMovies(): List<Movie>
    fun getFavoriteMovies(): Flow<List<Movie>>
    suspend fun addToFavorites(movie: Movie)
    suspend fun removeFromFavorites(movieId: String)
    suspend fun isFavorite(movieId: String): Boolean
}