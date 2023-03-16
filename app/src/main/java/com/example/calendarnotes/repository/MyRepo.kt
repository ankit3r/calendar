package com.example.calendarnotes.repository

import android.database.sqlite.SQLiteConstraintException
import android.util.Log
import com.example.calendarnotes.model.CalendarNote
import com.example.calendarnotes.room.CalendarNoteDao

class MyRepo(private val dao:CalendarNoteDao) {
    suspend fun addNote(note:CalendarNote){
        try {
            dao.insert(note)
        }catch (e: SQLiteConstraintException){
            Log.e("ANKIT",e.message.toString())
        }
    }
    suspend fun updateNote(note: CalendarNote){
        try {
            dao.update(note)
        }catch (e: SQLiteConstraintException){
            Log.e("ANKIT",e.message.toString())
        }
    }
    suspend fun deleteNote(note: CalendarNote){
        try {
            dao.delete(note)
        }catch (e: SQLiteConstraintException){
            Log.e("ANKIT",e.message.toString())
        }
    }
    suspend fun getNotes():List<CalendarNote>{
      try {
          return dao.getAll()
      }catch (e:SQLiteConstraintException){
          Log.e("ANKIT",e.message.toString())
          return listOf()
      }
    }
}