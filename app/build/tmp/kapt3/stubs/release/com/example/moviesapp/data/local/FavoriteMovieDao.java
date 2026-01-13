package com.example.moviesapp.data.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.moviesapp.data.model.FavoriteMovie;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/example/moviesapp/data/local/FavoriteMovieDao;", "", "deleteFavorite", "", "movie", "Lcom/example/moviesapp/data/model/FavoriteMovie;", "(Lcom/example/moviesapp/data/model/FavoriteMovie;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteFavoriteById", "movieId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllFavorites", "Lkotlinx/coroutines/flow/Flow;", "", "getFavoriteById", "insertFavorite", "isFavorite", "", "app_release"})
@androidx.room.Dao
public abstract interface FavoriteMovieDao {
    
    @androidx.room.Query(value = "SELECT * FROM favorite_movies")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.moviesapp.data.model.FavoriteMovie>> getAllFavorites();
    
    @androidx.room.Query(value = "SELECT * FROM favorite_movies WHERE id = :movieId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getFavoriteById(@org.jetbrains.annotations.NotNull
    java.lang.String movieId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.moviesapp.data.model.FavoriteMovie> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertFavorite(@org.jetbrains.annotations.NotNull
    com.example.moviesapp.data.model.FavoriteMovie movie, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteFavorite(@org.jetbrains.annotations.NotNull
    com.example.moviesapp.data.model.FavoriteMovie movie, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM favorite_movies WHERE id = :movieId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteFavoriteById(@org.jetbrains.annotations.NotNull
    java.lang.String movieId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT EXISTS(SELECT 1 FROM favorite_movies WHERE id = :movieId)")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object isFavorite(@org.jetbrains.annotations.NotNull
    java.lang.String movieId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
}