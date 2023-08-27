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
        bottomNavigationView.apply {
            menu.findItem(R.id.map).isChecked = true

            setOnNavigationItemSelectedListener {
                when(it.itemId) {
                    R.id.map -> {
                        fragmentManager.apply {
                            beginTransaction().apply {
                                replace(
                                    fragmentContainerView.id,
                                    MapFragment()
                                ).commit()
                            }
                        }
                    }

                    R.id.reportsItem -> {
                        fragmentManager.apply {
                            beginTransaction().apply {
                                replace(
                                    fragmentContainerView.id,
                                    ReportsFragment()
                                ).commit()
                            }
                        }
                    }
                }
                true
            }
        }
    }

}