package ru.project.examtest.ui.register;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import ru.project.examtest.R;
import ru.project.examtest.databinding.RegisterAdminBinding;
import ru.project.examtest.domain.models.Teacher;

public class MyRegisterAdmin extends BottomSheetDialogFragment {
    protected RegisterAdminBinding binding;



    @Override
    public int getTheme() {
        return R.style.AppBottomSheetDialogTheme;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState
    ) {
        binding = RegisterAdminBinding.inflate(getLayoutInflater());


        binding.RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new StartActivity().createTeacher(binding);
            }
        });
        return binding.getRoot();
    }

    public boolean setTeacher(Teacher teacher) {
        if (binding.password.getText() == binding.repaetPassword.getText() &&
            binding.password.getText().toString().isEmpty() &&
            binding.repaetPassword.getText().toString().isEmpty() &&
                binding.username.getText().toString().isEmpty()
        ){
            return true;
        } else {
            return false;
        }


    }
}