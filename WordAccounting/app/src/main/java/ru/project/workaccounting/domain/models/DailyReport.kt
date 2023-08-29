package ru.project.workaccounting.domain.models

import org.osmdroid.util.GeoPoint

data class DailyReport(
    val id: Long,
    val datetime: String,
    val geoData: GeoPoint
)
