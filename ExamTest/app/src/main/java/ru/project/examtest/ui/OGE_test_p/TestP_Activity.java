package ru.project.examtest.ui.OGE_test_p;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.room.Room;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.Set;

import ru.project.examtest.data.db.MyRoomManager;
import ru.project.examtest.data.models.RoomTestOgeP;
import ru.project.examtest.databinding.ActivityTestPactivityBinding;
import ru.project.examtest.domain.models.Test;
import ru.project.examtest.ui.TestAdapter.TemplateItemTestFragment;

public class TestP_Activity extends AppCompatActivity {
    protected ActivityTestPactivityBinding binding;
    MyRoomManager db;
    private int index = 0;
    ArrayList<RoomTestOgeP> arrayList = new ArrayList<>();

    public Fragment getFragmentTest(RoomTestOgeP test) {
        return new TemplateItemTestFragment(test);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestPactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = Room.databaseBuilder(
                getApplicationContext(),
                MyRoomManager.class,
                "database"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build();

        binding.seekBarTests.setMax(db.roomTestOgeP().all().size());
        binding.seekBarTests.setProgress(0);
        binding.seekBarTests.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    binding.seekBarTests.setProgress(index);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        binding.BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index--;

                if (index != -1) {
                    getSupportFragmentManager().beginTransaction().replace(
                            binding.fragmentContainerView.getId(),
                            getFragmentTest(arrayList.get(index))
                    ).commit();
                }
            }
        });

        binding.ForwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                if (index != db.roomTestOgeP().all().size()) {
                    getSupportFragmentManager().beginTransaction().replace(
                            binding.fragmentContainerView.getId(),
                            getFragmentTest(arrayList.get(index))
                    ).commit();
                }

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        arrayList.add(
                new RoomTestOgeP("2+2", "4")
        );
    }

    public Boolean isCorrectAnswer(String correct_answer) {
        return db.roomTestOgeP().isCorrectAnswer(correct_answer) != null;
    }
}