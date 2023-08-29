package ru.project.workaccounting.ui.map

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.preference.PreferenceManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.osmdroid.api.IMapController
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay
import ru.project.workaccounting.data.arrays.Permissions
import ru.project.workaccounting.ui.reportView.MyReportBottomFragment

class MapViewModel : ViewModel() {
    fun mapView(
        context: Context,
        map: MapView,
        fragmentManager: FragmentManager
    ) {
        Configuration.getInstance().load(
            context,
            PreferenceManager.getDefaultSharedPreferences(context)
        )

        map.apply {
            setTileSource(TileSourceFactory.MAPNIK)

            controller.setZoom(5.0)

            controller.setCenter(
                GeoPoint(
                    0.0,
                    0.0
                )
            )

            addMarker(
                map = this,
                geoPoint = GeoPoint(
                    57.685064083828074,
                    46.60028995718904
                ),
                fragmentManager = fragmentManager
            )

            //setBuiltInZoomControls(true)
            setMultiTouchControls(true)
        }
    }

    private fun addMarker(
        map: MapView,
        geoPoint: GeoPoint,
        fragmentManager: FragmentManager
    ) = Marker(map).apply {
        val marker = this

        position = GeoPoint(geoPoint.latitude, geoPoint.longitude)
        setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)

        setOnMarkerClickListener { marker, map ->
            MyReportBottomFragment().show(
                fragmentManager, "myReportBottomFragment"
            )
            true
        }

        map.apply {
            overlays.add(marker)
            invalidate()
        }
    }

    private fun hasPermissions(
        context: Context,
        vararg permissions: String
    ): Boolean {
        for (permission in permissions) {
            if (ContextCompat.checkSelfPermission(
                    context,
                    permission
            ) != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }

    fun getGeoData(
        map: MapView,
        activity: Activity,
        context: Context,
        button: FloatingActionButton
    ) {
        button.setOnClickListener {
            if (!hasPermissions(
                    context = context,
                    permissions = Permissions.permissions
            )) {
                ActivityCompat.requestPermissions(
                    activity,
                    Permissions.permissions,
                    1
                )
            } else {
                getUserLocation(
                    map = map,
                    context = context
                )
            }
        }
    }

    private fun getUserLocation(
        map: MapView,
        context: Context
    ) {
        if (
            ContextCompat.checkSelfPermission(
                context,
                Permissions.permissions[0]
            ) == PackageManager.PERMISSION_GRANTED
        ) {
           val controller: IMapController = map.controller
           val overlay = MyLocationNewOverlay(map)

           map.overlays.add(overlay)
           overlay.enableMyLocation()
           controller.setZoom(15.0)
           controller.setCenter(overlay.myLocation)
        }
    }
}