package com.example.moviesapp.data.repository;

import android.util.Log;
import com.example.moviesapp.data.api.MovieApiService;
import com.example.moviesapp.data.database.MovieDao;
import com.example.moviesapp.data.model.Movie;
import com.example.moviesapp.domain.repository.MovieRepository;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\rH\u0016J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0096@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@\u00a2\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/moviesapp/data/repository/MovieRepositoryImpl;", "Lcom/example/moviesapp/domain/repository/MovieRepository;", "movieApiService", "Lcom/example/moviesapp/data/api/MovieApiService;", "movieDao", "Lcom/example/moviesapp/data/database/MovieDao;", "(Lcom/example/moviesapp/data/api/MovieApiService;Lcom/example/moviesapp/data/database/MovieDao;)V", "addToFavorites", "", "movie", "Lcom/example/moviesapp/data/model/Movie;", "(Lcom/example/moviesapp/data/model/Movie;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavoriteMovies", "Lkotlinx/coroutines/flow/Flow;", "", "getMovies", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isFavorite", "", "movieId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeFromFavorites", "app_release"})
public final class MovieRepositoryImpl implements com.example.moviesapp.domain.repository.MovieRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.moviesapp.data.api.MovieApiService movieApiService = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.moviesapp.data.database.MovieDao movieDao = null;
    
    @javax.inject.Inject
    public MovieRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.example.moviesapp.data.api.MovieApiService movieApiService, @org.jetbrains.annotations.NotNull
    com.example.moviesapp.data.database.MovieDao movieDao) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getMovies(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.moviesapp.data.model.Movie>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<com.example.moviesapp.data.model.Movie>> getFavoriteMovies() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object addToFavorites(@org.jetbrains.annotations.NotNull
    com.example.moviesapp.data.model.Movie movie, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object removeFromFavorites(@org.jetbrains.annotations.NotNull
    java.lang.String movieId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object isFavorite(@org.jetbrains.annotations.NotNull
    java.lang.String movieId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
}