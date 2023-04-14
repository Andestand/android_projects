package project.productsandservice.ui.main

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import project.productsandservice.R
import project.productsandservice.databinding.ActivityMainBinding
import project.productsandservice.ui.chats.FragmentChats
import project.productsandservice.ui.home.FragmentHome
import project.productsandservice.ui.notification.FragmentNotification
import project.productsandservice.ui.profile.FragmentProfile

class MainViewModel: ViewModel() {

    fun bottomNavigationView(
        binding: ActivityMainBinding,
        supportFragmentManager: FragmentManager
    ) {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.bottomNavigationHome -> {
                    supportFragmentManager.beginTransaction()
                        .replace(binding.fragmentContainerView.id, FragmentHome()).commit()
                }
                R.id.bottomNavigationChats -> {
                    supportFragmentManager.beginTransaction()
                        .replace(binding.fragmentContainerView.id, FragmentChats()).commit()
                }
                R.id.bottomNavigationNotification -> {
                    supportFragmentManager.beginTransaction()
                        .replace(binding.fragmentContainerView.id, FragmentNotification()).commit()
                }
                R.id.bottomNavigationProfile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(binding.fragmentContainerView.id, FragmentProfile()).commit()
                }
            }
            true
        }
    }
}
