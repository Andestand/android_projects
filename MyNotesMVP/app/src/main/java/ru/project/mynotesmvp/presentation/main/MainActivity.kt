package ru.project.mynotesmvp.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.room.Room
import ru.project.mynotesmvp.data.models.Note
import ru.project.mynotesmvp.data.room.MyRoomManager
import ru.project.mynotesmvp.databinding.ActivityMainBinding
import ru.project.mynotesmvp.presentation.create.CreateNoteActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = MainAdapter()
    private lateinit var db: MyRoomManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        db = Room.databaseBuilder(
            applicationContext,
            MyRoomManager::class.java,
            "database"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()

        binding.addNote.setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    CreateNoteActivity::class.java
                )
            )
        }
    }

    override fun onResume() {
        super.onResume()
        for (i in db.notesDAO().notesAll()) {
            adapter.addNote(i)
        }
    }

    private fun init() {
        binding.rv.layoutManager = GridLayoutManager(applicationContext, 2)
        binding.rv.adapter = adapter

    }
}