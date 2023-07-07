package com.turgunboyevjurabek.startup.madels

import java.text.SimpleDateFormat
import java.util.Date

class User2 {
    var id:Int?=null
    var ismi:String?=null
    var gameMemory2: String = SimpleDateFormat("dd.MM.yyyy_hh:mm:ss").format(Date())

    constructor(id: Int?, ismi: String?) {
        this.id = id
        this.ismi = ismi
    }

    constructor(ismi: String?) {
        this.ismi = ismi
    }

    constructor(id: Int?, ismi: String?, gameMemory2: String) {
        this.ismi = ismi
        this.gameMemory2 = gameMemory2
    }
}