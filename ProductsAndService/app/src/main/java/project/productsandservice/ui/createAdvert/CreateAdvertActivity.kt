package project.productsandservice.ui.createAdvert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import project.productsandservice.databinding.ActivityCreateAdvertBinding

class CreateAdvertActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateAdvertBinding
    private lateinit var viewModel: CreateAdvertViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAdvertBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(
            this
        )[CreateAdvertViewModel::class.java]
        viewModel.addImage(
            binding = binding
        )
        viewModel.initSpinner(
            context = this.applicationContext,
            binding = binding
        )
    }
}
