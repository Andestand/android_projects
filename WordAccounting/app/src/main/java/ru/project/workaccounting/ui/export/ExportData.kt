package ru.project.workaccounting.ui.export

import android.app.AlertDialog.Builder
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import androidx.room.Room
import ru.project.workaccounting.R
import ru.project.workaccounting.data.arrays.Reports
import ru.project.workaccounting.data.database.MyRoomManager
import ru.project.workaccounting.databinding.ExportDataBinding
import ru.project.workaccounting.domain.models.Report
import ru.project.workaccounting.ui.reports.XlsxConverter

class ExportData: DialogFragment() {
    private lateinit var binding: ExportDataBinding
    private lateinit var db: MyRoomManager
    private val converter = XlsxConverter()

    override fun getTheme(): Int = 0

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = ExportDataBinding.inflate(layoutInflater)
        db = Room.databaseBuilder(
            context!!,
            MyRoomManager::class.java,
            "database"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()

        return Builder(context!!).create().apply {
            setView(binding.root)

            initSpinnerMonth(
                context = context,
                spinner = binding.monthSpinner
            )

            initSpinnerYear(
                context = context,
                spinner = binding.yearSpinner
            )

            exportData(
                button = binding.button,
                spinnerMonth = binding.monthSpinner,
                spinnerYear = binding.yearSpinner
            )
        }
    }
    val array = ArrayList<Report>()

    fun exportData(
        button: Button,
        spinnerMonth: Spinner,
        spinnerYear: Spinner
    ) = button.setOnClickListener {

        for (i in db.reportDAO().getReportAll()) {
            if (
                i.datetime.year == spinnerYear.selectedItem
                &&
                spinnerMonth.selectedItem == "За все месяцы"
            ) {
                array.add(i)
                val data = converter.convertToXlsx(array, filePath = "data.xls", context!!)
                println(data)
            } else if (
                i.datetime.year == spinnerYear.selectedItem
                &&
                i.datetime.idMonth == spinnerMonth.selectedItem
            ) {
                array.add(i)
                val data = converter.convertToXlsx(array, filePath = "data.xls", context!!)
                println(data)
            }
        }
        onStop()
    }

    private fun initSpinnerMonth(
        context: Context,
        spinner: Spinner
    ) = ArrayAdapter.createFromResource(
        context.applicationContext!!,
        R.array.months,
        android.R.layout.simple_spinner_item
    ).also {
            spinnerAdapter -> spinnerAdapter.apply {
        setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    }
        spinner.adapter = spinnerAdapter
    }

    private fun initSpinnerYear(
        context: Context,
        spinner: Spinner
    ) = ArrayAdapter.createFromResource(
        context.applicationContext!!,
        R.array.years,
        android.R.layout.simple_spinner_item
    ).also {
            spinnerAdapter -> spinnerAdapter.apply {
        setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    }
        spinner.adapter = spinnerAdapter
    }
}