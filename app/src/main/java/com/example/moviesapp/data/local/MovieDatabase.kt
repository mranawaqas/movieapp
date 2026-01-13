package com.example.moviesapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesapp.data.model.FavoriteMovie

@Database(
    entities = [FavoriteMovie::class],
    version = 1,
    exportSchema = false
)
abstract class MovieDatabase : RoomDatabase() {
    
    abstract fun favoriteMovieDao(): FavoriteMovieDao
    
    companion object {
        const val DATABASE_NAME = "movie_database"
    }
}