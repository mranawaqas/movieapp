package com.example.moviesapp.data.database;

import androidx.room.*;
import com.example.moviesapp.data.model.Movie;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0018\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u001e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0010H\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0015"}, d2 = {"Lcom/example/moviesapp/data/database/MovieDao;", "", "deleteMovie", "", "movie", "Lcom/example/moviesapp/data/model/Movie;", "(Lcom/example/moviesapp/data/model/Movie;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavoriteMovies", "Lkotlinx/coroutines/flow/Flow;", "", "getMovieById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertMovie", "isMovieFavorite", "", "updateFavoriteStatus", "isFavorite", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMovie", "app_release"})
@androidx.room.Dao
public abstract interface MovieDao {
    
    @androidx.room.Query(value = "SELECT * FROM movies WHERE isFavorite = 1")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.moviesapp.data.model.Movie>> getFavoriteMovies();
    
    @androidx.room.Query(value = "SELECT * FROM movies WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMovieById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.moviesapp.data.model.Movie> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertMovie(@org.jetbrains.annotations.NotNull
    com.example.moviesapp.data.model.Movie movie, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateMovie(@org.jetbrains.annotations.NotNull
    com.example.moviesapp.data.model.Movie movie, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteMovie(@org.jetbrains.annotations.NotNull
    com.example.moviesapp.data.model.Movie movie, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE movies SET isFavorite = :isFavorite WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateFavoriteStatus(@org.jetbrains.annotations.NotNull
    java.lang.String id, boolean isFavorite, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT EXISTS(SELECT 1 FROM movies WHERE id = :id AND isFavorite = 1)")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object isMovieFavorite(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
}