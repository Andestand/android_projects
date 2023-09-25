package com.nstudio.krutringtoplayer.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.nstudio.krutringtoplayer.R
import com.nstudio.krutringtoplayer.databinding.ActivityMainBinding
import com.nstudio.krutringtoplayer.domain.models.Rington
import java.util.Timer
import java.util.TimerTask

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var adapterRington = RingtonAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rv.apply {
            adapter = adapterRington
            layoutManager = GridLayoutManager(applicationContext, 1)
        }

        adapterRington.addRington(
            rington = Rington(
                context = applicationContext,
                title = "Бегут мурашки по коже",
                raw = R.raw.audio
            )
        )
    }
}