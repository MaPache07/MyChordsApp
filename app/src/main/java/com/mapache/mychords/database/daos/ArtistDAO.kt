package com.mapache.mychords.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mapache.mychords.database.entities.Artist

@Dao
interface ArtistDAO {

    @Insert
    suspend fun insert(artist: Artist)

    @Query("SELECT * FROM artist")
    fun getAllArtist(): LiveData<List<Artist>>

    @Query("SELECT * FROM artist WHERE id_artist = :id")
    fun getArtist(id: Int): Artist

    @Query("DELETE FROM artist")
    suspend fun nukeTable()
}