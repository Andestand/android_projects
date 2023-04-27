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
import ru.project.examtest.data.models.RoomTeacher;
import ru.project.examtest.databinding.AuthDialogBinding;
import ru.project.examtest.domain.models.Teacher;
import ru.project.examtest.ui.admin.AdminActivity;
import ru.project.examtest.ui.main.MainActivity;

public class MyAuthAdmin extends BottomSheetDialogFragment {
    MyRoomManager db;

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
                try {
                    if (isTeacher(getTeacher()) && isTeacherEmpty()) {
                        startActivity(
                                new Intent(
                                        view.getContext(),
                                        AdminActivity.class
                                )
                        );
                    } else {
                        binding.username.setError("Данные неверны");
                        binding.password.setError("Данные неверны");
                    }
                } catch (NullPointerException npe) {
                    System.out.println(npe.getMessage());
                    binding.username.setError("Поля пустые");
                    binding.password.setError("Поля пустые");
                }

            }
        });
    }

    public Boolean isTeacher(RoomTeacher teacher) {
        return db.teacherDAO().isTeacher(
                teacher.getUsername(),
                teacher.getPassword()
        ) != null;
    }

    public Boolean isTeacherEmpty()  {
        return !getTeacher().getUsername().isEmpty() && !getTeacher().getPassword().isEmpty();
    }

    public RoomTeacher getTeacher() {
        return new RoomTeacher(
                binding.username.getText().toString(),
                binding.password.getText().toString()
        );
    }
}
