package project.productsandservice.data.interfaces


import android.content.Context
import project.productsandservice.domain.models.Message


interface MessageExchangeDataBase {

    fun isConnected(context: Context): Boolean

    fun getMessage(): Message

    fun setMessage(message: Message): Boolean
}
