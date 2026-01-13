package com.example.moviesapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "movies")
@Serializable
data class Movie(
    @PrimaryKey
    @SerialName("id")
    val id: String,
    @SerialName("title")
    val title: String,
    @SerialName("original_title")
    val originalTitle: String,
    @SerialName("image")
    val image: String,
    @SerialName("description")
    val description: String,
    @SerialName("release_date")
    val releaseDate: String,
    @SerialName("director")
    val director: String,
    @SerialName("producer")
    val producer: String,
    @SerialName("running_time")
    val runningTime: String,
    @SerialName("rt_score")
    val rtScore: String,
    val isFavorite: Boolean = false
)