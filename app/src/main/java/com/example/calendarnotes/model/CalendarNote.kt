package com.example.calendarnotes.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "calendar_notes")
data class CalendarNote(
    @PrimaryKey val id: String,
    val date: Long,
    val description: String,
    val colorCode: String
)