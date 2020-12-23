package com.mapache.mychords.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artist")
data class Artist(
    @PrimaryKey
    val idArtist: Int,
    val name: String
)