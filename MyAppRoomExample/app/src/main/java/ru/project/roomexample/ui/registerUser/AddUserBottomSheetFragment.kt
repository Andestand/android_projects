package ru.project.roomexample.ui.registerUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.project.roomexample.R
import ru.project.roomexample.databinding.WriteUsersBinding

class AddUserBottomSheetFragment: BottomSheetDialogFragment() {
    private lateinit var binding: WriteUsersBinding

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
}
