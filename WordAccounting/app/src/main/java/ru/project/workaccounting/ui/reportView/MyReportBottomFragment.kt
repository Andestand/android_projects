package ru.project.workaccounting.ui.reportView

import android.os.Bundle
import android.view.*
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.project.workaccounting.databinding.ReportViewBinding

class MyReportBottomFragment: BottomSheetDialogFragment() {
    private lateinit var binding: ReportViewBinding

    override fun getTheme(): Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ReportViewBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}