package com.example.moviesapp.data.repository;

import com.example.moviesapp.data.api.MovieApiService;
import com.example.moviesapp.data.database.MovieDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class MovieRepositoryImpl_Factory implements Factory<MovieRepositoryImpl> {
  private final Provider<MovieApiService> movieApiServiceProvider;

  private final Provider<MovieDao> movieDaoProvider;

  public MovieRepositoryImpl_Factory(Provider<MovieApiService> movieApiServiceProvider,
      Provider<MovieDao> movieDaoProvider) {
    this.movieApiServiceProvider = movieApiServiceProvider;
    this.movieDaoProvider = movieDaoProvider;
  }

  @Override
  public MovieRepositoryImpl get() {
    return newInstance(movieApiServiceProvider.get(), movieDaoProvider.get());
  }

  public static MovieRepositoryImpl_Factory create(
      Provider<MovieApiService> movieApiServiceProvider, Provider<MovieDao> movieDaoProvider) {
    return new MovieRepositoryImpl_Factory(movieApiServiceProvider, movieDaoProvider);
  }

  public static MovieRepositoryImpl newInstance(MovieApiService movieApiService,
      MovieDao movieDao) {
    return new MovieRepositoryImpl(movieApiService, movieDao);
  }
}
