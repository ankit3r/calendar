package com.example.calendarnotes.application

import android.app.Application
import com.example.calendarnotes.repository.MyRepo
import com.example.calendarnotes.room.AppDatabase

class MyApp : Application() {
    lateinit var myRepo: MyRepo
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize(){
        val dao = AppDatabase.getDatabase(applicationContext).calendarNoteDao()
        myRepo = MyRepo(dao)
    }
}