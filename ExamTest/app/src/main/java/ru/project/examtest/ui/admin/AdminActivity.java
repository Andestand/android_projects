package ru.project.examtest.ui.admin;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import ru.project.examtest.databinding.ActivityAdminBinding;

public class AdminActivity extends AppCompatActivity {
    ActivityAdminBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}