package ru.project.testadapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.project.testadapter.databinding.FragmentTemplateBinding

class TemplateFragment(private val text: String): Fragment() {
    private lateinit var binding: FragmentTemplateBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTemplateBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setText(text = text)
    }

    fun setText(text: String) {
        binding.text.text = text
    }
}