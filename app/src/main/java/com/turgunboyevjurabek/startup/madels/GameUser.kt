package com.turgunboyevjurabek.startup.madels

import java.text.SimpleDateFormat
import java.util.Date

class GameUser {

    var id:Int?=null

    var game:Int?=null

    var gameMemory: String = SimpleDateFormat("dd.MM.yyyy_hh:mm:ss").format(Date())

    var gameTrue:Int?=null

    var gameFalse:Int?=null

    var Gnomi:String?=null


    constructor(
        id: Int?,
        game: Int?,
        gameMemory: String,
        gameTrue: Int?,
        gameFalse: Int?,
        Gnomi: String?,
    ) {
        this.id = id
        this.game = game
        this.gameMemory = gameMemory
        this.gameTrue = gameTrue
        this.gameFalse = gameFalse
        this.Gnomi = Gnomi
    }

    constructor(game: Int?, gameMemory: String, gameTrue: Int?, gameFalse: Int?, Gnomi: String?) {
        this.game = game
        this.gameMemory = gameMemory
        this.gameTrue = gameTrue
        this.gameFalse = gameFalse
        this.Gnomi = Gnomi
    }
}