package ru.project.examtest.ui.tables_and_diagrams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayoutMediator;
import ru.project.examtest.databinding.ActivityCreateTadBinding;
import ru.project.examtest.ui.basic_formulas.AdapterViewPager;

public class CreateTAD_Activity extends AppCompatActivity {
    protected ActivityCreateTadBinding binding;

    Fragment[] fragments = {
            new CreateTableFragment(),
            new CreateDiagramsFragment()
    };

    String[] names = {
            "Таблицы",
            "Схемы"
    };

    AdapterViewPager vp = new AdapterViewPager(
            this,
            fragments
    );

    private void tabLayout() {
        binding.vp2.setAdapter(vp);

        new TabLayoutMediator(
                binding.tabLayout,
                binding.vp2,
                ((tab, position) -> tab.setText(names[position]))
        ).attach();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateTadBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.toolbarTAD.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tabLayout();
    }
}