package project.productsandservice.ui.start

import android.content.*
import androidx.lifecycle.ViewModel
import project.productsandservice.databinding.ActivityStartBinding
import project.productsandservice.ui.auth.LoginActivity
import project.productsandservice.ui.register.RegisterActivity

class StartActivityViewModel: ViewModel() {

    fun startClick(
        context: Context,
        binding: ActivityStartBinding
    ) {
        binding.buttonAuth.setOnClickListener {
            context.startActivity(Intent(
                context,
                LoginActivity::class.java
            ))
        }

        binding.buttonRegister.setOnClickListener {
            context.startActivity(Intent(
                context,
                RegisterActivity::class.java
            ))
        }
    }
}