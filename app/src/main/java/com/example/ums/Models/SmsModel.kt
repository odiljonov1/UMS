package com.example.ums.Models

import java.io.Serializable

class SmsModel : Serializable {

    var name = ""
    var code = ""
    var desc = ""

    constructor(name: String, code: String, desc: String) {
        this.name = name
        this.code = code
        this.desc = desc
    }
}