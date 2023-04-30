package ru.project.examtest.ui.tasks_by_topic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;

import ru.project.examtest.data.db.MyRoomManager;
import ru.project.examtest.data.models.RoomTasks;
import ru.project.examtest.databinding.ActivityTasksByTopicBinding;

public class TasksByTopicActivity extends AppCompatActivity {
    protected ActivityTasksByTopicBinding binding;
    private final AdapterTasks adapter = new AdapterTasks();
    MyRoomManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTasksByTopicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbarTBT.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        init();

        db = Room.databaseBuilder(
                this.getBaseContext(),
                MyRoomManager.class,
                "database"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build();

        for (RoomTasks i: db.tasksDAO().TaskAll()) {
            adapter.addTasks(i);
        }
    }

    public void init() {
        binding.rvTbt.setLayoutManager(
                new GridLayoutManager(getApplicationContext(), 1)
        );

        binding.rvTbt.setAdapter(
                adapter
        );

    }
}