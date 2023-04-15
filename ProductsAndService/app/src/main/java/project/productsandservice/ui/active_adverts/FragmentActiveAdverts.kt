package project.productsandservice.ui.active_adverts

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import project.productsandservice.databinding.FragmentActiveAdvertsBinding

class FragmentActiveAdverts : Fragment() {

    companion object {
        fun newInstance() = FragmentActiveAdverts()
    }

    private lateinit var viewModel: FragmentActiveAdvertsViewModel
    private lateinit var binding: FragmentActiveAdvertsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentActiveAdvertsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[FragmentActiveAdvertsViewModel::class.java]
    }

}