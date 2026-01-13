package com.example.moviesapp.presentation.movielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.data.model.Movie
import com.example.moviesapp.databinding.ItemMovieBinding

class MovieAdapter(
    private val onMovieClick: (Movie) -> Unit,
    private val onFavoriteClick: (Movie) -> Unit
) : ListAdapter<Movie, MovieAdapter.MovieViewHolder>(MovieDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }

    inner class MovieViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.movieTitle.text = movie.title
            binding.movieReleaseDate.text = movie.releaseDate

            // Show original title if different
            if (movie.originalTitle != movie.title) {
                binding.movieOriginalTitle.text = movie.originalTitle
                binding.movieOriginalTitle.visibility = android.view.View.VISIBLE
            } else {
                binding.movieOriginalTitle.visibility = android.view.View.GONE
            }

            // Load poster with Glide
            Glide.with(binding.root.context)
                .load(movie.image)
                .placeholder(android.R.color.background_light)
                .error(android.R.color.background_light)
                .into(binding.moviePoster)

            // Set favorite icon based on favorite status
            updateFavoriteIcon(movie.isFavorite)

            // Click listeners
            binding.root.setOnClickListener {
                onMovieClick(movie)
            }

            binding.favoriteButton.setOnClickListener {
                // Optimistically update the icon immediately
                val newFavoriteStatus = !movie.isFavorite
                updateFavoriteIcon(newFavoriteStatus)
                // Then call the callback to update the database
                onFavoriteClick(movie)
            }
        }

        private fun updateFavoriteIcon(isFavorite: Boolean) {
            val iconRes = if (isFavorite) {
                R.drawable.ic_favorite_filled
            } else {
                R.drawable.ic_favorite_border
            }
            binding.favoriteButton.setImageResource(iconRes)
        }
    }

    class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }
}
