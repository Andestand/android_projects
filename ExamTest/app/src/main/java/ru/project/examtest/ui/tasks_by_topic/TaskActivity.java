package ru.project.examtest.ui.tasks_by_topic;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;

import com.bumptech.glide.Glide;

import ru.project.examtest.R;
import ru.project.examtest.data.models.RoomTasks;
import ru.project.examtest.databinding.ActivityTaskBinding;

public class TaskActivity extends AppCompatActivity {
    protected ActivityTaskBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbarTask.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        setTask(
                (RoomTasks) getIntent().getExtras().getSerializable("task")
        );
    }

    public void setTask(RoomTasks tasks) {
        binding.title.setText(tasks.title);
        MediaController mc = new MediaController(
                getApplicationContext()
        );
        binding.vv.setMediaController(
                mc
        );
        mc.setAnchorView(binding.vv);
        //binding.vv.setVideoURI(Uri.parse(tasks.link));
        binding.vv.setVideoPath("android:resource//"+getPackageName()+R.raw.video);
        binding.vv.requestFocus(0);
        binding.vv.start();
    }
}
