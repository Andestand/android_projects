package ru.project.examtest.ui.TestAdapter;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ru.project.examtest.data.models.RoomTestOgeP;
import ru.project.examtest.databinding.FragmentTemplateItemTestBinding;

public class TemplateItemTestFragment extends Fragment {
    private FragmentTemplateItemTestBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTemplateItemTestBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    public TemplateItemTestFragment(RoomTestOgeP test) {
        binding.text.setText(test.text);
        binding.correctAnswer.setText(test.correct_answer);
    }

}
