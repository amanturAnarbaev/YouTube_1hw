package com.example.youtube

import android.app.Application
import androidx.room.Room
import com.example.youtube.data.local.AppADataBase

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(applicationContext, AppADataBase::class.java, "playlist.db")
            .build()
    }

    companion object {
        lateinit var db: AppADataBase
    }
}