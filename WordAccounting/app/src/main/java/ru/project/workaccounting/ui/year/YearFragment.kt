package ru.project.workaccounting.ui.year

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.room.Room
import ru.project.workaccounting.R
import ru.project.workaccounting.data.arrays.Reports
import ru.project.workaccounting.data.database.MyRoomManager
import ru.project.workaccounting.databinding.FragmentYearBinding
import ru.project.workaccounting.ui.reports.ReportsAdapter


class YearFragment : Fragment() {
    private lateinit var binding: FragmentYearBinding
    private val adapterYear = ReportsAdapter()
    private lateinit var db: MyRoomManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentYearBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        db = Room.databaseBuilder(
            view.context,
            MyRoomManager::class.java,
            "database"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
        init()
    }

    private fun init() {
        adapterYear.fragmentManager = fragmentManager!!

        binding.rvYear.apply {
            layoutManager = GridLayoutManager(context, 1)

            adapterYear.sortDataYear(db.reportDAO().getReportAll())

            adapter = adapterYear


        }
    }
}