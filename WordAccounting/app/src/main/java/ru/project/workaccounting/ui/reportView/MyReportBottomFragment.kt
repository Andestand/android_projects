package ru.project.workaccounting.ui.reportView

import android.os.Bundle
import android.view.*
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.project.workaccounting.databinding.ReportViewBinding
import ru.project.workaccounting.domain.models.Report

class MyReportBottomFragment(val report: Report): BottomSheetDialogFragment() {
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
        binding.worker.text = report.worker
        binding.address.text = report.address
        binding.datetime.text = report.datetime.toString()
        binding.workName.text = report.work.workName
        binding.sizeWork.text = report.work.sizeWork.toString()

    }
}