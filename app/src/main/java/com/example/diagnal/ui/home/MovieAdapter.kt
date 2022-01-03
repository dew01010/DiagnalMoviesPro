package com.example.diagnal.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.diagnal.data.model.Movies
import com.example.diagnal.databinding.ItemMovieBinding

class MovieAdapter : PagingDataAdapter<Movies, MovieAdapter.ViewHolder>(Diff) {

    inner class ViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Movies) {
            binding.name.text = item.name
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    private object Diff : DiffUtil.ItemCallback<Movies>() {
        override fun areItemsTheSame(oldItem: Movies, newItem: Movies) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Movies, newItem: Movies) =
            oldItem.equals(newItem)
    }

}