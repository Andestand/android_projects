package ru.project.examtest.ui.auth;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import ru.project.examtest.R;
import ru.project.examtest.databinding.AuthDialogBinding;
import ru.project.examtest.domain.models.Teacher;

public class MyAuthAdmin extends BottomSheetDialogFragment {

    @SuppressLint("ResourceType")
    @Override
    public int getTheme() {
        return R.style.AppBottomSheetDialogTheme;
    }

    protected AuthDialogBinding binding;
    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        binding = AuthDialogBinding.inflate(getLayoutInflater());
        setTeacher(
                new Teacher(
                        binding.username.getText().toString(),
                        binding.password.getText().toString()
                )
        );
        return binding.getRoot();
    }

    public boolean isValid() {

        return false;
    }

    public boolean setTeacher(Teacher teacher) {

        return false;
    }
}
