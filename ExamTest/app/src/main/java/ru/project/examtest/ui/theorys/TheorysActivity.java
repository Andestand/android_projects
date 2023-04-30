package ru.project.examtest.ui.theorys;

import ru.project.examtest.ui.basic_formulas.FragmentBasicFormulas;
import ru.project.examtest.ui.basic_formulas.AdapterViewPager;
import ru.project.examtest.databinding.ActivityTheorysBinding;
import com.google.android.material.tabs.TabLayoutMediator;

import ru.project.examtest.ui.terms.TermsFragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class TheorysActivity extends AppCompatActivity {
    protected ActivityTheorysBinding binding;

    Fragment[] fragments = {
            new TheorysFragment(),
            new FragmentBasicFormulas(),
            new TermsFragment()
    };

    String[] names = {
            "Теория",
            "Основные формулы",
            "Термины"
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
        binding = ActivityTheorysBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbarTheory.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tabLayout();
    }


}
