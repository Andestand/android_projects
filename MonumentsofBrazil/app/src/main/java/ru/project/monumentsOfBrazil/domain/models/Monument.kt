package ru.project.monumentsOfBrazil.domain.models

import java.io.Serializable

data class Monument(
    val id: Int,
    val image: Int,
    val title: String,
    val description: String,
    val datetime: String
): Serializable
