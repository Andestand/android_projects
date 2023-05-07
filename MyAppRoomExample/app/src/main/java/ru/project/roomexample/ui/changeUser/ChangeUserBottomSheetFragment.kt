package ru.project.roomexample.ui.changeUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.project.roomexample.R
import ru.project.roomexample.data.models.UserRoom
import ru.project.roomexample.data.room.MyRoomManager
import ru.project.roomexample.databinding.ChangeUsersBinding
import ru.project.roomexample.databinding.WriteUsersBinding

class ChangeUserBottomSheetFragment(var userRoom: UserRoom): BottomSheetDialogFragment() {
    private lateinit var binding: ChangeUsersBinding
    private lateinit var db: MyRoomManager

    override fun getTheme(): Int {
        return R.style.BackgroundBottomSheet
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ChangeUsersBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = Room.databaseBuilder(
            view.context,
            MyRoomManager::class.java,
            "database"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
        setUser(userRoom)
        binding.ChangeButton.setOnClickListener {
            if (isUserEmpty() and isUsername(getUser())) {
                db.userDAO().changeUser(getUser())
                onStop()
            } else {
                binding.username.error = "Такой никнейм уже занят"
            }

            if (isUserEmpty()) {
                binding.username.error = "Поле ввода ника пустое"
                binding.password.error = "Поле ввода пароля пустое"
            }

        }
    }

    private fun isUsername(user: UserRoom): Boolean = db.userDAO().isUser(
        username = user.username,
        password = user.password
    ).username != null

    private fun setUser(userRoom: UserRoom) {
        binding.username.setText(userRoom.username)
        binding.password.setText(userRoom.password)
    }

    private fun isUserEmpty(): Boolean =
        binding.username.text?.isEmpty()!! and binding.password.text?.isEmpty()!!

    private fun getUser(): UserRoom = UserRoom(
        username = binding.username.text.toString(),
        password = binding.password.text.toString()
    )
}
