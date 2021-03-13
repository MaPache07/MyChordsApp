package com.mapache.mychords.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artist")
data class Artist(
    @PrimaryKey
    val id_artist: Int = -1,
    val name: String = ""
)