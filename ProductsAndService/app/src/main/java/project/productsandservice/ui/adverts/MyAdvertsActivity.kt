package project.productsandservice.ui.adverts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import project.productsandservice.databinding.ActivityMyAdsBinding

class MyAdvertsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyAdsBinding
    private lateinit var viewModel: MyAdvertsViewModel
    private val myTabLayout = MyTabLayout(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyAdsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MyAdvertsViewModel::class.java]
        myTabLayout.tabLayoutAds(binding = binding)
        viewModel.buttonAddAdvert(
            context = applicationContext,
            binding = binding
        )
    }
}
