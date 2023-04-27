package ru.project.examtest.ui.tables_and_diagrams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.tabs.TabLayoutMediator;
import ru.project.examtest.databinding.ActivityTablesAndDiagramsBinding;
import ru.project.examtest.ui.basic_formulas.AdapterViewPager;


public class TablesAndDiagramsActivity extends AppCompatActivity {
    protected ActivityTablesAndDiagramsBinding binding;

    Fragment[] fragments = {
            new TableFragment(),
            new DiagramFragment()
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
        binding.vp.setAdapter(vp);

        new TabLayoutMediator(
                binding.tl,
                binding.vp,
                ((tab, position) -> tab.setText(names[position]))
        ).attach();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTablesAndDiagramsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbar5.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tabLayout();
    }
}