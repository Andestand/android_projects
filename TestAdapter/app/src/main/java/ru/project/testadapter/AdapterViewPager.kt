package ru.project.testadapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class AdapterViewPager(
    var listFragment: List<Fragment>,
    var fragmentActivity: FragmentActivity
    ): FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = listFragment.size

    override fun createFragment(position: Int): Fragment = listFragment[position]
}