package ru.project.monumentsOfBrazil.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.Drawable
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

@SuppressLint("DiscouragedApi", "UseCompatLoadingForDrawables")
class CustomMarker(context: Context, mapView: MapView) : Marker(mapView) {
    private val icon: Drawable

    init {
        // Загружаем иконку маркера из ресурсов
        val resId = context.resources.getIdentifier(
            "dot", "drawable", context.packageName
        )
        icon = context.getDrawable(resId)!!

        // Устанавливаем размер иконки
        icon.setBounds(15, 15, icon.intrinsicWidth, icon.intrinsicHeight)

        // Устанавливаем иконку для отображения маркера
        icon.mutate()
        icon.setTint(getMarkerColor())
    }

    override fun draw(canvas: Canvas, mapView: MapView?, shadow: Boolean) {
        super.draw(canvas, mapView, shadow)
        if (!shadow) {
            // При отрисовке маркера, рисуем на нем нашу векторную иконку
            val x = (canvas.width - icon.intrinsicWidth) / 2
            val y = (canvas.height - icon.intrinsicHeight)
            canvas.save()
            canvas.translate(x.toFloat(), y.toFloat())
            icon.draw(canvas)
            canvas.restore()
        }
    }

    private fun getMarkerColor(): Int {
        // Возвращает цвет иконки маркера
        return Color.TRANSPARENT // Замените на нужный вам цвет
    }

}