package project.productsandservice.fragment.fragmentChats

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import project.productsandservice.adapters.AdapterChats
import project.productsandservice.databinding.FragmentChatsBinding
import project.productsandservice.models.MessageUser

class FragmentChatsViewModel : ViewModel() {
    private val adapter = AdapterChats()

    fun initRV(
        context: Context,
        binding: FragmentChatsBinding
    ) {
        binding.recyclerViewChats.layoutManager = GridLayoutManager(context, 1)
        binding.recyclerViewChats.adapter = adapter

        val link = "https://sun9-54.userapi.com/impg/VcaLLa-2KcFuZa8" +
                "TBkMYH3d3RNhW5kpZ7axD-w/0Qz4QLmWabs.jpg?size=855x956&quality=96&sign=5fcffeac556a" +
                "0830d3f9326ca7ee9936&type=album"

        adapter.addMU(
            MessageUser(
                "София Фильвенова",
                link,
                "приветик!!!",
                "13.08.2022"
            )
        )
    }
}