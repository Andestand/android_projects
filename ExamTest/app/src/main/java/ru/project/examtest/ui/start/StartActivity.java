package ru.project.examtest.ui.start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ru.project.examtest.databinding.ActivityStartBinding;
import ru.project.examtest.ui.admin.AdminActivity;
import ru.project.examtest.ui.main.MainActivity;
import ru.project.examtest.databinding.RegisterAdminBinding;
import ru.project.examtest.ui.selections_click_buttons.ra_bottomFragStudent;
import ru.project.examtest.ui.selections_click_buttons.reg_auth_BottomFragment;

public class StartActivity extends AppCompatActivity {
    protected ActivityStartBinding binding;
    /*MyRoomManager db = Room.databaseBuilder(
            getApplicationContext(),
            MyRoomManager.class,
            "database"
    ).build();*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.studentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ra_bottomFragStudent().show(getSupportFragmentManager(), "ra");

                /*startActivity(
                        new Intent(
                                getApplicationContext(),
                                MainActivity.class
                        )
                );*/
            }
        });

        binding.teacherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new reg_auth_BottomFragment().show(getSupportFragmentManager(), "auth");
                /*startActivity(
                        new Intent(
                                getApplicationContext(),
                                AdminActivity.class
                        )
                );*/
            }
        });

    }

    void createTeacher(
            RegisterAdminBinding binding
    ) {
        /*db.teacherDAO().AddTeacher(new RoomTeacher(
                binding.username.getText().toString(),
                binding.password.getText().toString()
        ));*/
    }
}