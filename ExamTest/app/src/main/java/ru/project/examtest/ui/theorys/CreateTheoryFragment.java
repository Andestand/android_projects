package ru.project.examtest.ui.theorys;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.project.examtest.data.db.MyRoomManager;
import ru.project.examtest.data.models.RoomTerms;
import ru.project.examtest.data.models.RoomTheory;
import ru.project.examtest.databinding.FragmentCreateTheoryBinding;

public class CreateTheoryFragment extends Fragment {
    protected FragmentCreateTheoryBinding binding;
    private MyRoomManager db;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateTheoryBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = Room.databaseBuilder(
                view.getContext(),
                MyRoomManager.class,
                "database"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build();

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.theoryDAO().AddTheory(getTheory());
                binding.theory.setText("");
            }
        });
    }

    public RoomTheory getTheory() {
        return new RoomTheory(
                binding.theory.getText().toString()
        );
    }
}