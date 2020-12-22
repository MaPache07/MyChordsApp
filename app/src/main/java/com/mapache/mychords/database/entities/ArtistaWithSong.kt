package com.mapache.mychords.database.entities

import androidx.room.Embedded
import androidx.room.Relation

data class ArtistaWithSong(
    @Embedded val artist: Artist,
    @Relation(
        parentColumn = "idArtist",
        entityColumn = "idArtist"
    )
    val songs: List<Song>
)