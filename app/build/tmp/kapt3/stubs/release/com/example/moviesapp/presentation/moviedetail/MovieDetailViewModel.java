package com.example.moviesapp.presentation.moviedetail;

import androidx.lifecycle.ViewModel;
import com.example.moviesapp.data.model.Movie;
import com.example.moviesapp.domain.repository.MovieRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0006\u0010\u0014\u001a\u00020\u0012R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\fR\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/moviesapp/presentation/moviedetail/MovieDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/moviesapp/domain/repository/MovieRepository;", "(Lcom/example/moviesapp/domain/repository/MovieRepository;)V", "_isFavorite", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_movie", "Lcom/example/moviesapp/data/model/Movie;", "isFavorite", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "movie", "getMovie", "movieId", "", "initialize", "", "loadMovie", "toggleFavorite", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class MovieDetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.moviesapp.domain.repository.MovieRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private java.lang.String movieId = "";
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.moviesapp.data.model.Movie> _movie = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.moviesapp.data.model.Movie> movie = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isFavorite = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isFavorite = null;
    
    @javax.inject.Inject
    public MovieDetailViewModel(@org.jetbrains.annotations.NotNull
    com.example.moviesapp.domain.repository.MovieRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.moviesapp.data.model.Movie> getMovie() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isFavorite() {
        return null;
    }
    
    public final void initialize(@org.jetbrains.annotations.NotNull
    java.lang.String movieId) {
    }
    
    private final void loadMovie() {
    }
    
    public final void toggleFavorite() {
    }
}