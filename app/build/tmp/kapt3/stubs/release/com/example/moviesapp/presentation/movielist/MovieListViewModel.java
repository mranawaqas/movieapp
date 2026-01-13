package com.example.moviesapp.presentation.movielist;

import androidx.lifecycle.ViewModel;
import com.example.moviesapp.data.model.Movie;
import com.example.moviesapp.domain.repository.MovieRepository;
import com.example.moviesapp.presentation.common.MovieFilter;
import com.example.moviesapp.presentation.common.UiState;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0006\u0010\u0017\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\bJ\b\u0010\u001b\u001a\u00020\u0015H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/example/moviesapp/presentation/movielist/MovieListViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/moviesapp/domain/repository/MovieRepository;", "(Lcom/example/moviesapp/domain/repository/MovieRepository;)V", "_allMovies", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/moviesapp/data/model/Movie;", "_favoriteMovies", "_filter", "Lcom/example/moviesapp/presentation/common/MovieFilter;", "_uiState", "Lcom/example/moviesapp/presentation/common/UiState;", "filter", "Lkotlinx/coroutines/flow/StateFlow;", "getFilter", "()Lkotlinx/coroutines/flow/StateFlow;", "uiState", "getUiState", "loadMovies", "", "observeFavorites", "retry", "setFilter", "toggleFavorite", "movie", "updateDisplayedMovies", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class MovieListViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.moviesapp.domain.repository.MovieRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.moviesapp.presentation.common.UiState<java.util.List<com.example.moviesapp.data.model.Movie>>> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.moviesapp.presentation.common.UiState<java.util.List<com.example.moviesapp.data.model.Movie>>> uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.moviesapp.presentation.common.MovieFilter> _filter = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.moviesapp.presentation.common.MovieFilter> filter = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.moviesapp.data.model.Movie>> _allMovies = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.moviesapp.data.model.Movie>> _favoriteMovies = null;
    
    @javax.inject.Inject
    public MovieListViewModel(@org.jetbrains.annotations.NotNull
    com.example.moviesapp.domain.repository.MovieRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.moviesapp.presentation.common.UiState<java.util.List<com.example.moviesapp.data.model.Movie>>> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.moviesapp.presentation.common.MovieFilter> getFilter() {
        return null;
    }
    
    private final void loadMovies() {
    }
    
    private final void observeFavorites() {
    }
    
    private final void updateDisplayedMovies() {
    }
    
    public final void setFilter(@org.jetbrains.annotations.NotNull
    com.example.moviesapp.presentation.common.MovieFilter filter) {
    }
    
    public final void toggleFavorite(@org.jetbrains.annotations.NotNull
    com.example.moviesapp.data.model.Movie movie) {
    }
    
    public final void retry() {
    }
}