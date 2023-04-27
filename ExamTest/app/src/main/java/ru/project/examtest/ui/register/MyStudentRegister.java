package ru.project.examtest.ui.register;

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
import ru.project.examtest.databinding.RegisterAdminBinding;
import ru.project.examtest.databinding.StudentRegBinding;
import ru.project.examtest.domain.models.Teacher;

public class MyStudentRegister extends BottomSheetDialogFragment {
    protected StudentRegBinding binding;
    MyRoomManager db;

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
        binding = StudentRegBinding.inflate(getLayoutInflater());
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

        binding.RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStudentEmpty()) {
                    db.studentDAO().AddStudent(getStudent());
                } else {
                    binding.username.setError("Поля пустые");
                    binding.password.setError("Поля пустые");
                }
            }
        });
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