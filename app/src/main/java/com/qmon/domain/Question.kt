package com.qmon.domain

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Question(
    val question: String,
    val answers: List<String>
)
