package com.example.calendarnotes.repository

import android.database.sqlite.SQLiteConstraintException
import android.util.Log
import com.example.calendarnotes.model.CalendarNote
import com.example.calendarnotes.room.CalendarNoteDao

class MyRepo(private val dao: CalendarNoteDao) {
    suspend fun addNote(note: CalendarNote, responce: (Boolean, String) -> Unit) {
        try {
            dao.insert(note)
            responce(true, "success")
        } catch (e: SQLiteConstraintException) {
            responce(false, e.message.toString())
        }
    }

    suspend fun updateNote(note: CalendarNote, responce: (Boolean, String) -> Unit) {
        try {
            dao.update(note)
            responce(true, "success")
        } catch (e: SQLiteConstraintException) {
            responce(false, e.message.toString())
        }
    }

    suspend fun deleteNote(note: CalendarNote, responce: (Boolean, String) -> Unit) {
        try {
            dao.delete(note)
            responce(true, "success")
        } catch (e: SQLiteConstraintException) {
            responce(false, e.message.toString())
        }
    }

    suspend fun getNotes(): List<CalendarNote> {
        return try {
            dao.getAll()
        } catch (e: SQLiteConstraintException) {
            listOf()
        }
    }
}