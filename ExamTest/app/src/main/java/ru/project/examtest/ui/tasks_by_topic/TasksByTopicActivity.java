package ru.project.examtest.ui.tasks_by_topic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import ru.project.examtest.databinding.ActivityTasksByTopicBinding;

public class TasksByTopicActivity extends AppCompatActivity {
    protected ActivityTasksByTopicBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTasksByTopicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbar6.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}