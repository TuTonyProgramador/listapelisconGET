package com.example.listapelisconget.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listapelisconget.databinding.ItemFilmBinding
import com.example.listapelisconget.Peliculas.Result

class PelisViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemFilmBinding.bind(view)

    fun bind(filmModel: Result){
        // Para mostrar el titulo de la pelicula
        binding.FilmName.text = filmModel.title

        // Para mostrar la imagen
        Glide.with(binding.FilmPhoto.context).load("https://image.tmdb.org/t/p/w185/${filmModel.poster_path}").into(binding.FilmPhoto)
    }
}