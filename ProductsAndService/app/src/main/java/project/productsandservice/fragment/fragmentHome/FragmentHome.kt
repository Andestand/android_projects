package project.productsandservice.fragment.fragmentHome

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import project.productsandservice.R
import project.productsandservice.databinding.FragmentHomeBinding

class FragmentHome : Fragment() {

    companion object {
        fun newInstance() = FragmentHome()
    }

    private lateinit var viewModel: FragmentHomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[FragmentHomeViewModel::class.java]
    }

}