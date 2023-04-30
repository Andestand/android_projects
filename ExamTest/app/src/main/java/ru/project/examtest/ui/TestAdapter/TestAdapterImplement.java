package ru.project.examtest.ui.TestAdapter;


import android.widget.SeekBar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;

import ru.project.examtest.ui.basic_formulas.AdapterViewPager;

public class TestAdapterImplement {
    AdapterViewPager vp;
    SeekBar seekBar;

    public TestAdapterImplement(
            Integer maxSize
    ) {

    }

    void setAdapter(FragmentActivity fa, Fragment[] fragmentList) {
        vp = new AdapterViewPager(
            fa,
            fragmentList
        );
        seekBar.setMax(getItemSizeFragment());

    }

    public void mediator() {

    }

    public int getItemSizeFragment() {
        return vp.getItemCount();
    }
}
