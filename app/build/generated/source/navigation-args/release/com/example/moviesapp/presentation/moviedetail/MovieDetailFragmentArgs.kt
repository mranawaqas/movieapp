package com.example.moviesapp.presentation.moviedetail

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class MovieDetailFragmentArgs(
  public val movieId: String,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("movieId", this.movieId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("movieId", this.movieId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): MovieDetailFragmentArgs {
      bundle.setClassLoader(MovieDetailFragmentArgs::class.java.classLoader)
      val __movieId : String?
      if (bundle.containsKey("movieId")) {
        __movieId = bundle.getString("movieId")
        if (__movieId == null) {
          throw IllegalArgumentException("Argument \"movieId\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"movieId\" is missing and does not have an android:defaultValue")
      }
      return MovieDetailFragmentArgs(__movieId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): MovieDetailFragmentArgs {
      val __movieId : String?
      if (savedStateHandle.contains("movieId")) {
        __movieId = savedStateHandle["movieId"]
        if (__movieId == null) {
          throw IllegalArgumentException("Argument \"movieId\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"movieId\" is missing and does not have an android:defaultValue")
      }
      return MovieDetailFragmentArgs(__movieId)
    }
  }
}
