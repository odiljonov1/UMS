package com.example.ums.Models

import java.io.Serializable

class MinutesModel {

    var minutes = ""
    var code = ""
    var desc = ""

    constructor(minutes: String, code: String, desc: String) {
        this.minutes = minutes
        this.code = code
        this.desc = desc
    }

}


class TarifModel : Serializable {

    var name = ""
    var code = ""
    var desc = ""

    constructor(name: String, code: String, desc: String) {
        this.name = name
        this.code = code
        this.desc = desc
    }
}