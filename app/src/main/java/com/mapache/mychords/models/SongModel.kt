package com.mapache.mychords.models

data class SongModel(
    val id_song: Int,
    val artist: String,
    val user: String,
    val name: String,
    var intro: String = "",
    var strophe: String = "",
    var pre_chorus: String = "",
    var chorus: String = "",
    var bridge: String = "",
    var solo: String = "",
    var final_chorus: String = "",
    var final: String = ""
)