package com.turgunboyevjurabek.startup.madels

class User2 {
    var id:Int?=null
    var ismi:String?=null


    constructor(id: Int?, ismi: String?) {
        this.id = id
        this.ismi = ismi
    }

    constructor(ismi: String?) {
        this.ismi = ismi
    }
}