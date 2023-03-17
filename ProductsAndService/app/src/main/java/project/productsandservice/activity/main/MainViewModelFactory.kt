package project.productsandservice.activity.main

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import project.productsandservice.R
import project.productsandservice.databinding.ActivityMainBinding
import project.productsandservice.fragment.fragmentChats.FragmentChats
import project.productsandservice.fragment.fragmentHome.FragmentHome
import project.productsandservice.fragment.fragmentNotification.FragmentNotification
import project.productsandservice.fragment.fragmentProfile.FragmentProfile

class MainViewModelFactory(
    private var binding: ActivityMainBinding,
    private var supportFragmentManager: FragmentManager
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel() as T
    }

}
