package com.qmon.domain

import kotlinx.serialization.Serializable

@Serializable
data class Question(
    val question: String,
    val answers: List<String>
)
