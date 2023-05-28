package project.productsandservice.ui.register

import project.productsandservice.databinding.ActivityRegisterBinding
import project.productsandservice.data.api.AuthDataBaseImplement
import project.productsandservice.data.room.MyRoomManager
import project.productsandservice.data.models.Session
import project.productsandservice.domain.usecase.*
import project.productsandservice.domain.models.*
import androidx.lifecycle.ViewModel
import android.content.Context
import androidx.room.Room
import android.net.Uri
import android.os.Build

class RegisterActivityViewModel: ViewModel() {
    private val stdbi = AuthDataBaseImplement()
    private val registerUseCase = RegisterUseCase(stdbi)
    private val getDateTimeUseCase = GetDateTimeUseCase()
    private lateinit var db: MyRoomManager

    fun clickBtn(
        context: Context,
        binding: ActivityRegisterBinding
    ) {
        binding.buttonRegister.setOnClickListener {
            addUser(context, binding)
        }
    }
    var uri: Uri? = null

    private fun addUser(
        context: Context,
        binding: ActivityRegisterBinding
    ) {
        db = Room.databaseBuilder(
            context,
            MyRoomManager::class.java, "db_sessions"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()


        if (isEmpty(binding)) {
            db.userDAO().addUser(
                user = getUser(binding)
            )
            db.sessionDAO().createSession(
                Session(
                    device_name = Build.MANUFACTURER + Build.MODEL,
                    user_id = getUserDB(getUser(binding)).id!!,
                    isStatus = StatusSession.Active.name
                )
            )

            for (i in db.userDAO().getUsers()) {
                println(i)
            }

            for (i in db.sessionDAO().getSessionAll()) {
                println(i)
            }
            registerUseCase.execute(
                getUser(binding)
            )
        } else {
            binding.username.error = "Поле ввода пустое"
            binding.firstName.error = "Поле ввода пустое"
            binding.lastName.error = "Поле ввода пустое"
            binding.surname.error = "Поле ввода пустое"
            binding.password.error = "Поле ввода пустое"
            binding.city.error = "Поле ввода пустое"
            binding.email.error = "Поле ввода пустое"
        }
    }

    private fun getUserDB(
        user: User
    ): User = db.userDAO().getUser(
        avatar = user.avatar,
        username = user.username,
        first_name = user.first_name,
        last_name = user.last_name,
        surname = user.surname,
        password = user.password,
        email = user.email,
        city = user.city,
        date_registration = getDateTimeUseCase.execute()
    )

    private fun getUser(
        binding: ActivityRegisterBinding
    ): User = User(
        avatar = uri.toString(),
        username = binding.username.text.toString(),
        first_name = binding.firstName.text.toString(),
        last_name = binding.lastName.text.toString(),
        surname = binding.surname.text.toString(),
        password = binding.password.text.toString(),
        email = binding.email.text.toString(),
        city = binding.city.text.toString(),
        date_registration = getDateTimeUseCase.execute()
    )

    private fun isNotRepeat(
        user: User,
        binding: ActivityRegisterBinding
    ): Boolean {
        return  getUser(binding).email != getUserDB(user).email &&
                getUser(binding).username != getUserDB(user).username
    }

    private fun isEmpty(
        binding: ActivityRegisterBinding
    ): Boolean {
        return !binding.username.text?.isEmpty()!! && !binding.firstName.text?.isEmpty()!! &&
                !binding.lastName.text?.isEmpty()!! && !binding.surname.text?.isEmpty()!! &&
                !binding.password.text?.isEmpty()!! && !binding.city.text?.isEmpty()!! &&
                !binding.email.text?.isEmpty()!!
    }
}