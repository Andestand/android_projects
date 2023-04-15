package project.productsandservice.ui.adverts

import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import project.productsandservice.databinding.ActivityMyAdsBinding
import project.productsandservice.ui.active_adverts.FragmentActiveAdverts
import project.productsandservice.ui.announcement_archive.FragmentAnnouncementArchive

class MyTabLayout(
    fragmentActivity: FragmentActivity
) {
    private val listFragments = listOf(
        FragmentActiveAdverts(),
        FragmentAnnouncementArchive()
    )

    private val listFragmentsTitles = listOf(
        "Активные объявлений",
        "Архив объявлений"
    )

    private val adapterVP = AdapterViewPager(
        fragmentActivity,
        listFragments
    )

    fun tabLayoutAds(
        binding: ActivityMyAdsBinding
    ) {
        binding.ViewPager.adapter = adapterVP

        TabLayoutMediator(
            binding.tabLayoutAds,
            binding.ViewPager
        ) {
                tab, pos -> tab.text = listFragmentsTitles[pos]
        }.attach()
    }
}