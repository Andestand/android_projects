package ru.project.examtest.ui.tables_and_diagrams;

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
import ru.project.examtest.data.models.RoomTables;
import ru.project.examtest.databinding.FragmentTableBinding;


public class TableFragment extends Fragment {
    protected FragmentTableBinding binding;
    protected final AdapterTables adapter = new AdapterTables();
    MyRoomManager db;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTableBinding.inflate(getLayoutInflater());

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

        for (RoomTables i: db.tablesDAO().TablesAll()) {
            adapter.addImage(i);
        }
    }


    public void init() {
        binding.rvTables.setLayoutManager(
                new GridLayoutManager(getContext(), 1)
        );

        binding.rvTables.setAdapter(
                adapter
        );
    }
}