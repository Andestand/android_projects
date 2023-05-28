package project.productsandservice.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import project.productsandservice.databinding.ActivityMainBinding
import project.productsandservice.ui.start.StartActivity
import javax.inject.Inject

class MainActivity @Inject constructor(): AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel = ViewModelProvider(
            this
        )[MainViewModel::class.java]

        mainViewModel.bottomNavigationView(
            binding = binding,
            supportFragmentManager = supportFragmentManager
        )
        mainViewModel.navView(
            context = applicationContext,
            binding = binding
        )

        startActivity(
            Intent(
                this@MainActivity,
                StartActivity::class.java
            )
        )
    }
}
