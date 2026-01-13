package com.example.moviesapp.presentation.movielist

import android.os.Bundle
import androidx.navigation.NavDirections
import com.example.moviesapp.R
import kotlin.Int
import kotlin.String

public class MovieListFragmentDirections private constructor() {
  private data class ActionMovieListToMovieDetail(
    public val movieId: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_movieList_to_movieDetail

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("movieId", this.movieId)
        return result
      }
  }

  public companion object {
    public fun actionMovieListToMovieDetail(movieId: String): NavDirections =
        ActionMovieListToMovieDetail(movieId)
  }
}
