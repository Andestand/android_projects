package project.productsandservice.ui.chat

import project.productsandservice.databinding.ActivityChatBinding
import project.productsandservice.data.arrays.MessagesArray
import project.productsandservice.domain.models.Message
import androidx.recyclerview.widget.GridLayoutManager
import project.productsandservice.di.AppComponent
import androidx.lifecycle.ViewModel
import android.content.Context
import project.productsandservice.data.api.MessageExchange
import project.productsandservice.domain.usecase.GetDateTimeUseCase
import project.productsandservice.domain.usecase.GetTextCurrencyInSymbolUseCase
import javax.inject.Inject

class ChatViewModel@Inject constructor(): ViewModel() {
    private val getDateTimeUseCase = GetDateTimeUseCase()
    private val adapterChat = ChatAdapter()
    private val messageExchange = MessageExchange()

    fun initRV(
        context: Context,
        binding: ActivityChatBinding
    ) {

        binding.rvChar.apply {
            adapter = adapterChat
            layoutManager = GridLayoutManager(context, 1)
        }

        for (i in MessagesArray.array) {
            adapterChat.addMessage(
                message = i
            )
        }
    }

    fun setDataChat(

    ) {

    }

    @Inject
    fun getMessage() {
        adapterChat.addMessage(
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
            adapterChat.addMessage(
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
