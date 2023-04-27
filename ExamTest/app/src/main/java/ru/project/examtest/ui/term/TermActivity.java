package ru.project.examtest.ui.term;

import ru.project.examtest.data.models.RoomTerms;
import ru.project.examtest.databinding.ActivityTermBinding;
import androidx.appcompat.app.AppCompatActivity;
import ru.project.examtest.domain.models.Term;
import android.os.Bundle;
import android.view.View;

public class TermActivity extends AppCompatActivity {
    protected ActivityTermBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTermBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbarTerm.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setTerm(
                (RoomTerms) getIntent().getExtras().getSerializable("term")
        );
    }

    public void setTerm(RoomTerms term) {
        binding.title.setText(term.getTitle());
        binding.description.setText(term.getDescription());
    }
}
