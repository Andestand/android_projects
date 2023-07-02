package ru.project.roomexample.ui.main

import ru.project.roomexample.ui.registerUser.AddUserBottomSheetFragment
import ru.project.roomexample.databinding.ActivityMainBinding
import ru.project.roomexample.data.room.MyRoomManager
import androidx.recyclerview.widget.GridLayoutManager
import ru.project.roomexample.data.models.UserRoom
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val adapterUsers = AdapterUsers()
    private lateinit var db: MyRoomManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        db = Room.databaseBuilder(
            applicationContext,
            MyRoomManager::class.java,
            "database"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()

        binding.WriteDataButton.setOnClickListener {
            AddUserBottomSheetFragment().show(
                supportFragmentManager,
                "writeUser"
            )
        }

        binding.swipe.setOnRefreshListener {
            updateList(db.userDAO().getAllUsers())
            binding.swipe.isRefreshing = false
        }

        init()
    }

    override fun onResume() {
        super.onResume()
        updateList(db.userDAO().getAllUsers())
    }

    private fun updateList(user: List<UserRoom>) {
        adapterUsers.submitList(user)
        updateIsEmpty()
    }

    private fun updateIsEmpty() {
        if (db.userDAO().getAllUsers().isNotEmpty()) {
            binding.isEmpty.visibility = View.GONE
        } else {
            binding.isEmpty.visibility = View.VISIBLE
        }
    }

    private fun init() {
        binding.rvUsers.apply {
            adapter = adapterUsers
            layoutManager = GridLayoutManager(applicationContext, 2)
        }

    }
}
