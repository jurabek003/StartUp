package com.turgunboyevjurabek.startup.DataBase

import User
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.turgunboyevjurabek.startup.adapters.RvGameMain

class DataBase(context: Context):SQLiteOpenHelper(context,"Allambalo",null,6),UserDao {
    override fun onCreate(db: SQLiteDatabase?) {
        val query="create table UserTable(id integer not null primary key  autoincrement unique, nomi text not null , description text not null, image text not null, number integer not null,game integer not null, gameMemory text not null, gameTrue integer not null, gameFalse integer not null, Gnomi text not null )"
        //val query2="create table GamesTable(id integer not null primary key autoincrement unique, game integer not null, gameMemory text not null, gameTrue integer not null, gameFalse integer not null, Gnomi text not null) "
        db?.execSQL(query)
       // db?.execSQL(query2)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}
    override fun getItems(): ArrayList<User> {
        val list=ArrayList<User>()
        val db=readableDatabase
        val query="select *from UserTable"
        val cursor=db.rawQuery(query,null)
        if (cursor.moveToFirst()){
            do {
                val user=User(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4)
                )
                list.add(user)
            }while (cursor.moveToNext())
        }
        return list
    }
    override fun insertItem(user: User) {
        val db=writableDatabase
        val contentValues=ContentValues()
        contentValues.put("nomi",user.nomi)
        contentValues.put("description",user.description)
        contentValues.put("image",user.gifImage)
        contentValues.put("number",user.nomeri)
        contentValues.put("game",user.game )
        contentValues.put("gameMemory",user.gameMemory)
        contentValues.put("gameTrue",user.gameTrue)
        contentValues.put("gameFalse",user.gameFalse)
        contentValues.put("Gnomi",user.Gnomi)
        db.insert("UserTable",null,contentValues)
        db.isOpen
    }

    override fun getitemSelect(number2:Int?): ArrayList<User> {
        val list=ArrayList<User>()
        val db=readableDatabase
        val query="select *from UserTable where  number = ?"
        val cursor=db.rawQuery(query, arrayOf(number2.toString()))
        if (cursor.moveToFirst()){
            do {
                val user=User(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4),
                    cursor.getInt(5),
                    cursor.getString(6),
                    cursor.getInt(6),
                    cursor.getInt(7),
                    cursor.getString(6)
                )
                list.add(user)
            }while (cursor.moveToNext())
        }
        return list
    }
    override fun searchItem(searchQuery:String): ArrayList<User> {
        val list=ArrayList<User>()
        val db=readableDatabase
        val query="select *from UserTable where nomi LIKE '%' || :searchQuery  || '%' OR description LIKE '%' || :searchQuery  "
        val cursor=db.rawQuery(query, arrayOf(searchQuery.toString()))
        if (cursor.moveToFirst()){
            do {
                val user=User(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4)
                )
                list.add(user)
            }while (cursor.moveToNext())
        }
        return list
    }

    override fun gameSelectItem(gameson: Int): ArrayList<User> {
        val list=ArrayList<User>()
        val db=readableDatabase
        val query="select *from UserTable where game = ?"
        val cursor=db.rawQuery(query, arrayOf(gameson.toString()))
        if (cursor.moveToFirst()){
                do {
                    val user=User(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4),
                        cursor.getInt(5),
                        cursor.getString(6),
                        cursor.getInt(7),
                        cursor.getInt(8),
                        cursor.getString(9)
                    )
                    list.add(user)
                }while (cursor.moveToNext())
        }
        return list
    }

}