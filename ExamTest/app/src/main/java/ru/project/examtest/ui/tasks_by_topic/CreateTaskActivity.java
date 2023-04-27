package ru.project.examtest.ui.tasks_by_topic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.os.Bundle;
import android.view.View;
import ru.project.examtest.data.db.MyRoomManager;
import ru.project.examtest.data.models.RoomTasks;
import ru.project.examtest.databinding.ActivityCreateTaskBinding;

public class CreateTaskActivity extends AppCompatActivity {
    protected ActivityCreateTaskBinding binding;
    MyRoomManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.toolbarTask.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        db = Room.databaseBuilder(
                this.getBaseContext(),
                MyRoomManager.class,
                "database"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build();

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.tasksDAO().AddTask(getTask());
                binding.title.setText("");
                binding.link.setText("");
            }
        });
    }

    public RoomTasks getTask() {
        return new RoomTasks(
                binding.title.getText().toString(),
                binding.link.getText().toString()
        );
    }
}