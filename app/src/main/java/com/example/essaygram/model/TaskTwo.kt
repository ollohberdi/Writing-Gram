package com.example.essaygram.model

import java.io.Serializable
class TaskTwo {
    var author: String? = null
    var question: String? = null
    var essay: String? = null
    var bandScore: String? = null

    constructor()
    constructor(author: String?, question: String?, essay: String?, bandScore: String?) {
        this.author = author
        this.question = question
        this.essay = essay
        this.bandScore = bandScore
    }


}