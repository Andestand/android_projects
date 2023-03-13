package codes.myappnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import codes.myappnotes.databinding.ActivityAddNoteBinding
import codes.myappnotes.db.DataBaseManager

class AddNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddNoteBinding
    private val adapter = AdapterNote()
    private val db = DataBaseManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db.openDB()
        binding.changeButton.setOnClickListener {
            addDataNotes()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_note_toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        /** В данном методе задаётся логика кнопок в toolbar **/
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }

            R.id.ItemClear -> {
                findViewById<TextView>(R.id.header_note).text = ""
                findViewById<TextView>(R.id.text_note_change).text = ""
            }
        }
        return true
    }

     private fun addDataNotes() {
        /** Данный метод осуществляет создание экземпляра HolderView и далее добавляет данные **/


        if (binding.headerNote.text.isNullOrEmpty() && binding.textNoteChange.text.isNullOrEmpty()) {
            setResult(RESULT_CANCELED)

        } else {

            setResult(RESULT_OK, Intent().apply {
                putExtra("Note", Note(binding.headerNote.text.toString(), binding.textNoteChange.text.toString()))
            })
            finish()
        }

    }
}
