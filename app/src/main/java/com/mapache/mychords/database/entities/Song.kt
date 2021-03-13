package com.mapache.mychords.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "song")
data class Song(
    @PrimaryKey
    var id_song: Int = -1,
    var id_artist: Int = -1,
    var id_user: Int = -1,
    var name: String = "",
    var intro: String = "",
    var strophe: String = "",
    var pre_chorus: String = "",
    var chorus: String = "",
    var bridge: String = "",
    var solo: String = "",
    var final_chorus: String = "",
    var final: String = ""
)