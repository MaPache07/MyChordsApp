package com.mapache.mychords.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mapache.mychords.database.entities.Song

@Dao
interface SongDAO {

    @Insert
    suspend fun insert(song: Song)

    @Query("SELECT * FROM song")
    fun getAllSong(): LiveData<List<Song>>

    @Query("SELECT * FROM song WHERE id_song = :id")
    fun getSong(id: Int): Song

    @Query("SELECT * FROM song WHERE id_artist = :idArtist")
    fun getSongsWithArtist(idArtist: Int): LiveData<List<Song>>

    @Query("SELECT * FROM song WHERE id_user = :idUser")
    fun getSongsWithUser(idUser: Int): LiveData<List<Song>>

    @Query("DELETE FROM song")
    suspend fun nukeTable()
}