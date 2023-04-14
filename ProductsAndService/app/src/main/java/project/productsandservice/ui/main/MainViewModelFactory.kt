package project.productsandservice.ui.main

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import project.productsandservice.databinding.ActivityMainBinding

class MainViewModelFactory(
    private var binding: ActivityMainBinding,
    private var supportFragmentManager: FragmentManager
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel() as T
    }

}
