package ru.project.examtest.ui.basic_formulas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ru.project.examtest.data.models.RoomBasicFormula;
import ru.project.examtest.databinding.ActivityBfpageBinding;

public class BFPageActivity extends AppCompatActivity {
    protected ActivityBfpageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBfpageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbarFormula.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        setBF(
                (RoomBasicFormula) getIntent().getExtras().getSerializable("basic_formula")
        );
    }

    public void setBF(RoomBasicFormula bf) {
        binding.formula.setText(bf.getFormula());
        binding.description.setText(bf.getDescription());
    }
}