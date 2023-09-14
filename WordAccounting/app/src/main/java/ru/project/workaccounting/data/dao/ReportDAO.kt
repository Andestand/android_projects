package ru.project.workaccounting.data.dao


import androidx.room.*
import ru.project.workaccounting.domain.models.Report

@Dao
interface ReportDAO {

    @Query("SELECT * FROM report")
    fun getReportAll(): List<Report>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addReport(report: Report): Long

    @Delete
    fun deleteReport(vararg report: Report)

    @Update
    fun updateReport(report: Report)
}