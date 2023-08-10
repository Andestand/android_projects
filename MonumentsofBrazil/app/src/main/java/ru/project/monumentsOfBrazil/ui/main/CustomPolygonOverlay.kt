package ru.project.monumentsOfBrazil.ui.main

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Overlay

// Создать класс, расширяющий Overlay
class CustomPolygonOverlay(
    val mapView: MapView,
    val points: List<GeoPoint>,
    val fillColor: Int,
    val strokeColor: Int,
    val strokeWidth: Float
) : Overlay() {

    override fun draw(canvas: android.graphics.Canvas?, mapView: MapView?, shadow: Boolean) {
        super.draw(canvas, mapView, shadow)

        val paint = Paint()
        paint.style = Paint.Style.FILL
        paint.color = fillColor

        val path = Path()
        val startPoint = mapView?.projection?.toPixels(points[0], null)
        startPoint?.let { path.moveTo(it.x.toFloat(), it.y.toFloat()) }

        for (i in 1 until points.size) {
            val point = mapView?.projection?.toPixels(points[i], null)
            point?.let { path.lineTo(it.x.toFloat(), it.y.toFloat()) }
        }

        path.close()

        canvas?.drawPath(path, paint)

        val strokePaint = Paint()
        strokePaint.style = Paint.Style.STROKE
        strokePaint.color = strokeColor
        strokePaint.strokeWidth = strokeWidth

        canvas?.drawPath(path, strokePaint)
    }
}