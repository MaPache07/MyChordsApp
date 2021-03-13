package com.mapache.mychords.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mapache.mychords.R
import com.mapache.mychords.models.SongModel

class SongsAdapter(var songs: List<SongModel>, val clickListener: (SongModel) -> Unit) : RecyclerView.Adapter<SongsAdapter.SongHolder>(){

    private lateinit var view: View

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_song, parent, false)
        return SongHolder(view)
    }

    override fun onBindViewHolder(holder: SongHolder, position: Int) {
        holder.bind(songs[position], clickListener)
    }

    override fun getItemCount(): Int = songs.size

    fun dataChange(listaMatches: List<SongModel>){
        songs = listaMatches
        notifyDataSetChanged()
    }

    inner class SongHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(item: SongModel, clickListener: (SongModel) -> Unit) = with(itemView){
            itemView.findViewById<TextView>(R.id.item_song_name).text = item.name
            itemView.findViewById<TextView>(R.id.item_artist_name).text = item.artist
        }
    }
}