package ru.project.examtest.ui.terms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ru.project.examtest.databinding.ActivityTermsBinding;

public class TermsActivity extends AppCompatActivity {
    protected ActivityTermsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTermsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}