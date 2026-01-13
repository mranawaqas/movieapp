package com.example.moviesapp.di;

import com.example.moviesapp.data.api.MovieApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

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
public final class NetworkModule_ProvideMovieApiServiceFactory implements Factory<MovieApiService> {
  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvideMovieApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public MovieApiService get() {
    return provideMovieApiService(retrofitProvider.get());
  }

  public static NetworkModule_ProvideMovieApiServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideMovieApiServiceFactory(retrofitProvider);
  }

  public static MovieApiService provideMovieApiService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideMovieApiService(retrofit));
  }
}
