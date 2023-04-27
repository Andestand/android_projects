package ru.project.examtest.ui.auth;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Room;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import ru.project.examtest.R;
import ru.project.examtest.data.db.MyRoomManager;
import ru.project.examtest.data.models.RoomStudent;
import ru.project.examtest.databinding.AuthDialogBinding;
import ru.project.examtest.databinding.AuthStudentBinding;
import ru.project.examtest.domain.models.Teacher;
import ru.project.examtest.ui.main.MainActivity;

public class MyAuthStudent extends BottomSheetDialogFragment {
    MyRoomManager db;

    @SuppressLint("ResourceType")
    @Override
    public int getTheme() {
        return R.style.AppBottomSheetDialogTheme;
    }

    protected AuthStudentBinding binding;
    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        binding = AuthStudentBinding.inflate(getLayoutInflater());

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = Room.databaseBuilder(
                view.getContext(),
                MyRoomManager.class,
                "database"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build();

        binding.AuthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStudent(getStudent()) && isStudentEmpty()) {
                    startActivity(
                            new Intent(
                                    view.getContext(),
                                    MainActivity.class
                            )
                    );
                } else {
                    binding.username.setError("Данные неверны");
                    binding.password.setError("Данные неверны");
                }
            }
        });
    }

    public Boolean isStudent(RoomStudent student) {
        return db.studentDAO().isStudent(
                student.getUsername(),
                student.getPassword()
        ) != null;
    }

    public Boolean isStudentEmpty()  {
        return !getStudent().getUsername().isEmpty() && !getStudent().getPassword().isEmpty();
    }


    public RoomStudent getStudent() {
        return new RoomStudent(
             binding.username.getText().toString(),
             binding.password.getText().toString()
        );
    }
}
