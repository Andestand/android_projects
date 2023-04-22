package ru.project.examtest.ui.term;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import ru.project.examtest.databinding.ActivityTermBinding;

public class TermActivity extends AppCompatActivity {
    protected ActivityTermBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTermBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
