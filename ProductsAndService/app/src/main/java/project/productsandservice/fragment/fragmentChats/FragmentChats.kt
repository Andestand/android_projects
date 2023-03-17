package project.productsandservice.fragment.fragmentChats

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import project.productsandservice.R
import project.productsandservice.databinding.FragmentChatsBinding

class FragmentChats : Fragment() {

    companion object {
        fun newInstance() = FragmentChats()
    }

    private lateinit var viewModel: FragmentChatsViewModel
    private lateinit var binding: FragmentChatsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[FragmentChatsViewModel::class.java]
        viewModel.initRV(
            view.context,
            binding
        )
    }
}