package ru.project.examtest.ui.basic_formulas;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class AdapterViewPager extends FragmentStateAdapter {
    private FragmentActivity fragmentActivity;
    private Fragment[] fragments;

    public AdapterViewPager(
            FragmentActivity fragmentActivity,
            Fragment[] fragments
    ) {
        super(fragmentActivity);
        this.fragmentActivity = fragmentActivity;
        this.fragments = fragments;
    }

    public void setFragmentActivity(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }

    public void setFragments(Fragment[] fragments) {
        this.fragments = fragments;
    }

    public Fragment[] getFragments() {
        return fragments;
    }

    public FragmentActivity getFragmentActivity() {
        return fragmentActivity;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
            return getFragments()[position];
    }

    @Override
    public int getItemCount() {
        return getFragments().length;
    }
}
