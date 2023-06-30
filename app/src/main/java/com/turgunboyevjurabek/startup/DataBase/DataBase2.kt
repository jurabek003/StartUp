package com.turgunboyevjurabek.startup.DataBase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.turgunboyevjurabek.startup.madels.User2

class DataBase2(context: Context):SQLiteOpenHelper(context,"malumotlar bazasi 2",null,1),User2Dao {
    override fun onCreate(db: SQLiteDatabase?) {
        val query2="create table User2Table(id integer not null primary key autoincrement unique,ismi text not null)"
        db?.execSQL(query2)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    override fun insertItem(user2: User2) {
        val db=writableDatabase
        val contentValues=ContentValues()
        contentValues.put("ismi",user2.ismi)
        db.insert("User2Table",null,contentValues)
        db.close()
    }

    override fun getItems(): ArrayList<User2> {
        val db=readableDatabase
        val list=ArrayList<User2>()
        val query="select *from User2Table"
        val cursor=db.rawQuery(query,null)
        if (cursor.moveToFirst()){
            do {
                val user2=User2(
                    cursor.getInt(0),
                    cursor.getString(1)
                )
                list.add(user2)
            }while (cursor.moveToNext())
        }
       return list
    }
}