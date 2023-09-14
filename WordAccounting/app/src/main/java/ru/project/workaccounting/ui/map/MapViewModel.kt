package ru.project.workaccounting.ui.map

import android.content.Context
import android.content.Context.LOCATION_SERVICE
import android.location.LocationManager
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.ItemizedIconOverlay
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.OverlayItem
import ru.project.workaccounting.data.arrays.Reports
import ru.project.workaccounting.data.database.MyRoomManager
import ru.project.workaccounting.domain.models.Report
import ru.project.workaccounting.ui.reportView.MyReportBottomFragment


class MapViewModel : ViewModel() {
    private lateinit var locationManager: LocationManager
    private lateinit var db: MyRoomManager
    fun mapView(
        context: Context,
        map: MapView,
        fragmentManager: FragmentManager
    ) {
        db = Room.databaseBuilder(
            context,
            MyRoomManager::class.java,
            "database"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()

        Configuration.getInstance().load(
            context,
            PreferenceManager.getDefaultSharedPreferences(context)
        )

        map.apply {
            setTileSource(TileSourceFactory.MAPNIK)

            controller.setZoom(4.0)

            controller.setCenter(
                GeoPoint(0.0, 0.0)
            )

            for (i in db.reportDAO().getReportAll()) {
                addMarker(
                    id = i.id!!,
                    map = this,
                    report = i,
                    fragmentManager = fragmentManager,
                    context = context
                )
            }

            setMultiTouchControls(true)
        }
    }

    private fun addMarker(
        id: Long,
        map: MapView,
        report: Report,
        fragmentManager: FragmentManager,
        context: Context
    ) = Marker(map).apply {
        val marker = this

        position = GeoPoint(report.geoPoint.latitude, report.geoPoint.longitude)
        setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)

        setOnMarkerClickListener { marker, map ->
            Toast.makeText(context, id.toString(), Toast.LENGTH_LONG).show()
            MyReportBottomFragment(
                report = report,
            ).show(
                fragmentManager, "myReportBottomFragment"
            )
            true
        }

        map.apply {
            overlays.add(marker)
            invalidate()
        }
    }

}