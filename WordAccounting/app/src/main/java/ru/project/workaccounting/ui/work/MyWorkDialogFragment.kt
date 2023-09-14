package ru.project.workaccounting.ui.work

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import ru.project.workaccounting.databinding.WorkFragmentBinding
import ru.project.workaccounting.domain.models.Work

class MyWorkDialogFragment(private val work: Work): DialogFragment() {
    private lateinit var binding: WorkFragmentBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = WorkFragmentBinding.inflate(layoutInflater)
        return AlertDialog.Builder(context!!).create().apply {
            setView(binding.root)
            binding.apply {
                workName.text = work.workName
                sizeWork.text = work.sizeWork.toString()
                window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
        }
    }
}