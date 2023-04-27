package ru.project.roomexample.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.GridLayoutManager
import androidx.room.Room
import ru.project.roomexample.data.models.UserRoom
import ru.project.roomexample.data.room.MyRoomManager
import ru.project.roomexample.databinding.ActivityMainBinding
import ru.project.roomexample.ui.registerUser.AddUserBottomSheetFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //private var viewModel = MainViewModel(application)
    private val adapter = AdapterUsers()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        //println(db.userDAO().getAllUsers())

        binding.WriteDataButton.setOnClickListener {
            AddUserBottomSheetFragment().show(
                supportFragmentManager,
                "writeUser"
            )
        }


        init()
    }

    private fun init() {
        binding.rvUsers.adapter = adapter
        binding.rvUsers.layoutManager = GridLayoutManager(applicationContext, 2)

        adapter.addUser(
            UserRoom(1, "Dostoevsky", "666")
        )
    }
}
