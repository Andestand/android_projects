package project.productsandservice.ui.register

import androidx.lifecycle.ViewModel
import project.productsandservice.data.api.AuthDataBaseImplement
import project.productsandservice.data.client.AppClientImplement
import project.productsandservice.databinding.ActivityRegisterBinding
import project.productsandservice.domain.models.UserDomain
import project.productsandservice.domain.usecase.GetDateTimeUseCase
import project.productsandservice.domain.usecase.RegisterUseCase

class RegisterActivityViewModel: ViewModel() {
    private val stdbi = AuthDataBaseImplement()
    private val acli = AppClientImplement(stdbi)
    private val registerUseCase = RegisterUseCase(acli)
    private val getDateTimeUseCase = GetDateTimeUseCase()

    fun clickBtn(binding: ActivityRegisterBinding) {
        binding.buttonRegister.setOnClickListener {
            addUser(binding)
        }
    }
    private fun addUser(
        binding: ActivityRegisterBinding
    ) {
        registerUseCase.execute(
            UserDomain(
                avatar = null,
                username = binding.username.text.toString(),
                first_name = binding.firstName.text.toString(),
                last_name = binding.lastName.text.toString(),
                surname = binding.surname.text.toString(),
                password = binding.password.text.toString(),
                city = binding.city.text.toString(),
                date_registration = getDateTimeUseCase.execute()
            )
        )
    }
}