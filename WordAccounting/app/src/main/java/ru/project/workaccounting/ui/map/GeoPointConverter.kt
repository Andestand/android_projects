package ru.project.workaccounting.ui.map

import androidx.room.TypeConverter
import org.osmdroid.util.GeoPoint
import java.util.*
import java.util.stream.Collectors

class GeoPointConverter {
    @TypeConverter
    fun fromGeoPoint(geoPoint: GeoPoint): String {
        return "${geoPoint.latitude},${geoPoint.longitude}"
    }

    @TypeConverter
    fun toGeoPoint(geoPoint: String): GeoPoint {
        val (latitude, longitude) = geoPoint.split(",")
        return GeoPoint(
            latitude.toDouble(),
            longitude.toDouble()
        )
    }
}