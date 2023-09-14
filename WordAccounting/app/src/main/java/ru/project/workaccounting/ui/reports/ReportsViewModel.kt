package ru.project.workaccounting.ui.reports

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import ru.project.workaccounting.data.arrays.Reports
import ru.project.workaccounting.data.database.MyRoomManager

class ReportsViewModel: ViewModel() {
    private val adapterReports = ReportsAdapter()
    private lateinit var db: MyRoomManager

    fun initRV(
        context: Context,
        recyclerView: RecyclerView,
        fragmentManager: FragmentManager
    ) {
        db = Room.databaseBuilder(
            context,
            MyRoomManager::class.java,
            "database"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()

        adapterReports.fragmentManager = fragmentManager
        recyclerView.apply {
            layoutManager = GridLayoutManager(
                context,
                1
            )

            adapterReports.addReport(Reports.reports)

            adapter = adapterReports

        }
    }
}
