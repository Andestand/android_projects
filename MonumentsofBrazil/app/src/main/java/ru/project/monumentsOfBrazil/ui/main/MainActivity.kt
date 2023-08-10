package ru.project.monumentsOfBrazil.ui.main

import android.annotation.SuppressLint
import android.content.Intent
import android.content.LocusId
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.*
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.Polygon
import org.osmdroid.views.overlay.Polyline
import ru.project.monumentsOfBrazil.R
import ru.project.monumentsOfBrazil.data.arrays.ArrayMonuments
import ru.project.monumentsOfBrazil.databinding.ActivityMainBinding
import ru.project.monumentsOfBrazil.domain.models.Border
import ru.project.monumentsOfBrazil.domain.models.Monument
import ru.project.monumentsOfBrazil.domain.models.Region
import ru.project.monumentsOfBrazil.ui.monument.MonumentsActivity
import ru.project.monumentsOfBrazil.ui.settings.MySettingsDialogFragment

class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            exitButton.setOnClickListener { finish() }

            settingsButton.setOnClickListener {
                MySettingsDialogFragment().apply {
                }.show(supportFragmentManager.beginTransaction(), "mySettingsDialogFragment")
            }
        }
        mapView()
    }

    private val mapnikBrazilian: OnlineTileSourceBase = XYTileSource(
        "MapnikBrazilian",
        0, 19, 256, ".png", arrayOf(
            "https://a.tile.openstreetmap.org/",
            "https://b.tile.openstreetmap.org/",
            "https://c.tile.openstreetmap.org/"
        ), "© OpenStreetMap contributors",
        TileSourcePolicy(
            2,
            TileSourcePolicy.FLAG_NO_BULK
                    or TileSourcePolicy.FLAG_NO_PREVENTIVE
                    or TileSourcePolicy.FLAG_USER_AGENT_MEANINGFUL
                    or TileSourcePolicy.FLAG_USER_AGENT_NORMALIZED
        )
    )

    private fun customStyleMap(
        map: MapView,
        region: Region,
        border: Border
    ) {
        map.apply {
            overlays.add(
                Polyline().apply {
                    setPoints(
                        listOf(
                            GeoPoint(
                                -11.5362023,
                                -47.8357315
                            ),
                            GeoPoint(
                                -6.7580247,
                                -43.5837073
                            )
                        )
                    )

                    paint.apply {

                        strokeWidth = border.strokeWidth
                        color = border.color
                    }
                }
            )

            overlays.add(
                Polygon().apply {
                    title = ""

                    fillPaint.apply {
                        color = region.color
                    }

                }
            )
        }
    }

    private fun mapView() {
        Configuration.getInstance().load(
            applicationContext,
            PreferenceManager.getDefaultSharedPreferences(applicationContext)
        )

        binding.mapView.apply {
            setTileSource(mapnikBrazilian)

            /*customStyleMap(
                map = this,
                region = Region(
                    color = Color.BLACK
                ),
                border = Border(
                    strokeWidth = 10F,
                    color = Color.BLACK
                )
            )*/
            
            controller.setCenter(
                GeoPoint(
                    -14.235,
                    -51.9253
                )
            )
            controller.setZoom(5.0)

            // Включение возможности масштабирования
            //setBuiltInZoomControls(true)
            setMultiTouchControls(true)

            listMarkers(
                map = this@apply
            )

        }
    }

    private fun listMarkers(map: MapView) {
        addMarker(
            mapView = map,
            latitude = -23.5793383,
            longitude = -46.6103341,
            monument = ArrayMonuments.array[0]
        )

        addMarker(
            mapView = map,
            latitude = -22.9519247,
            longitude = -43.2105612,
            monument = ArrayMonuments.array[1]
        )

        addMarker(
            mapView = map,
            latitude = -22.9106905,
            longitude = -43.1807961,
            monument = ArrayMonuments.array[2]
        )

        addMarker(
            mapView = map,
            latitude = -15.7842197,
            longitude = -47.9134185,
            monument = ArrayMonuments.array[3]
        )

        addMarker(
            mapView = map,
            latitude = -8.6953108,
            longitude = -42.5863381,
            monument = ArrayMonuments.array[4]
        )

        addMarker(
            mapView = map,
            latitude = 0.0006897,
            longitude = -51.0782575,
            monument = ArrayMonuments.array[5]
        )

        addMarker(
            mapView = map,
            latitude = -22.9054631,
            longitude = -43.1822691,
            monument = ArrayMonuments.array[6]
        )

        addMarker(
            mapView = map,
            latitude = -15.7983645,
            longitude = -47.87555,
            monument = ArrayMonuments.array[7]
        )

        addMarker(
            mapView = map,
            latitude = -3.1303084,
            longitude = -60.0234093,
            monument = ArrayMonuments.array[8]
        )

        addMarker(
            mapView = map,
            latitude = -22.9153021,
            longitude = -43.1792702,
            monument = ArrayMonuments.array[9]
        )
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun addMarker(
        mapView: MapView,
        latitude: Double,
        longitude: Double,
        monument: Monument
    ) = Marker(mapView).apply {
        val market = this
        icon = applicationContext.resources.getDrawable(R.drawable.dot)

        setOnMarkerClickListener { marker, mapView ->
            startActivity(
                Intent(
                    this@MainActivity,
                    MonumentsActivity::class.java
                ).apply {
                    putExtra("monument", monument)
                }
            )
            true
        }

        position = GeoPoint(latitude, longitude)
        setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)

        mapView.apply {
            overlays.add(market)
            invalidate()
        }
    }
}
