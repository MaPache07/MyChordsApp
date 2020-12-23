package com.mapache.mychords.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mapache.mychords.database.daos.ArtistDAO
import com.mapache.mychords.database.daos.SongDAO
import com.mapache.mychords.database.entities.Artist
import com.mapache.mychords.database.entities.Song

@Database(entities = arrayOf(Song::class, Artist::class), version = 1)
public abstract class RoomDB: RoomDatabase() {

    abstract fun songDao(): SongDAO
    abstract fun artistDao(): ArtistDAO

    companion object{

        @Volatile
        private var INSTANCE: RoomDB? = null

        fun getDatabase(context: Context): RoomDB{
            val tempInstance = INSTANCE
            if(tempInstance != null) return tempInstance

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDB::class.java,
                    "chords_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}