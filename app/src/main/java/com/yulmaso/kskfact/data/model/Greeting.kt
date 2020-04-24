package com.yulmaso.kskfact.data.model

class Greeting {
    var id: Long? = null
    var text: String? = null

    constructor()

    constructor(id: Long, text: String) {
        this.id = id
        this.text = text
    }
}