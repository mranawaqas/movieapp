package com.example.moviesapp.presentation.movielist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.example.moviesapp.R;
import com.example.moviesapp.data.model.Movie;
import com.example.moviesapp.presentation.common.MovieFilter;
import com.example.moviesapp.presentation.common.UiState;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001eH\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020 H\u0002J\b\u0010$\u001a\u00020\u001cH\u0002J&\u0010%\u001a\u0004\u0018\u00010\u000b2\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001a\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010.\u001a\u00020\u001cH\u0002J\b\u0010/\u001a\u00020\u001cH\u0002J\u0010\u00100\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u000bH\u0002J\b\u00101\u001a\u00020\u001cH\u0002J\u0012\u00102\u001a\u00020\u001c2\b\u00103\u001a\u0004\u0018\u000104H\u0002J\b\u00105\u001a\u00020\u001cH\u0002J\u0016\u00106\u001a\u00020\u001c2\f\u00107\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\u0010\u00108\u001a\u00020\u001c2\u0006\u00109\u001a\u00020:H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006;"}, d2 = {"Lcom/example/moviesapp/presentation/movielist/MovieListFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/example/moviesapp/presentation/movielist/MovieAdapter;", "chipAll", "Lcom/google/android/material/chip/Chip;", "chipFavorites", "emptyMessage", "Landroid/widget/TextView;", "errorLayout", "Landroid/view/View;", "errorMessage", "progressBar", "Landroid/widget/ProgressBar;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "retryButton", "Lcom/google/android/material/button/MaterialButton;", "swipeRefreshLayout", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "viewModel", "Lcom/example/moviesapp/presentation/movielist/MovieListViewModel;", "getViewModel", "()Lcom/example/moviesapp/presentation/movielist/MovieListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "handleUiState", "", "state", "Lcom/example/moviesapp/presentation/common/UiState;", "", "Lcom/example/moviesapp/data/model/Movie;", "hideLoading", "navigateToMovieDetail", "movie", "observeViewModel", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupChips", "setupRecyclerView", "setupViews", "showEmpty", "showError", "message", "", "showLoading", "showMovies", "movies", "updateFilterChips", "filter", "Lcom/example/moviesapp/presentation/common/MovieFilter;", "app_release"})
public final class MovieListFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    private com.example.moviesapp.presentation.movielist.MovieAdapter adapter;
    private android.widget.ProgressBar progressBar;
    private android.view.View errorLayout;
    private android.widget.TextView errorMessage;
    private com.google.android.material.button.MaterialButton retryButton;
    private android.widget.TextView emptyMessage;
    private androidx.swiperefreshlayout.widget.SwipeRefreshLayout swipeRefreshLayout;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private com.google.android.material.chip.Chip chipAll;
    private com.google.android.material.chip.Chip chipFavorites;
    
    public MovieListFragment() {
        super();
    }
    
    private final com.example.moviesapp.presentation.movielist.MovieListViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
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
    
    private final void setupViews(android.view.View view) {
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
}