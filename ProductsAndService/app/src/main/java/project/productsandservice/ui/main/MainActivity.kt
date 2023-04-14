package project.productsandservice.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import project.productsandservice.databinding.ActivityMainBinding
import project.productsandservice.ui.createAdvert.CreateAdvertActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel = ViewModelProvider(
            this
        )[MainViewModel::class.java]
        /*startActivity(
            Intent(
                this@MainActivity,
                CreateAdvertActivity::class.java
            )
        )*/
        mainViewModel.bottomNavigationView(binding, supportFragmentManager)
    }
}