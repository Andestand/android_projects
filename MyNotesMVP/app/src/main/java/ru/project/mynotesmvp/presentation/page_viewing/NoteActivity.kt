package ru.project.mynotesmvp.presentation.page_viewing

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import ru.project.mynotesmvp.data.models.Note
import ru.project.mynotesmvp.databinding.ActivityNoteBinding

class NoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteBinding

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setNote(
            intent.getSerializableExtra("note") as Note
        )
    }

    private fun setNote(note: Note) {
        this.supportActionBar?.subtitle = "Дата публикации: ${note.date_publication}"
        binding.title.text = note.title
        binding.description.text = note.description
        Glide.with(applicationContext).load(note.image_link).into(binding.iv)
    }
}