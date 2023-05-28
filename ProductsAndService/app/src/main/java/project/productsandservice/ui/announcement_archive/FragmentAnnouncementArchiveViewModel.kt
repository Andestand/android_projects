package project.productsandservice.ui.announcement_archive

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import project.productsandservice.data.arrays.AdvertsArray
import project.productsandservice.databinding.FragmentAnnouncementArchiveBinding
import project.productsandservice.domain.models.Status
import project.productsandservice.ui.profile.AdapterMyAds

class FragmentAnnouncementArchiveViewModel : ViewModel() {
    private val adapterAds = AdapterMyAds()

    fun initRV(
        context: Context,
        binding: FragmentAnnouncementArchiveBinding
    ) {
        binding.recyclerview.apply {
            adapter = adapterAds
            layoutManager = GridLayoutManager(context, 2)
        }

        for (i in AdvertsArray.array) {
            if (i.isStatus == Status.Archive) {
                binding.TextViewEmpty.visibility = View.GONE
                adapterAds.add(i)
            } else {
                binding.TextViewEmpty.visibility = View.VISIBLE
            }
        }
    }
}