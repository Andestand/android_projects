package ru.project.examtest.ui.point_calculator;

import ru.project.examtest.databinding.ActivityPointCalculatorBinding;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.disklrucache.DiskLruCache;

public class PointCalculatorActivity extends AppCompatActivity {
    protected ActivityPointCalculatorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPointCalculatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbarPC.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        PC();
    }

    private void PC() {
        binding.buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer numbAl = Integer.valueOf(binding.numbAll.getText().toString());
                Integer numSiz = Integer.valueOf(binding.numbSize.getText().toString());
                Integer result = numbAl / numSiz;

                binding.resultNumb.setText(
                    result.toString()
                );
            }
        });
    }
}