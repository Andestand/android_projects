package ru.project.examtest.ui.theorys;

import ru.project.examtest.data.db.MyRoomManager;
import ru.project.examtest.databinding.ActivityTheorysBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import ru.project.examtest.domain.models.Theory;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import ru.project.examtest.arrays.TheoryArrays;
import android.os.Bundle;

public class TheorysActivity extends AppCompatActivity {
    protected ActivityTheorysBinding binding;
    private final AdapterTheory adapter = new AdapterTheory();
    MyRoomManager mrm = Room.databaseBuilder(
            getApplicationContext(),
            MyRoomManager.class,
            "database"
    ).build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTheorysBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        for (Theory i: TheoryArrays.array) {
            adapter.addTheory(i);
        }
    }

    private void init() {
        binding.rvTheory.setLayoutManager(
                new GridLayoutManager(getApplicationContext(), 1)
        );

        binding.rvTheory.setAdapter(adapter);

    }
}
