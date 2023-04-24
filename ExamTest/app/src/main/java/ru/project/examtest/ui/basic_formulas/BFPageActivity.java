package ru.project.examtest.ui.basic_formulas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import ru.project.examtest.data.models.RoomBasicFormula;
import ru.project.examtest.databinding.ActivityBfpageBinding;

public class BFPageActivity extends AppCompatActivity {
    protected ActivityBfpageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBfpageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setBF(
                (RoomBasicFormula) getIntent().getExtras().getSerializable("basic_formula")
        );
    }

    public void setBF(RoomBasicFormula bf) {
        binding.text.setText(bf.getText());
    }
}