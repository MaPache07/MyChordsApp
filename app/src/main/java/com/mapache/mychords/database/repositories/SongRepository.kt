package com.mapache.mychords.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.mapache.mychords.database.daos.ArtistDAO
import com.mapache.mychords.database.daos.SongDAO
import com.mapache.mychords.database.entities.Artist
import com.mapache.mychords.database.entities.Song

class SongRepository(private val songDAO: SongDAO, private val artistDAO: ArtistDAO) {

    val allSongs: LiveData<List<Song>> = songDAO.getAllSong()
    val allArtist: LiveData<List<Artist>> = artistDAO.getAllArtist()

    @WorkerThread
    suspend fun insertSong(song: Song){
        songDAO.insert(song)
    }

    @WorkerThread
    suspend fun insertArtist(artist: Artist){
        artistDAO.insert(artist)
    }

    fun getSong(id: Int) = songDAO.getSong(id)

    fun getArtist(id: Int) = artistDAO.getArtist(id)

    fun getSongsWithArtist(idArtist: Int) = songDAO.getSongsWithArtist(idArtist)

    fun getSongsWithUser(idUser: Int) = songDAO.getSongsWithUser(idUser)

    @WorkerThread
    suspend fun nukeSong(){
        return songDAO.nukeTable()
    }

    @WorkerThread
    suspend fun nukeArtist(){
        return artistDAO.nukeTable()
    }
}