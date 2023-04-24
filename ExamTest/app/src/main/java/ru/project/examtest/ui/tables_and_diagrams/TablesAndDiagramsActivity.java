package ru.project.examtest.ui.tables_and_diagrams;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ru.project.examtest.databinding.ActivityTablesAndDiagramsBinding;

public class TablesAndDiagramsActivity extends AppCompatActivity {
    protected ActivityTablesAndDiagramsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTablesAndDiagramsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbar5.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}