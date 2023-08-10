package ru.project.monumentsOfBrazil.ui.settings

import android.app.*
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.DialogFragment
import ru.project.monumentsOfBrazil.R
import ru.project.monumentsOfBrazil.databinding.DialogSettingsBinding

class MySettingsDialogFragment: DialogFragment() {
    private lateinit var binding: DialogSettingsBinding


    override fun getTheme(): Int = R.style.MyStyleSettingsDialogFragment

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogSettingsBinding.inflate(layoutInflater)
        isThemeSwitch(binding.isTheme)
        dialog?.context?.setTheme(R.style.MyStyleSettingsDialogFragment)
        binding.isTheme.isChecked = isDarkTheme()
        binding.exitSettings.setOnClickListener {
            onStop()
        }
        return AlertDialog.Builder(activity).create().apply {
            setView(binding.root)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        }
    }

    private fun isThemeSwitch(
        switch: SwitchCompat
    ) = switch.setOnCheckedChangeListener { isTheme, _ ->
        when(isTheme.isChecked) {
            true -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }

            false -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }


    private fun isDarkTheme(): Boolean {
        val mode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return mode == Configuration.UI_MODE_NIGHT_YES
    }
}