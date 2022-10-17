package codes.myappnotes

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import codes.myappnotes.db.DataBaseManager

class PageNotesActivity : AppCompatActivity() {
    private val dataBaseManager = DataBaseManager(this@PageNotesActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_notes)
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
                        findViewById<TextView>(R.id.header).text.toString(),
                        findViewById<TextView>(R.id.text_).text.toString()
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
        findViewById<TextView>(R.id.header).text = note.header
        findViewById<TextView>(R.id.text_).text = note.text
    }
}
