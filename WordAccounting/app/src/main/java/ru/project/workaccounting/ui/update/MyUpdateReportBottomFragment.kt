package ru.project.workaccounting.ui.update

import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.room.Room
import com.google.android.gms.location.LocationServices
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.osmdroid.util.GeoPoint
import ru.project.workaccounting.R
import ru.project.workaccounting.data.arrays.Permissions
import ru.project.workaccounting.data.database.MyRoomManager
import ru.project.workaccounting.databinding.UpdateReportBinding
import ru.project.workaccounting.domain.models.*
import ru.project.workaccounting.domain.usecase.GetDateTimeUseCase
import java.util.*

class MyUpdateReportBottomFragment(var report_: Report?): BottomSheetDialogFragment() {
    private lateinit var binding: UpdateReportBinding
    private lateinit var db: MyRoomManager
    private val getDateTime = GetDateTimeUseCase()

    override fun getTheme(): Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = UpdateReportBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = Room.databaseBuilder(
            view.context,
            MyRoomManager::class.java,
            "database"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()

        binding.updateReport.setOnClickListener {
            suspend {
                withContext(Dispatchers.IO) {
                db.reportDAO().updateReport(report_!!)
            }
            }

            onStop()
        }

        initSpinner(
            context = view.context,
            spinner = binding.spinerWork
        )
        println(db.reportDAO().getReportAll())
        try {
            setReport(report_!!)
        } catch (npe: java.lang.NullPointerException) {}
    }


    private fun setReport(report: Report) {
        val adapterSpinner = ArrayAdapter.createFromResource(
            context?.applicationContext!!,
            R.array.WorkList,
            android.R.layout.simple_spinner_item
        )
        binding.apply {
            val nameWork = adapterSpinner.getPosition(report.work.workName)
            spinerWork.setSelection(nameWork)
            workerName.setText(report.worker)
            workSize.setText(report.work.sizeWork.toString())
        }
    }

    private fun initSpinner(
        context: Context,
        spinner: Spinner
    ) {
        ArrayAdapter.createFromResource(
            context.applicationContext!!,
            R.array.WorkList,
            android.R.layout.simple_spinner_item
        ).also {
            spinnerAdapter -> spinnerAdapter.apply {
                setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            }
            spinner.adapter = spinnerAdapter
        }
    }

}
