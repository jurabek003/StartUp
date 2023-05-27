package com.turgunboyevjurabek.startup.DataBase

import User
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class RommDataBase:RoomDatabase() {

    abstract fun userDao():UserDao

    companion object{
        fun newInstens(context: Context):RommDataBase{
            return Room.databaseBuilder(context,RommDataBase::class.java,"rja")
                .allowMainThreadQueries()
                .build()
        }
    }

}