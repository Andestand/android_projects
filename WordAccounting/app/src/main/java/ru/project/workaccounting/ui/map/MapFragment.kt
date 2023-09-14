package ru.project.workaccounting.ui.map

import android.Manifest
import android.content.pm.PackageManager
import android.location.Geocoder
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.*
import org.osmdroid.util.GeoPoint
import ru.project.workaccounting.data.arrays.Permissions
import ru.project.workaccounting.databinding.FragmentMapBinding
import ru.project.workaccounting.ui.create.MyCreateReportBottomFragment
import java.util.*

class MapFragment: Fragment() {
    private lateinit var binding: FragmentMapBinding
    private lateinit var viewModel: MapViewModel
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var locationCallback: LocationCallback

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMapBinding.inflate(layoutInflater)
        return binding.root
    }

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

                            binding.map.controller.animateTo(
                                GeoPoint(
                                    location.latitude,
                                    location.longitude
                                )
                            )
                            binding.map.controller.setZoom(20.0)

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
                    interval = 5000 // интервал в миллисекундах между обновлениями
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MapViewModel::class.java]
        try {
            viewModel.mapView(
                context = view.context,
                map = binding.map,
                fragmentManager = fragmentManager!!
            )
        } catch (nullPointer: NullPointerException) {
            Log.e("nullPointerException", nullPointer.message!!)
        }

        binding.getGeoData.setOnClickListener {
            getGeoData()
        }

        binding.addReport.setOnClickListener {
            MyCreateReportBottomFragment().show(
                fragmentManager!!,
                "myCreateReportBottomFragment"
            )
        }
    }

    /*@Deprecated("Deprecated in Java", ReplaceWith(
        "super.onRequestPermissionsResult(requestCode, permissions, grantResults)",
        "androidx.fragment.app.Fragment"
    )
    )
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }*/

}