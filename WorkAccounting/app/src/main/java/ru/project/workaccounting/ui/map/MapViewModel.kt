package ru.project.workaccounting.ui.map

import androidx.lifecycle.ViewModel
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.views.MapView

class MapViewModel : ViewModel() {
    fun mapView(
        map: MapView
    ) {
        map.apply {
            setTileSource(TileSourceFactory.MAPNIK)

            controller.setZoom(5.0)

            //setBuiltInZoomControls(true)
            setMultiTouchControls(true)
        }
    }
}