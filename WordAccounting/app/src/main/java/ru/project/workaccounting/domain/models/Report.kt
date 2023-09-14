package ru.project.workaccounting.domain.models

import androidx.room.*
import org.osmdroid.util.GeoPoint
import ru.project.workaccounting.ui.map.GeoPointConverter
import ru.project.workaccounting.ui.map.WorkConverter


@Entity(
    tableName = "report"
)
data class Report(
    @PrimaryKey(
        autoGenerate = true
    ) val id: Long? = null,

    @ColumnInfo val worker: String,



    @ColumnInfo val work: Work,

    @ColumnInfo val datetime: DateTime,

    @ColumnInfo val address: String,

    @ColumnInfo val geoPoint: GeoPoint
)

