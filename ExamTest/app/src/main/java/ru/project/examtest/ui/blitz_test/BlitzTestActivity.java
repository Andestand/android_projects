package ru.project.examtest.ui.blitz_test;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ru.project.examtest.databinding.ActivityBlitzTestBinding;

public class BlitzTestActivity extends AppCompatActivity {
    protected ActivityBlitzTestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBlitzTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbar4.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}