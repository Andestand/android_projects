package project.productsandservice.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import project.productsandservice.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel = RegisterActivityViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        println(viewModel.clickBtn(binding = binding))
    }
}