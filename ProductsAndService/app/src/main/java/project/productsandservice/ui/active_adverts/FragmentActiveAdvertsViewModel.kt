package project.productsandservice.ui.active_adverts

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import project.productsandservice.data.arrays.AdvertsArray
import project.productsandservice.databinding.FragmentActiveAdvertsBinding
import project.productsandservice.ui.profile.AdapterMyAds

class FragmentActiveAdvertsViewModel : ViewModel() {
    private val adapter = AdapterMyAds()

    fun initRV(
        context: Context,
        binding: FragmentActiveAdvertsBinding
    ) {
        binding.rv.adapter = adapter
        binding.rv.layoutManager = GridLayoutManager(context, 2)
        for (i in AdvertsArray.array) {
            adapter.add(i)
        }

    }
}