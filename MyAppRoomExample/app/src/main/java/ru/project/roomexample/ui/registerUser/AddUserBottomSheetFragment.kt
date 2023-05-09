package ru.project.roomexample.ui.registerUser

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.room.Room
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.project.roomexample.R
import ru.project.roomexample.data.models.UserRoom
import ru.project.roomexample.data.room.MyRoomManager
import ru.project.roomexample.databinding.WriteUsersBinding
import ru.project.roomexample.ui.main.AdapterUsers
import ru.project.roomexample.ui.main.MainActivity

class AddUserBottomSheetFragment: BottomSheetDialogFragment() {
    private lateinit var binding: WriteUsersBinding
    private lateinit var db: MyRoomManager


    override fun getTheme(): Int {
        return R.style.BackgroundBottomSheet
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = WriteUsersBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = Room.databaseBuilder(
            view.context,
            MyRoomManager::class.java,
            "database"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
        binding.AddButton.setOnClickListener {
            if (!isUser(getUser()) and isUserEmpty()) {
                db.userDAO().addUser(getUser())
                Toast.makeText(view.context, "Пользователь создан", Toast.LENGTH_SHORT).show()
                onStop()
            } else {
                binding.username.error = "Пользователь с таким ником уже создан"
                Toast.makeText(view.context, "Пользователь не создан", Toast.LENGTH_SHORT).show()
            }

            if (isUserEmpty()) {
                binding.username.error = "Поле ввода ника пустое"
                binding.password.error = "Поле ввода пароля пустое"
            }
        }

    }

    private fun isUser(userRoom: UserRoom): Boolean = db.userDAO().isUser(
        username = userRoom.username,
        password = userRoom.password
    ) != null

    private fun isUserEmpty(): Boolean =
        binding.username.text?.isEmpty()!! and binding.password.text?.isEmpty()!!


    private fun getUser(): UserRoom = UserRoom(
            username = binding.username.text.toString(),
            password = binding.password.text.toString()
    )

}
