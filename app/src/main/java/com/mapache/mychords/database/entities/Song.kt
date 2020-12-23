package com.mapache.mychords.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "song")
data class Song(
    @PrimaryKey
    val idSong: Int,
    val idArtist: Int,
    val idUser: Int,
    val name: String,
    val parts: List<String>,
    val chords: List<List<String>>,
    val replay: List<Int>
)