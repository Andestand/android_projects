package ru.project.examtest.ui.theory;

import ru.project.examtest.data.models.RoomTheory;
import ru.project.examtest.databinding.ActivityTheoryBinding;
import androidx.appcompat.app.AppCompatActivity;
import ru.project.examtest.domain.models.Theory;
import android.os.Bundle;
import android.view.View;

public class TheoryActivity extends AppCompatActivity {
    protected ActivityTheoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTheoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbarTheory.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        setTheory(
                (RoomTheory) getIntent().getExtras().getSerializable("theory")
        );
    }

    public void setTheory(RoomTheory theory) {
        binding.text.setText(theory.getText());

    }
}