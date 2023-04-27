package ru.project.examtest.ui.tables_and_diagrams;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ru.project.examtest.data.db.MyRoomManager;
import ru.project.examtest.data.models.RoomTables;
import ru.project.examtest.databinding.FragmentCreateTableBinding;


public class CreateTableFragment extends Fragment {
    protected FragmentCreateTableBinding binding;
    private MyRoomManager db;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateTableBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = Room.databaseBuilder(
                requireContext().getApplicationContext(),
                MyRoomManager.class,
                "database"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build();

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.tablesDAO().AddTables(getTable());
            }
        });
    }

    public RoomTables getTable() {
        return new RoomTables(
                binding.title.getText().toString(),
                binding.link.getText().toString()
        );
    }
}