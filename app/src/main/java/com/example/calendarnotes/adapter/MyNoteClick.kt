package com.example.calendarnotes.adapter

import com.example.calendarnotes.model.CalendarNote

interface MyNoteClick {
    fun onClickView(note:CalendarNote)
}