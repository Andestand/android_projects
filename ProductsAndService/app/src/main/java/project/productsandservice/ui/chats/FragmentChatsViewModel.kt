package project.productsandservice.ui.chats

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import project.productsandservice.data.arrays.MessageUsersArray
import project.productsandservice.databinding.FragmentChatsBinding

class FragmentChatsViewModel : ViewModel() {
    private val adapter = AdapterChats()

    fun initRV(
        context: Context,
        binding: FragmentChatsBinding
    ) {
        binding.recyclerViewChats.layoutManager = GridLayoutManager(context, 1)
        binding.recyclerViewChats.adapter = adapter

        for (d in MessageUsersArray.array) {
            adapter.addMU(d)
        }
    }
}