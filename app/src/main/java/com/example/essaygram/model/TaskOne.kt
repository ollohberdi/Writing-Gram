package com.example.essaygram.model

import java.io.Serializable

class TaskOne {
    var author: String? = null
    var questionImage: String? = null
    var question: String? = null
    var essay: String? = null
    var bandScore: String? = null

    constructor()
    constructor(
        author: String?,
        questionImage: String?,
        question: String?,
        essay: String?,
        bandScore: String?
    ) {
        this.author = author
        this.questionImage = questionImage
        this.question = question
        this.essay = essay
        this.bandScore = bandScore
    }
}
