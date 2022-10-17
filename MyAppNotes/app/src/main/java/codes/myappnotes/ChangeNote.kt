package codes.myappnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import codes.myappnotes.db.DataBaseManager

class ChangeNote : AppCompatActivity() {
    private val db = DataBaseManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_note)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        db.openDB()
        changeNote(intent.getSerializableExtra("Note_data") as Note)
        findViewById<Button>(R.id.changeButton).setOnClickListener {
            db.changeDataDB(noteReturn(), intent.getSerializableExtra("Note_data") as Note)
            startActivity(
                Intent(
                    this@ChangeNote,
                    MainActivity::class.java
                )
            )
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }

        return true
    }

    private fun changeNote(note: Note) {
        findViewById<TextView>(R.id.header_note).text = note.header
        findViewById<TextView>(R.id.text_note_change).text = note.text
    }

    private fun noteReturn(): Note {
        return Note(
            findViewById<TextView>(R.id.header_note).text.toString(),
            findViewById<TextView>(R.id.text_note_change).text.toString()
        )
    }
}
