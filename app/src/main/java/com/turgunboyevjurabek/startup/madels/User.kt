package com.turgunboyevjurabek.startup.madels

class User:java.io.Serializable {
    var nomi:String?=null
    var description:String?=null
    var gifImage:Int?=null

    constructor(nomi:String?,description:String?,gifImage:Int?){
        this.nomi=nomi
        this.description=description
        this.gifImage=gifImage
    }

    constructor(nomi: String?, description: String?) {
        this.nomi = nomi
        this.description = description
    }


}