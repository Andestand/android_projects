package ru.project.examtest.ui.selections_click_buttons;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import ru.project.examtest.R;
import ru.project.examtest.databinding.RaStudentBinding;
import ru.project.examtest.databinding.RegAuthAdminBinding;
import ru.project.examtest.ui.auth.MyAuthAdmin;
import ru.project.examtest.ui.auth.MyAuthStudent;
import ru.project.examtest.ui.register.MyRegisterAdmin;
import ru.project.examtest.ui.register.MyStudentRegister;

public class ra_bottomFragStudent extends BottomSheetDialogFragment {
    protected RaStudentBinding binding;

    @SuppressLint("ResourceType")
    @Override
    public int getTheme() {
        return R.style.AppBottomSheetDialogTheme;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState
    ) {
        binding = RaStudentBinding.inflate(getLayoutInflater());
        ButtonsClick();
        return binding.getRoot();

    }

    public void ButtonsClick() {
        binding.AuthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert getFragmentManager() != null;
                new MyAuthStudent().show(getFragmentManager(), "auth");
            }
        });

        binding.RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert getFragmentManager() != null;
                new MyStudentRegister().show(getFragmentManager(), "reg");
            }
        });
    }
}
