package ru.project.workaccounting.data.database

import androidx.room.*
import ru.project.workaccounting.data.dao.ReportDAO
import ru.project.workaccounting.domain.models.Report
import ru.project.workaccounting.ui.map.*
import ru.project.workaccounting.ui.reports.DateTimeConverter


@TypeConverters(
    WorkConverter::class,
    GeoPointConverter::class,
    DateTimeConverter::class
)
@Database(
    entities = [Report::class],
    version = 1
)
abstract class MyRoomManager: RoomDatabase() {
    abstract fun reportDAO(): ReportDAO
}
