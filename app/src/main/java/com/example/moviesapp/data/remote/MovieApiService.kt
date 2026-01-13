package com.example.moviesapp.data.remote

import com.example.moviesapp.data.model.Movie
import retrofit2.http.GET

interface MovieApiService {
    
    @GET("films")
    suspend fun getMovies(): List<Movie>
    
    companion object {
        const val BASE_URL = "https://ghibliapi.vercel.app/"
    }
}