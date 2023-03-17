package project.productsandservice.fragment.fragmentNotification

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import project.productsandservice.R
import project.productsandservice.databinding.FragmentNotificationBinding

class FragmentNotification : Fragment() {

    companion object {
        fun newInstance() = FragmentNotification()
    }

    private lateinit var viewModel: FragmentNotificationViewModel
    private lateinit var binding: FragmentNotificationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotificationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[FragmentNotificationViewModel::class.java]
    }

}