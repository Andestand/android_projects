package ru.project.workaccounting.domain.models

import org.osmdroid.util.GeoPoint

data class Report(
    val id: Long,
    val datetime: String,
    val address: String
)
