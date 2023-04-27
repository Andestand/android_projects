package ru.project.examtest.ui.basic_formulas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.room.Room;

import ru.project.examtest.arrays.BasicFormulasArrays;
import ru.project.examtest.data.db.MyRoomManager;
import ru.project.examtest.data.models.RoomBasicFormula;
import ru.project.examtest.databinding.FragmentBasicFormulasBinding;

public class FragmentBasicFormulas extends Fragment {
    protected FragmentBasicFormulasBinding binding;
    private final AdapterBasicFormulas adapter = new AdapterBasicFormulas();
    private MyRoomManager db;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        binding = FragmentBasicFormulasBinding.inflate(getLayoutInflater());
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
        for (RoomBasicFormula i: db.basicFormulasDAO().BasicFormulasAll()) {
            adapter.addBasicFormula(
                    i
            );
        }
    }



    private void init() {
        binding.rvBf.setLayoutManager(
                new GridLayoutManager(getContext(), 1)
        );

        binding.rvBf.setAdapter(
                adapter
        );
    }
}
