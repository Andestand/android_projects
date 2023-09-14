package ru.project.workaccounting.ui.month

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
import ru.project.workaccounting.databinding.FragmentMonthBinding
import ru.project.workaccounting.ui.reports.ReportsAdapter


class MonthFragment : Fragment() {
    private lateinit var binding: FragmentMonthBinding
    private val adapterMonth = ReportsAdapter()
    private lateinit var db: MyRoomManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMonthBinding.inflate(layoutInflater)
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
        adapterMonth.fragmentManager = fragmentManager!!

        binding.rvMonth.apply {
            layoutManager = GridLayoutManager(context, 1)

            adapterMonth.sortDataMonth(db.reportDAO().getReportAll().toTypedArray())

            adapter = adapterMonth
        }
    }
}