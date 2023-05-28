package project.productsandservice.ui.profile

import project.productsandservice.databinding.FragmentProfileBinding
import project.productsandservice.data.arrays.AdvertsArray
import androidx.recyclerview.widget.GridLayoutManager
import androidx.lifecycle.ViewModel
import android.content.Context
import project.productsandservice.data.arrays.UsersArray
import project.productsandservice.domain.models.Status

class FragmentProfileViewModel : ViewModel() {
    private val adapterAds = AdapterMyAds()

    fun initRV(
        context: Context,
        binding: FragmentProfileBinding
    ) {
        binding.rvProfile.apply {
            adapter = adapterAds
            layoutManager = GridLayoutManager(context, 2)
        }

        for (i in AdvertsArray.array) {
            if (i.isStatus == Status.Active && i.author_advert == UsersArray.array[0]) {
                adapterAds.add(i)
            }
        }
    }
}
