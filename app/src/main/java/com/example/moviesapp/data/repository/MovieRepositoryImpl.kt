package com.example.moviesapp.data.repository

import com.example.moviesapp.data.api.MovieApiService
import com.example.moviesapp.data.database.MovieDao
import com.example.moviesapp.data.model.Movie
import com.example.moviesapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepositoryImpl @Inject constructor(
    private val movieApiService: MovieApiService,
    private val movieDao: MovieDao
) : MovieRepository {

    override suspend fun getMovies(): List<Movie> {
        // Let exceptions propagate to ViewModel for proper error handling
        // ViewModel will catch and show error state with retry button
        return movieApiService.getMovies()
    }

    override fun getFavoriteMovies(): Flow<List<Movie>> {
        return movieDao.getFavoriteMovies()
    }

    override suspend fun addToFavorites(movie: Movie) {
        val favoriteMovie = movie.copy(isFavorite = true)
        movieDao.insertMovie(favoriteMovie)
    }

    override suspend fun removeFromFavorites(movieId: String) {
        movieDao.updateFavoriteStatus(movieId, false)
    }

    override suspend fun isFavorite(movieId: String): Boolean {
        return movieDao.isMovieFavorite(movieId)
    }
}