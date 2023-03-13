package codes.myappnotes

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import codes.myappnotes.databinding.ActivityPageNotesBinding
import codes.myappnotes.db.DataBaseManager

class PageNotesActivity : AppCompatActivity() {
    private val dataBaseManager = DataBaseManager(this@PageNotesActivity)
    private lateinit var binding: ActivityPageNotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        addNote(intent.getSerializableExtra("Note") as Note)
        dataBaseManager.openDB()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }

            R.id.delete -> {
                dataBaseManager.deleteNote(intent.getSerializableExtra("Note") as Note)
                findViewById<RecyclerView>(R.id.recyclerView).adapter?.notifyDataSetChanged()
                finish()
            }

            R.id.change -> {
                startActivity(Intent(
                    this@PageNotesActivity,
                    ChangeNote::class.java
                ).apply {
                    putExtra("Note_data",
                    Note(
                        binding.header.text.toString(),
                        binding.text.text.toString()
                        )
                    )
                }
                )
            }
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.page_note, menu)
        return true
    }

    private fun addNote(note: Note) {
        binding.header.text = note.header
        binding.text.text = note.text
    }
}
