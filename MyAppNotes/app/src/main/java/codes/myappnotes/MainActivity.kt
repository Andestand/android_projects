package codes.myappnotes

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import codes.myappnotes.databinding.ActivityMainBinding
import codes.myappnotes.db.DataBaseManager
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = AdapterNote()
    private var editlaunch: ActivityResultLauncher<Intent>? = null
    private val dataBaseManager = DataBaseManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        editlaunch = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                dataBaseManager.addDataDB(it.data?.getSerializableExtra("Note") as Note)
            }
        }
        dataBaseManager.openDB()
    }

    override fun onResume() {
        super.onResume()
        when (dataBaseManager.readDataDB().size) {
            0 -> {
                binding.textView2.text = "Пусто"
            } else -> {
                binding.textView2.text = ""
            }
        }
        for (i in dataBaseManager.readDataDB()) {
            adapter.addNote(i)
        }
    }

    @SuppressLint("CutPasteId")
    private fun init() {
        apply {
            binding.recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 1)
            binding.recyclerView.adapter = adapter

            binding.floatingActionButton.setOnClickListener {
                editlaunch?.launch(Intent(this@MainActivity, AddNoteActivity::class.java))
            }
        }
    }
}
