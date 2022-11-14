package com.example.listapelisconget.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listapelisconget.Peliculas.Result
import com.example.listapelisconget.R


class PeliAdapter(var images:List<Result>): RecyclerView.Adapter<PelisViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PelisViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PelisViewHolder(layoutInflater.inflate(R.layout.item_film, parent, false))
    }

    override fun onBindViewHolder(holder: PelisViewHolder, position: Int) {
        val item = images[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = images.size

}