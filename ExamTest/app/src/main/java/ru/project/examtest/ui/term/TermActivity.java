package ru.project.examtest.ui.term;

import ru.project.examtest.databinding.ActivityTermBinding;
import androidx.appcompat.app.AppCompatActivity;
import ru.project.examtest.domain.models.Term;
import android.annotation.SuppressLint;
import android.os.Bundle;

public class TermActivity extends AppCompatActivity {
    protected ActivityTermBinding binding;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTermBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTerm(
                (Term) getIntent().getExtras().getSerializable("term")
        );
    }

    public void setTerm(Term term) {
        binding.title.setText(term.getTitle());
        binding.description.setText(term.getDescription());
    }
}
