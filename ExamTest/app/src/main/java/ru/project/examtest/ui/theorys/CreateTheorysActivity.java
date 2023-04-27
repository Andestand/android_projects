package ru.project.examtest.ui.theorys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayoutMediator;
import ru.project.examtest.databinding.ActivityCreateTheorysBinding;
import ru.project.examtest.ui.basic_formulas.AdapterViewPager;
import ru.project.examtest.ui.terms.TermsFragment;

public class CreateTheorysActivity extends AppCompatActivity {
    protected ActivityCreateTheorysBinding binding;

    Fragment[] fragments = {
            new CreateTheoryFragment(),
            new CreateBF_Fragment(),
            new CreateTermFragment()
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
        binding = ActivityCreateTheorysBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        tabLayout();
    }
}