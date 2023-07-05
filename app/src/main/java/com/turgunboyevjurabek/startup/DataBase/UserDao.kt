package com.turgunboyevjurabek.startup.DataBase

import User
import com.turgunboyevjurabek.startup.madels.GameUser

interface UserDao {

    fun getItems():ArrayList<User>

    fun insertItem(user:User)

    fun getitemSelect(number:Int?):ArrayList<User>

    fun searchItem(searchQuery:String):ArrayList<User>

    fun gameSelectItem(game:Int):ArrayList<User>

}