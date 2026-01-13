package com.example.moviesapp.data.database

import androidx.room.*
import com.example.moviesapp.data.model.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies WHERE isFavorite = 1")
    fun getFavoriteMovies(): Flow<List<Movie>>

    @Query("SELECT * FROM movies WHERE id = :id")
    suspend fun getMovieById(id: String): Movie?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: Movie)

    @Update
    suspend fun updateMovie(movie: Movie)

    @Delete
    suspend fun deleteMovie(movie: Movie)

    @Query("UPDATE movies SET isFavorite = :isFavorite WHERE id = :id")
    suspend fun updateFavoriteStatus(id: String, isFavorite: Boolean)

    @Query("SELECT EXISTS(SELECT 1 FROM movies WHERE id = :id AND isFavorite = 1)")
    suspend fun isMovieFavorite(id: String): Boolean
}