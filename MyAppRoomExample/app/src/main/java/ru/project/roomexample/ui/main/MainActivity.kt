package ru.project.roomexample.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.room.Room
import ru.project.roomexample.data.models.UserRoom
import ru.project.roomexample.data.room.MyRoomManager
import ru.project.roomexample.databinding.ActivityMainBinding
import ru.project.roomexample.ui.changeUser.ChangeUserBottomSheetFragment
import ru.project.roomexample.ui.registerUser.AddUserBottomSheetFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val adapter = AdapterUsers()
    //private lateinit var db: MyRoomManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val db = Room.databaseBuilder(
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
            //updateList(db.userDAO().getAllUsers())
            binding.swipe.isRefreshing = false
        }

        init()
    }

    /*override fun onResume() {
        super.onResume()
        updateList(db.userDAO().getAllUsers())
    }

    private fun updateList(user: List<UserRoom>) {
        adapter.submitList(user)
        updateIsEmpty()

    }

    private fun updateIsEmpty() {
        if (db.userDAO().getAllUsers().isNotEmpty()) {
            binding.isEmpty.visibility = View.GONE
        } else {
            binding.isEmpty.visibility = View.VISIBLE
        }
    }*/

    private fun init() {
        binding.rvUsers.adapter = adapter
        binding.rvUsers.layoutManager = GridLayoutManager(applicationContext, 2)
    }
}
