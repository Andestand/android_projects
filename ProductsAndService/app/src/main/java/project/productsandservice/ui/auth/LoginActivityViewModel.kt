package project.productsandservice.ui.auth

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.ViewModel
import project.productsandservice.data.api.AuthDataBaseImplement
import project.productsandservice.databinding.ActivityLoginBinding
import project.productsandservice.domain.models.Login
import project.productsandservice.domain.usecase.AuthUseCase

class LoginActivityViewModel: ViewModel() {
    private val adbi = AuthDataBaseImplement()
    private val loginUseCase = AuthUseCase(adbi)
    private var isNull = false

    fun buttonAuth(
        binding: ActivityLoginBinding
    ) {
        binding.buttonAuth.setOnClickListener {
            if (isValid(binding = binding)) {
                binding.username.error = "правильно"
                binding.password.error = "правильно"
            } else {
                binding.username.error = "не правильно"
                binding.password.error = "не правильно"
            }
            println(isValid(binding = binding))
        }
    }

    private fun isValid(
        binding: ActivityLoginBinding
    ): Boolean {
        return if (!binding.password.text?.isEmpty()!! && !binding.username.text?.isEmpty()!!) {
            loginUseCase.execute(
                Login(
                    username = binding.username.text.toString(),
                    password = binding.password.text.toString()
                )
            )
            true
        } else {
            false
        }
    }

    private fun isNullUserName(
        binding: ActivityLoginBinding
    ): Boolean {
        object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                super.toString()
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                super.toString()
            }
        }
        return isNull
    }
}
