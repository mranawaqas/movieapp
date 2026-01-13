package com.example.moviesapp.data.api

import com.example.moviesapp.data.model.Movie
import retrofit2.http.GET

interface MovieApiService {
    @GET("films")
    suspend fun getMovies(): List<Movie>
}