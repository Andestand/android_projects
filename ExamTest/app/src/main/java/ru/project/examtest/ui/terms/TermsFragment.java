package ru.project.examtest.ui.terms;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ru.project.examtest.arrays.TermArrays;
import ru.project.examtest.data.db.MyRoomManager;
import ru.project.examtest.data.models.RoomTerms;
import ru.project.examtest.databinding.FragmentTermsBinding;
import ru.project.examtest.domain.models.Term;


public class TermsFragment extends Fragment {
    protected FragmentTermsBinding binding;
    private final AdapterTerms adapter = new AdapterTerms();
    MyRoomManager db;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTermsBinding.inflate(getLayoutInflater());
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

        for (RoomTerms i: db.termsDAO().TermsAll()) {
            adapter.addTerm(i);
        }
    }


    private void init() {
        binding.rvTerms.setLayoutManager(
                new GridLayoutManager(getContext(), 1)
        );

        binding.rvTerms.setAdapter(adapter);
    }
}