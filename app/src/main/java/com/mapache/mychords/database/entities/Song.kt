package com.mapache.mychords.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "song")
data class Song(
    @PrimaryKey
    val id_song: Int = -1,
    val id_artist: Int = -1,
    val id_user: Int = -1,
    val name: String = "",
    val intro: String = "",
    val strophe: String = "",
    val pre_chorus: String = "",
    val chorus: String = "",
    val bridge: String = "",
    val solo: String = "",
    val final_chorus: String = "",
    val final: String = ""
)