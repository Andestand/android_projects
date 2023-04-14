package project.productsandservice.ui.profile

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import project.productsandservice.data.arrays.AdvertsArray
import project.productsandservice.databinding.FragmentProfileBinding

class FragmentProfileViewModel : ViewModel() {
    private val adapter = AdapterMyAds()

    fun initRV(
        context: Context,
        binding: FragmentProfileBinding
    ) {
        binding.rvProfile.adapter = adapter
        binding.rvProfile.layoutManager = GridLayoutManager(context, 2)

        for (i in AdvertsArray.array) {
            adapter.add(i)
        }
    }
}
