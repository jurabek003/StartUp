
import android.net.Uri
import java.text.SimpleDateFormat
import java.util.Date

class User {


    var id: Int? = null

    var nomi: String? = null

    var description: String? = null

    var gifImage: String? = null

    var nomeri: Int? = null


    var game:Int?=null

    var gameMemory: String = SimpleDateFormat("dd.MM.yyyy_hh:mm:ss").format(Date())

    var gameTrue:Int?=null

    var gameFalse:Int?=null

    var Gnomi:String?=null

    constructor() {
        // Bo'sh konstruktor
    }

    constructor(nomi: String?, description: String?, gifImage: String?, nomeri: Int?) {
        this.nomi = nomi
        this.description = description
        this.gifImage = gifImage
        this.nomeri = nomeri
    }

    constructor(id: Int?, nomi: String?, description: String?, gifImage: String?, nomeri: Int?) {
        this.id = id
        this.nomi = nomi
        this.description = description
        this.gifImage = gifImage
        this.nomeri = nomeri
    }
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

    constructor(
        id: Int?,
        nomi: String?,
        description: String?,
        gifImage: String?,
        nomeri: Int?,
        game: Int?,
        gameMemory: String,
        gameTrue: Int?,
        gameFalse: Int?,
        Gnomi: String?,
    ) {
        this.id = id
        this.nomi = nomi
        this.description = description
        this.gifImage = gifImage
        this.nomeri = nomeri
        this.game = game
        this.gameMemory = gameMemory
        this.gameTrue = gameTrue
        this.gameFalse = gameFalse
        this.Gnomi = Gnomi
    }

    constructor(
        nomi: String?,
        description: String?,
        gifImage: String?,
        nomeri: Int?,
        game: Int?,
        gameMemory: String,
        gameTrue: Int?,
        gameFalse: Int?,
        Gnomi: String?,
    ) {
        this.nomi = nomi
        this.description = description
        this.gifImage = gifImage
        this.nomeri = nomeri
        this.game = game
        this.gameMemory = gameMemory
        this.gameTrue = gameTrue
        this.gameFalse = gameFalse
        this.Gnomi = Gnomi
    }

    override fun toString(): String {
        return "User(id=$id, nomi=$nomi, description=$description, gifImage=$gifImage, nomeri=$nomeri, game=$game, gameMemory='$gameMemory', gameTrue=$gameTrue, gameFalse=$gameFalse, Gnomi=$Gnomi)"
    }



}
