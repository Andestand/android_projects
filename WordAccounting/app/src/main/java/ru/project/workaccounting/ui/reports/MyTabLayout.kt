package ru.project.workaccounting.ui.reports

import com.google.android.material.tabs.TabLayoutMediator
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import ru.project.workaccounting.ui.month.MonthFragment
import ru.project.workaccounting.ui.year.YearFragment

class MyTabLayout(
    val fragmentManager: FragmentManager,
    private val lifecycle: Lifecycle
) {

    private val listFragments = listOf(
        MonthFragment(),
        YearFragment()
    )

    private val listFragmentsTitles = listOf(
        "За месяц",
        "За год"
    )

    fun tabLayoutAds(
        viewPager: ViewPager2,
        tabLayout: TabLayout
    ) {

        val adapterVP = AdapterViewPager(
            fragmentManager,
            lifecycle,
            listFragments
        )

        viewPager.adapter = adapterVP

        TabLayoutMediator(
            tabLayout,
            viewPager
        ) {
                tab, pos -> tab.text = listFragmentsTitles[pos]
        }.attach()
    }
}
