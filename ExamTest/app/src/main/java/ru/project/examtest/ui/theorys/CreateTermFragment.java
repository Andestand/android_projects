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
import ru.project.examtest.data.models.RoomTerms;
import ru.project.examtest.databinding.FragmentCreateTermBinding;


public class CreateTermFragment extends Fragment {
    protected FragmentCreateTermBinding binding;
    private MyRoomManager db;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateTermBinding.inflate(getLayoutInflater());
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
                db.termsDAO().AddTerm(getTerm());
                binding.title.setText("");
                binding.description.setText("");
            }
        });
    }

    public RoomTerms getTerm() {
        return new RoomTerms(
                binding.title.getText().toString(),
                binding.description.getText().toString()
        );
    }
}