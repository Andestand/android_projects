package project.productsandservice.ui.allimages

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import project.productsandservice.databinding.ActivityAllImagesBinding

class AllImagesViewModel : ViewModel() {
    private val adapterAllImgs = AllImagesAdapter()

    fun initRV(
        context: Context,
        binding: ActivityAllImagesBinding
    ) {
        binding.AllImagesRV.apply {
            adapter = adapterAllImgs
            layoutManager = GridLayoutManager(context, 3)
        }
    }
}