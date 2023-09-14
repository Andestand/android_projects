package ru.project.workaccounting.ui.main

import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.project.workaccounting.R
import ru.project.workaccounting.ui.map.MapFragment
import ru.project.workaccounting.ui.reports.ReportsFragment

class MainViewModel: ViewModel() {

    fun bottomNavigationView(
        fragmentContainerView: FragmentContainerView,
        fragmentManager: FragmentManager,
        bottomNavigationView: BottomNavigationView
    ) {
        bottomNavigationView.setOnItemSelectedListener {
                when(it.itemId) {
                    R.id.reportsItem -> {
                        fragmentManager.beginTransaction().replace(
                            fragmentContainerView.id,
                            ReportsFragment()
                        ).commit()
                    }

                    R.id.mapItem -> {
                        fragmentManager.beginTransaction().replace(
                            fragmentContainerView.id,
                            MapFragment()
                        ).commit()
                    }
                }
                true
            }
    }
}