package project.productsandservice.ui.chat

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import project.productsandservice.data.api.MessageExchange
import project.productsandservice.data.arrays.MessagesArray
import project.productsandservice.databinding.ActivityChatBinding
import project.productsandservice.databinding.ItemMessageBinding
import project.productsandservice.domain.models.Message
import project.productsandservice.domain.usecase.GetDateTimeUseCase

class ChatViewModel: ViewModel() {
    private val adapter = ChatAdapter()
    private val messageExchange = MessageExchange()
    private val getDateTimeUseCase = GetDateTimeUseCase()

    fun initRV(
        context: Context,
        binding: ActivityChatBinding
    ) {
        binding.rvChar.layoutManager = GridLayoutManager(context, 1)
        binding.rvChar.adapter = adapter

        for (i in MessagesArray.array) {
            adapter.addMessage(
                message = i
            )
        }
    }

    fun setDataChat(

    ) {

    }

    fun getMessage() {
        adapter.addMessage(
            Message(
                message = messageExchange.getMessage().message,
                datetime = messageExchange.getMessage().datetime,
                type = 0
            )
        )
    }

    fun setMessage(
        binding: ActivityChatBinding
    ) {
        binding.sendMessage.setOnClickListener {
            messageExchange.setMessage(
                Message(
                    message = binding.message.text.toString(),
                    datetime = getDateTimeUseCase.execute(),
                    type = 1
                )
            )
            adapter.addMessage(
                Message(
                    message = binding.message.text.toString(),
                    datetime = getDateTimeUseCase.execute(),
                    type = 1
                )
            )
        }
    }
    fun isConnected(
        context: Context,
        binding: ActivityChatBinding
    ) {

        if (messageExchange.isConnected(context = context)) {
            binding.subtitle.text = "подключения к интернету есть"
        } else {
            binding.subtitle.text = "Нет подключения к интернету"
        }


    }
}
