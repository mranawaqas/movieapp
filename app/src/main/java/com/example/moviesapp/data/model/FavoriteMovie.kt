package com.example.moviesapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_movies")
data class FavoriteMovie(
    @PrimaryKey
    val id: String,
    val title: String,
    val originalTitle: String,
    val image: String,
    val description: String,
    val releaseDate: String,
    val director: String,
    val producer: String,
    val runningTime: String,
    val rtScore: String
)

