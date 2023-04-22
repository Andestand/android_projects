package ru.project.examtest.ui.theory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import ru.project.examtest.databinding.ActivityTheoryBinding;
import ru.project.examtest.domain.models.Theory;

public class TheoryActivity extends AppCompatActivity {
    protected ActivityTheoryBinding binding;
    private final AdapterTheory adapter = new AdapterTheory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTheoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    private void init() {
        binding.rvTheory.setLayoutManager(
                new GridLayoutManager(getApplicationContext(), 1)
        );

        binding.rvTheory.setAdapter(adapter);

        adapter.addTheory(
                new Theory("Теория")
        );

    }
}
