package ru.project.examtest.ui.theory;

import ru.project.examtest.databinding.ActivityTheoryBinding;
import androidx.appcompat.app.AppCompatActivity;
import ru.project.examtest.domain.models.Theory;
import android.os.Bundle;

public class TheoryActivity extends AppCompatActivity {
    protected ActivityTheoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTheoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTheory(
                (Theory) getIntent().getExtras().getSerializable("theory")
        );
    }

    public void setTheory(Theory theory) {
        binding.text.setText(theory.getText());
    }
}