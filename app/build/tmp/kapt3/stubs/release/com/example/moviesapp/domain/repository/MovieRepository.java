package com.example.moviesapp.domain.repository;

import com.example.moviesapp.data.model.Movie;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH&J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u00a6@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u00a6@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u00a6@\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"Lcom/example/moviesapp/domain/repository/MovieRepository;", "", "addToFavorites", "", "movie", "Lcom/example/moviesapp/data/model/Movie;", "(Lcom/example/moviesapp/data/model/Movie;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavoriteMovies", "Lkotlinx/coroutines/flow/Flow;", "", "getMovies", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isFavorite", "", "movieId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeFromFavorites", "app_release"})
public abstract interface MovieRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMovies(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.moviesapp.data.model.Movie>> $completion);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.moviesapp.data.model.Movie>> getFavoriteMovies();
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object addToFavorites(@org.jetbrains.annotations.NotNull
    com.example.moviesapp.data.model.Movie movie, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object removeFromFavorites(@org.jetbrains.annotations.NotNull
    java.lang.String movieId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object isFavorite(@org.jetbrains.annotations.NotNull
    java.lang.String movieId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
}