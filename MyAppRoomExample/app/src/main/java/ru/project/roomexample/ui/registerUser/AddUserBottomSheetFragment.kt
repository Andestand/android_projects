package ru.project.roomexample.ui.registerUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.project.roomexample.R
import ru.project.roomexample.data.models.UserRoom
import ru.project.roomexample.data.room.MyRoomManager
import ru.project.roomexample.databinding.WriteUsersBinding

class AddUserBottomSheetFragment: BottomSheetDialogFragment() {
    private lateinit var binding: WriteUsersBinding
    private lateinit var db: MyRoomManager

    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = WriteUsersBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = Room.databaseBuilder(
            context = view.context,
            klass = MyRoomManager::class.java,
            name = "database"
        ).build()
        binding.AddButton.setOnClickListener {
            //db.userDAO().insertAll(getUser())
        }

    }

    private fun getUser(): UserRoom {
        return UserRoom(
            username = binding.username.text.toString(),
            password = binding.password.text.toString()
        )
    }
}
