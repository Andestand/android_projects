package project.productsandservice.ui.createAdvert

import project.productsandservice.databinding.ActivityCreateAdvertBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.LinkMovementMethod
import project.productsandservice.domain.models.ImageModel
import project.productsandservice.ui.allimages.AllImagesActivity
import project.productsandservice.ui.allimages.AllImagesAdapter

class CreateAdvertActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateAdvertBinding
    private lateinit var viewModel: CreateAdvertViewModel
    val adapter = AdapterImages()

    private val arrayUri = ArrayList<Uri>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAdvertBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(
            this
        )[CreateAdvertViewModel::class.java]

        viewModel.initSpinner(
            context = applicationContext,
            binding = binding
        )

        /*binding.buttonAllImages.setOnClickListener {
            startActivity(
                Intent(
                    this@CreateAdvertActivity,
                    AllImagesActivity::class.java
                ).putExtra(
                    "img_uri_data", ImageModel(
                        uri = "https://sun9-78.userapi.com/impg/6At0GaqVshZAOrciadqViAVcmIlJx1c7" +
                                "GLKqTQ/fSF_x30iaKQ.jpg?size=796x1080&quality=95&sign=b5002aecb" +
                                "4a0ae88ea872ec835589ec8&type=album"
                    )
                )
            )
        }*/

        binding.createAd.setOnClickListener {
            viewModel.createAd(
                binding = binding,
                list = arrayUri
            )
        }

        addImage()
    }

    override fun onResume() {
        super.onResume()
        binding.imageSize.text = "Добавленно фотографий: ${arrayUri.size}"
    }

    private fun addImage() {
        binding.addImage.setOnClickListener {
            val getData = Intent(Intent.ACTION_PICK).apply {
                type = "image/*"
            }
            startActivityForResult(getData, 1)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            arrayUri.add(data?.data!!)
        }
    }
}
