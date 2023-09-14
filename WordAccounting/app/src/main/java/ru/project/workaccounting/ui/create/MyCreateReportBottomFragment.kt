package ru.project.workaccounting.ui.create

import android.Manifest
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
import com.google.android.gms.location.*
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.osmdroid.util.GeoPoint
import ru.project.workaccounting.R
import ru.project.workaccounting.data.arrays.Permissions
import ru.project.workaccounting.data.database.MyRoomManager
import ru.project.workaccounting.databinding.CreateReportBinding
import ru.project.workaccounting.domain.models.*
import ru.project.workaccounting.domain.usecase.GetDateTimeUseCase
import java.util.*

class MyCreateReportBottomFragment: BottomSheetDialogFragment() {
    private lateinit var binding: CreateReportBinding
    private lateinit var db: MyRoomManager
    private val getDateTime = GetDateTimeUseCase()
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var locationCallback: LocationCallback

    override fun getTheme(): Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CreateReportBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = Room.databaseBuilder(
            view.context,
            MyRoomManager::class.java,
            "database"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
        getGeoData()
        binding.addReport.setOnClickListener {
            db.reportDAO().addReport(getReportData())
            onStop()
        }

        initSpinner(
            context = view.context,
            spinner = binding.spinerWork
        )

    }

    private lateinit var geoPoint: GeoPoint

    private fun getGeoData() {
        if (ContextCompat.checkSelfPermission(
                context!!,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context!!)
            locationCallback = object : LocationCallback() {
                override fun onLocationResult(p0: LocationResult) {
                    p0.let {
                        for (location in it.locations) {
                            println("latitude: ${location.latitude}, longitude: ${location.longitude}")

                            geoPoint = GeoPoint(
                                location.latitude,
                                location.longitude
                            )
                            fusedLocationProviderClient.removeLocationUpdates(locationCallback)
                            return
                        }
                    }
                    Log.w("geoDataError", "Не удалось получить текущие геоданные")
                    // Обработка случаев, когда не удалось получить текущие геоданные
                }
            }
            fusedLocationProviderClient.requestLocationUpdates(
                LocationRequest().apply {
                    priority = LocationRequest.PRIORITY_HIGH_ACCURACY
                    interval = 1000 // интервал в миллисекундах между обновлениями
                },
                locationCallback,
                null
            )
        } else {
            ActivityCompat.requestPermissions(
                this.activity!!,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                123
            )
        }
    }


    private fun getReportData(): Report {

        return Report(
            worker = binding.workerName.text?.toString()!!,
            datetime = getDateTime.execute(),
            work = Work(
                workName = binding.spinerWork.selectedItem.toString(),
                sizeWork = binding.workSize.text?.toString()?.toInt()!!
            ),
            address = getAddress(geoPoint),
            geoPoint = geoPoint
        )
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

    private fun getAddress(geoPoint: GeoPoint): String {
        val geocoder = Geocoder(view?.context!!, Locale.getDefault())
        val addresses = geocoder.getFromLocation(
            geoPoint.latitude,
            geoPoint.longitude,
            5000
        )

        return "Город: ${addresses?.get(0)?.locality}, " +
                "улица ${addresses?.get(0)?.thoroughfare?.replaceFirst("улица", "")
                    ?.trim()}, " +
                "дом " +
                "${addresses?.get(0)?.featureName}."
    }
}
