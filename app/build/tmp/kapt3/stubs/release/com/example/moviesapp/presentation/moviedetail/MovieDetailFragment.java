package com.example.moviesapp.presentation.moviedetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.bumptech.glide.Glide;
import com.example.moviesapp.R;
import com.example.moviesapp.data.model.Movie;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020#H\u0002J&\u0010$\u001a\u0004\u0018\u00010\n2\u0006\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001a\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010-\u001a\u00020#2\u0006\u0010,\u001a\u00020\nH\u0002J\u0010\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020#2\u0006\u00102\u001a\u000203H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f\u00a8\u00064"}, d2 = {"Lcom/example/moviesapp/presentation/moviedetail/MovieDetailFragment;", "Landroidx/fragment/app/Fragment;", "()V", "args", "Lcom/example/moviesapp/presentation/moviedetail/MovieDetailFragmentArgs;", "getArgs", "()Lcom/example/moviesapp/presentation/moviedetail/MovieDetailFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "contentScrollView", "Landroid/view/View;", "fabFavorite", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "movieDescription", "Landroid/widget/TextView;", "movieDirector", "movieOriginalTitle", "moviePoster", "Landroid/widget/ImageView;", "movieProducer", "movieReleaseDate", "movieRtScore", "movieRunningTime", "movieTitle", "progressBar", "Landroid/widget/ProgressBar;", "toolbar", "Lcom/google/android/material/appbar/MaterialToolbar;", "viewModel", "Lcom/example/moviesapp/presentation/moviedetail/MovieDetailViewModel;", "getViewModel", "()Lcom/example/moviesapp/presentation/moviedetail/MovieDetailViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "observeViewModel", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupViews", "showMovieDetails", "movie", "Lcom/example/moviesapp/data/model/Movie;", "updateFavoriteButton", "isFavorite", "", "app_release"})
public final class MovieDetailFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull
    private final androidx.navigation.NavArgsLazy args$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    private com.google.android.material.appbar.MaterialToolbar toolbar;
    private android.widget.ProgressBar progressBar;
    private android.view.View contentScrollView;
    private android.widget.ImageView moviePoster;
    private android.widget.TextView movieTitle;
    private android.widget.TextView movieOriginalTitle;
    private android.widget.TextView movieReleaseDate;
    private android.widget.TextView movieDirector;
    private android.widget.TextView movieProducer;
    private android.widget.TextView movieRunningTime;
    private android.widget.TextView movieRtScore;
    private android.widget.TextView movieDescription;
    private com.google.android.material.floatingactionbutton.FloatingActionButton fabFavorite;
    
    public MovieDetailFragment() {
        super();
    }
    
    private final com.example.moviesapp.presentation.moviedetail.MovieDetailFragmentArgs getArgs() {
        return null;
    }
    
    private final com.example.moviesapp.presentation.moviedetail.MovieDetailViewModel getViewModel() {
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
    
    private final void observeViewModel() {
    }
    
    private final void showMovieDetails(com.example.moviesapp.data.model.Movie movie) {
    }
    
    private final void updateFavoriteButton(boolean isFavorite) {
    }
}