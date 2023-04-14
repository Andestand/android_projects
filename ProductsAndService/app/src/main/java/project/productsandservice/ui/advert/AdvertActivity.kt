package project.productsandservice.ui.advert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import project.productsandservice.databinding.ActivityAdvertBinding
import project.productsandservice.domain.models.Advert

class AdvertActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdvertBinding
    private lateinit var viewModel: AdvertViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdvertBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        viewModel = ViewModelProvider(this)[AdvertViewModel::class.java]
        viewModel.addAdvert(
            context = applicationContext,
            ad = intent.getSerializableExtra("ad") as Advert,
            binding = binding
        )
        viewModel.initRV(
            context = applicationContext,
            binding = binding
        )
    }
}
