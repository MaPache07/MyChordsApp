package com.mapache.mychords.database.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.mapache.mychords.database.RoomDB
import com.mapache.mychords.database.entities.Artist
import com.mapache.mychords.database.entities.Song
import com.mapache.mychords.database.repositories.SongRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SongViewModel(private val app: Application) : AndroidViewModel(app){

    private val repository: SongRepository
    val allSongs: LiveData<List<Song>>
    val allArtist: LiveData<List<Artist>>

    init {
        val songDAO = RoomDB.getDatabase(app).songDao()
        val artistDAO = RoomDB.getDatabase(app).artistDao()

        repository = SongRepository(songDAO, artistDAO)
        allSongs = repository.allSongs
        allArtist = repository.allArtist
    }

    /* INSERTS */

    fun insertSong(song: Song) = viewModelScope.launch(Dispatchers.IO){
        repository.insertSong(song)
    }

    fun insertArtist(artist: Artist) = viewModelScope.launch(Dispatchers.IO){
        repository.insertArtist(artist)
    }

    /* GET's */

    fun getSong(id: Int) = repository.getSong(id)

    fun getArtist(id: Int) = repository.getArtist(id)

    fun getSongsWithArtist(idArtist: Int) = repository.getSongsWithArtist(idArtist)

    fun getSongsWithUser(idUser: Int) = repository.getSongsWithUser(idUser)

    /* NUKE TABLES */

    private suspend fun nukeSong() = repository.nukeSong()

    private suspend fun nukeArtist() = repository.nukeArtist()
}