package ru.project.examtest.ui.basic_formulas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import android.os.Bundle;
import android.view.View;

import ru.project.examtest.arrays.BasicFormulasArrays;
import ru.project.examtest.data.models.RoomBasicFormula;
import ru.project.examtest.databinding.ActivityBasicFormulasBinding;

public class BasicFormulasActivity extends AppCompatActivity {
    protected ActivityBasicFormulasBinding binding;
    private final AdapterBasicFormulas adapter = new AdapterBasicFormulas();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBasicFormulasBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();

        binding.toolbar2.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        for (RoomBasicFormula i: BasicFormulasArrays.array) {
            adapter.addBasicFormula(
                    i
            );
        }
    }

    private void init() {
        binding.rvBf.setLayoutManager(
                new GridLayoutManager(getApplicationContext(), 1)
        );

        binding.rvBf.setAdapter(
                adapter
        );
    }
}