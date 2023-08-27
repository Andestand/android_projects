package ru.project.mynotesmodified.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.project.mynotesmodified.ui.create.getDataBaseCN

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDataBase(applicationContext)
        getDataBaseCN(applicationContext)
        setContent {
            MainPreview()
        }
    }
}
