package com.example.calendarnotes.room

import androidx.room.*
import com.example.calendarnotes.model.CalendarNote



@Dao
interface CalendarNoteDao {
    @Insert
    suspend fun insert(note: CalendarNote)

    @Update
    suspend fun update(note: CalendarNote)

    @Delete
    suspend fun delete(note: CalendarNote)

    @Query("SELECT * FROM calendar_notes ORDER BY date ASC")
    suspend fun getAll(): List<CalendarNote>
}