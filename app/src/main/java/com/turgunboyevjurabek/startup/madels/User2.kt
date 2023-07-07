package com.turgunboyevjurabek.startup.madels

import java.text.SimpleDateFormat
import java.util.Date

class User2 {
    var id:Int?=null
    var ismi:String?=null
    var cup1:Int=0
    var cup2:Int=0
    var cup:Int=0
    constructor(id: Int?, ismi: String?) {
        this.id = id
        this.ismi = ismi
    }

    constructor(ismi: String?) {
        this.ismi = ismi
    }

    constructor()
    constructor(ismi: String?, cup1: Int, cup2: Int) {
        this.ismi = ismi
        this.cup1 = cup1
        this.cup2 = cup2
    }

    constructor(id: Int?, ismi: String?, cup1: Int, cup2: Int, cup: Int) {
        this.id = id
        this.ismi = ismi
        this.cup1 = cup1
        this.cup2 = cup2
        this.cup = cup
    }

    constructor(ismi: String?, cup1: Int, cup2: Int, cup: Int) {
        this.ismi = ismi
        this.cup1 = cup1
        this.cup2 = cup2
        this.cup = cup
    }


}