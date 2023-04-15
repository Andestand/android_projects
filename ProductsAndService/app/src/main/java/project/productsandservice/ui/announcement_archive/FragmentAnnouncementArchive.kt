package project.productsandservice.ui.announcement_archive

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import project.productsandservice.R
import project.productsandservice.databinding.FragmentAnnouncementArchiveBinding

class FragmentAnnouncementArchive : Fragment() {

    companion object {
        fun newInstance() = FragmentAnnouncementArchive()
    }

    private lateinit var viewModel: FragmentAnnouncementArchiveViewModel
    private lateinit var binding: FragmentAnnouncementArchiveBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnnouncementArchiveBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[FragmentAnnouncementArchiveViewModel::class.java]
    }

}