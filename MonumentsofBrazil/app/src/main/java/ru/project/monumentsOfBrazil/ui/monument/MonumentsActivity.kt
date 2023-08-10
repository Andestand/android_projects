package ru.project.monumentsOfBrazil.ui.monument

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.project.monumentsOfBrazil.data.arrays.ArrayMonuments
import ru.project.monumentsOfBrazil.databinding.MonumentsFragmentBinding
import ru.project.monumentsOfBrazil.domain.models.Monument

class MonumentsActivity: AppCompatActivity() {
    private lateinit var binding: MonumentsFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MonumentsFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            setMonument(intent.getSerializableExtra("monument") as Monument)

            exit.setOnClickListener {
                finish()
            }
        }
    }

    private fun setMonument(monument: Monument) {
        binding.apply {
            imageView.setImageResource(monument.image)
            title.text = monument.title
            description.text = monument.description
            datetime.text = monument.datetime
        }
    }
}