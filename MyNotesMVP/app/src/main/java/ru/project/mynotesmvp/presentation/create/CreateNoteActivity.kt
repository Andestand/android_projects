package ru.project.mynotesmvp.presentation.create

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import ru.project.mynotesmvp.data.models.Note
import ru.project.mynotesmvp.data.room.MyRoomManager
import ru.project.mynotesmvp.databinding.ActivityCreateNoteBinding
import ru.project.mynotesmvp.domain.usecase.GetDateTimeUseCase

class CreateNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateNoteBinding
    private lateinit var db: MyRoomManager
    private val getDateTimeUseCase = GetDateTimeUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room.databaseBuilder(
            applicationContext,
            MyRoomManager::class.java,
            "database"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()

        binding.addButton.setOnClickListener {
            addNote()
        }
    }

    private fun addNote() {
        if (!binding.title.text?.isEmpty()!! && !binding.link.text?.isEmpty()!! &&
            !binding.description.text?.isEmpty()!!
        ) {
            db.notesDAO().addNote(Note(
                title = binding.title.text?.toString()!!,
                image_link = binding.link.text?.toString()!!,
                description = binding.description.text?.toString()!!,
                date_publication = getDateTimeUseCase.execute()
            ))
            setResult(RESULT_OK)
            finish()
        } else {
            setResult(RESULT_CANCELED)
        }
    }
}