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
import ru.project.examtest.data.models.RoomBasicFormula;
import ru.project.examtest.databinding.FragmentCreateBFBinding;

public class CreateBF_Fragment extends Fragment {
    protected FragmentCreateBFBinding binding;
    private MyRoomManager db;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateBFBinding.inflate(getLayoutInflater());
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
                db.basicFormulasDAO().AddBasicFormulas(getBF());
                binding.formula.setText("");
                binding.description.setText("");
            }
        });
    }

    public RoomBasicFormula getBF() {
        return new RoomBasicFormula(
                binding.formula.getText().toString(),
                binding.description.getText().toString()
        );
    }
}