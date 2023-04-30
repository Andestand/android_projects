package ru.project.examtest.ui.theorys;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.project.examtest.data.db.MyRoomManager;
import ru.project.examtest.data.models.RoomTheory;
import ru.project.examtest.databinding.FragmentTheorysBinding;
import ru.project.examtest.domain.models.Theory;


public class TheorysFragment extends Fragment {
    protected FragmentTheorysBinding binding;
    private final AdapterTheory adapter = new AdapterTheory();
    private MyRoomManager db;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTheorysBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        db = Room.databaseBuilder(
                view.getContext(),
                MyRoomManager.class,
                "database"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build();

        for (RoomTheory i: db.theoryDAO().getTheoryAll()) {
            adapter.addTheory(i);
        }
    }

    public void init() {
        binding.rvTheorys.setLayoutManager(
                new GridLayoutManager(getContext(), 1)
        );

        binding.rvTheorys.setAdapter(
                adapter
        );

    }
}