package project.productsandservice.ui.adverts


import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import project.productsandservice.databinding.ActivityMyAdsBinding
import project.productsandservice.ui.createAdvert.CreateAdvertActivity


class MyAdvertsViewModel: ViewModel() {

    fun buttonAddAdvert(
        context: Context,
        binding: ActivityMyAdsBinding
    ) {
        binding.addAdvertButton.setOnClickListener {
            context.startActivity(
                Intent(
                    context,
                    CreateAdvertActivity::class.java
                ).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            )
        }
    }
}