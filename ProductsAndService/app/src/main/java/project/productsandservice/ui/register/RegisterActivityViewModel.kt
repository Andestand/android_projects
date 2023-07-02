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
import android.util.Log
import android.widget.Toast
import kotlin.math.absoluteValue

class RegisterActivityViewModel: ViewModel() {
    private val stdbi = AuthDataBaseImplement()
    private val registerUseCase = RegisterUseCase(stdbi)
    private val getDateTimeUseCase = GetDateTimeUseCase()
    private lateinit var db: MyRoomManager
    private val deviceFullName = "${Build.MANUFACTURER} ${Build.BRAND} ${Build.DEVICE}"


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
        Log.d("RegisterClassDebugger", "Начало выполения метода")
        db = Room.databaseBuilder(
            context,
            MyRoomManager::class.java, "db_sessions"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()

        if (isEmpty(binding)) {
            Log.d("RegisterClassDebugger", "Начало выполения условия")
            val long = db.userDAO().addUser(
                user = getUser(binding)
            )
            if (/*isNotRepeat(binding)*/ long != -1L) {

                println(long)
                //val userId = getUserDB(getUser(binding)).id!!

                /*db.sessionDAO().createSession(
                    Session(
                        device_name = deviceFullName,
                        user_id = getUserDB(getUser(binding)).id!!,
                        isStatus = StatusSession.Active.name
                    )
                )*/
                registerUseCase.execute(
                    getUser(binding)
                )

                for (i in db.userDAO().getUsers()) {
                    println(i)
                }

                for (i in db.sessionDAO().getSessionAll()) {
                    println(i)
                }
                Toast.makeText(context, "Пользователь создан!",
                    Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Такой username или email существует",
                    Toast.LENGTH_SHORT).show()

            }


        } else {
            Log.d("RegisterClassDebugger", "Условие неверно")
            Toast.makeText(context, "Не удалось зарегестрировать пользователя!", Toast.LENGTH_SHORT).show()
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
        date_registration = user.date_registration
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
        binding: ActivityRegisterBinding
    ): Boolean = isUsername(binding) == null && isEmail(binding) == null

    private fun isUsername(
        binding: ActivityRegisterBinding
    ): String? = try {
        db.userDAO().getUsernameAndEmail(getUser(binding).username, getUser(binding).email).username
    } catch (npe: NullPointerException) {
        null
    }

    private fun isEmail(
        binding: ActivityRegisterBinding
    ): String? = try {
        db.userDAO().getUsernameAndEmail(getUser(binding).username, getUser(binding).email).email
    } catch (npe: NullPointerException) {
        null
    }

    private fun isEmpty(
        binding: ActivityRegisterBinding
    ): Boolean = !binding.username.text?.isEmpty()!! && !binding.firstName.text?.isEmpty()!! &&
            !binding.lastName.text?.isEmpty()!! && !binding.surname.text?.isEmpty()!! &&
            !binding.password.text?.isEmpty()!! && !binding.city.text?.isEmpty()!! &&
            !binding.email.text?.isEmpty()!!
}
