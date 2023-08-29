package ru.project.workaccounting.ui.map

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import ru.project.workaccounting.databinding.FragmentMapBinding

class MapFragment : Fragment() {
    companion object {
        fun newInstance() = MapFragment()
    }

    private lateinit var binding: FragmentMapBinding
    private lateinit var viewModel: MapViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMapBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MapViewModel::class.java]

        viewModel.mapView(
            context = view.context,
            map = binding.map,
            fragmentManager = fragmentManager!!
        )
        /*viewModel.getGeoData(
            map = binding.map,
            activity = this.activity?.parent!!,
            context = context!!,
            button = binding.getGeoData
        )*/
    }

}