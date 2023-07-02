package project.productsandservice.ui.chats

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import project.productsandservice.data.arrays.MessageUsersArray
import project.productsandservice.databinding.FragmentChatsBinding
import javax.inject.Inject

class FragmentChatsViewModel: ViewModel() {
    private val adapterChats = AdapterChats()

    //val adapterChats_: AdapterChats() by inject()

    fun initRV(
        context: Context,
        binding: FragmentChatsBinding
    ) {

        binding.recyclerViewChats.apply {
            adapter = adapterChats
            layoutManager = GridLayoutManager(context, 1)
        }

        for (d in MessageUsersArray.array) {
            adapterChats.addMU(d)
        }
    }
}