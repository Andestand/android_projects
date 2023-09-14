package ru.project.workaccounting.ui.map

import androidx.room.TypeConverter
import ru.project.workaccounting.domain.models.Work
import java.util.stream.Collectors

class WorkConverter {
    @TypeConverter
    fun fromWork(work: Work): String {
        return "${work.workName},${work.sizeWork}"
    }

    @TypeConverter
    fun toWork(work: String): Work {
        val (workName, sizeWork) = work.split(",")
        return Work(
            workName = workName,
            sizeWork = sizeWork.toInt()
        )
    }
}