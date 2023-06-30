package com.turgunboyevjurabek.startup.DataBase

import com.turgunboyevjurabek.startup.madels.User2

interface User2Dao {
     fun insertItem(user2: User2)
     fun getItems():ArrayList<User2>

}