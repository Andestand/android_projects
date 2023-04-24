package ru.project.examtest.ui.terms;

import ru.project.examtest.data.db.MyRoomManager;
import ru.project.examtest.databinding.ActivityTermsBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import ru.project.examtest.domain.models.Term;
import ru.project.examtest.arrays.TermArrays;
import android.os.Bundle;
import android.view.View;

public class TermsActivity extends AppCompatActivity {
    protected ActivityTermsBinding binding;
    private final AdapterTerms adapter = new AdapterTerms();
    /*MyRoomManager mrm = Room.databaseBuilder(
            this,
            MyRoomManager.class,
            "database"
    ).build();*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTermsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();

        binding.toolbarTerms.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        for (Term i: TermArrays.array) {
            adapter.addTerm(i);
        }
    }

    private void init() {
        binding.rvTerms.setLayoutManager(
                new GridLayoutManager(getApplicationContext(), 1)
        );

        binding.rvTerms.setAdapter(adapter);
    }
}