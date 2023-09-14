package ru.project.workaccounting.ui.reports

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import ru.project.workaccounting.R
import ru.project.workaccounting.databinding.FragmentReportsBinding
import ru.project.workaccounting.ui.export.ExportData

class ReportsFragment : Fragment() {
    private lateinit var myTabLayout: MyTabLayout


    private lateinit var viewModel: ReportsViewModel
    private lateinit var binding: FragmentReportsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReportsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ReportsViewModel::class.java]

        binding.toolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.export -> {
                    ExportData().show(fragmentManager!!, "exportData")
                }

            }
            true
        }
        myTabLayout = MyTabLayout(parentFragmentManager, viewLifecycleOwner.lifecycle)
        myTabLayout.tabLayoutAds(
            viewPager = binding.viewPager,
            tabLayout = binding.tabLayout
        )
    }

}
