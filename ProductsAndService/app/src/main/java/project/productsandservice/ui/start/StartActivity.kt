package project.productsandservice.ui.start

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import project.productsandservice.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding
    private val viewModel = StartActivityViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.startClick(this, binding)
    }
}
