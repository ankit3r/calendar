package com.example.calendarnotes.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.calendarnotes.model.CalendarNote

@Database(entities = [CalendarNote::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun calendarNoteDao(): CalendarNoteDao
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            synchronized(this) {
                if (INSTANCE == null) {
                    synchronized(this) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java,
                            "CalendarNote"
                        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
                    }
                }
            }
            return INSTANCE!!
        }
    }
}