package com.mapache.mychords.models

data class SongModel(
    val idSong: Int,
    val idArtist: Int,
    val idUser: Int,
    val name: String,
    val parts: List<String>,
    val chords: List<List<String>>,
    val replay: List<Int>
)