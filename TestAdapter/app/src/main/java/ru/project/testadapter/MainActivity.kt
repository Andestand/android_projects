package ru.project.testadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Switch
import androidx.fragment.app.Fragment
import ru.project.testadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val arrayFrag = arrayOf(
        "Приветик!",
        "Пошёл нахуй!",
        "пака)"
    )

    private fun setDataFragment(i: String): Fragment {
        return TemplateFragment(i)
    }

    private fun getSize(): Int = arrayFrag.size - 1

    private var index = -1
        set(value) {
            if (value in 0..getSize()) {
                println("setter: true")
                field = value
            } else {
                println("setter: false")
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.sb.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    binding.sb.progress = index
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        binding.sb.max = getSize()
        binding.sb.progress = 0

        binding.BackButton.setOnClickListener {
            index--

            if (index != -1) {
                supportFragmentManager.beginTransaction()
                    .replace(binding.container.id, setDataFragment(arrayFrag[index])).commit()
            }
            binding.sb.progress = index
        }

        binding.ForwardButton.setOnClickListener {
            index++

            supportFragmentManager.beginTransaction()
                .replace(binding.container.id, setDataFragment(arrayFrag[index])).commit()

            binding.sb.progress = index
        }
    }

}
