package ru.project.examtest.ui.point_calculator;

import ru.project.examtest.databinding.ActivityPointCalculatorBinding;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PointCalculatorActivity extends AppCompatActivity {
    protected ActivityPointCalculatorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPointCalculatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbar3.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}