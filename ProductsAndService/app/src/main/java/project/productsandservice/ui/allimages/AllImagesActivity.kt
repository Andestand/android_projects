package project.productsandservice.ui.allimages

import project.productsandservice.databinding.ActivityAllImagesBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import project.productsandservice.domain.models.ImageModel

class AllImagesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAllImagesBinding
    private lateinit var viewModel: AllImagesViewModel
    private val adapterAllImgs = AllImagesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllImagesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[AllImagesViewModel::class.java]
        viewModel.initRV(
            context = applicationContext,
            binding = binding
        )
        binding.toolbarAllImages.subtitle = intent.getStringExtra("subtitle_data")
        adapterAllImgs.addImage(
            intent?.getSerializableExtra("img_uri_data") as ImageModel
        )
    }
}
