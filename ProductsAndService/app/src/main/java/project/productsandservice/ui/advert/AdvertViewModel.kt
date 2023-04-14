package project.productsandservice.ui.advert

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import project.productsandservice.data.arrays.ImagesArray
import project.productsandservice.databinding.ActivityAdvertBinding
import project.productsandservice.domain.models.Advert

class AdvertViewModel: ViewModel() {
    private val adapter = AdvertImagesAdapter()

    fun addAdvert(
        context: Context,
        ad: Advert,
        binding: ActivityAdvertBinding
    ) {
        binding.titleAd.text = ad.title
        binding.descriptionAd.text = ad.description

        for (i in ad.media_file) adapter.addImage(i)

        binding.PriceTextView.text = ad.price
    }

    fun initRV(
        context: Context,
        binding: ActivityAdvertBinding
    ) {
        binding.rvAdvertImages.adapter = adapter
        binding.rvAdvertImages.layoutManager = GridLayoutManager(context, 4)
    }
}