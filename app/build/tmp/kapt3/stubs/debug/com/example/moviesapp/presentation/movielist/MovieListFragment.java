package com.example.moviesapp.presentation.movielist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.moviesapp.data.model.Movie;
import com.example.moviesapp.databinding.FragmentMovieListBinding;
import com.example.moviesapp.presentation.common.MovieFilter;
import com.example.moviesapp.presentation.common.UiState;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u000fH\u0002J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u000fH\u0016J\u001a\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010#\u001a\u00020\u000fH\u0002J\b\u0010$\u001a\u00020\u000fH\u0002J\b\u0010%\u001a\u00020\u000fH\u0002J\b\u0010&\u001a\u00020\u000fH\u0002J\u0012\u0010\'\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\b\u0010*\u001a\u00020\u000fH\u0002J\u0016\u0010+\u001a\u00020\u000f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0010\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020/H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\u00a8\u00060"}, d2 = {"Lcom/example/moviesapp/presentation/movielist/MovieListFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/example/moviesapp/databinding/FragmentMovieListBinding;", "binding", "getBinding", "()Lcom/example/moviesapp/databinding/FragmentMovieListBinding;", "viewModel", "Lcom/example/moviesapp/presentation/movielist/MovieListViewModel;", "getViewModel", "()Lcom/example/moviesapp/presentation/movielist/MovieListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "handleUiState", "", "state", "Lcom/example/moviesapp/presentation/common/UiState;", "", "Lcom/example/moviesapp/data/model/Movie;", "hideLoading", "navigateToMovieDetail", "movie", "observeViewModel", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupChips", "setupRecyclerView", "setupViews", "showEmpty", "showError", "message", "", "showLoading", "showMovies", "movies", "updateFilterChips", "filter", "Lcom/example/moviesapp/presentation/common/MovieFilter;", "app_debug"})
public final class MovieListFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.Nullable
    private com.example.moviesapp.databinding.FragmentMovieListBinding _binding;
    
    public MovieListFragment() {
        super();
    }
    
    private final com.example.moviesapp.presentation.movielist.MovieListViewModel getViewModel() {
        return null;
    }
    
    private final com.example.moviesapp.databinding.FragmentMovieListBinding getBinding() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupViews() {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void setupChips() {
    }
    
    private final void observeViewModel() {
    }
    
    private final void handleUiState(com.example.moviesapp.presentation.common.UiState<? extends java.util.List<com.example.moviesapp.data.model.Movie>> state) {
    }
    
    private final void showLoading() {
    }
    
    private final void hideLoading() {
    }
    
    private final void showError(java.lang.String message) {
    }
    
    private final void showEmpty() {
    }
    
    private final void showMovies(java.util.List<com.example.moviesapp.data.model.Movie> movies) {
    }
    
    private final void updateFilterChips(com.example.moviesapp.presentation.common.MovieFilter filter) {
    }
    
    private final void navigateToMovieDetail(com.example.moviesapp.data.model.Movie movie) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}