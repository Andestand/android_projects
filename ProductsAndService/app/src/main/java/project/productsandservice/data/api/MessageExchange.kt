package project.productsandservice.data.api

import android.content.Context
import android.net.ConnectivityManager
import project.productsandservice.data.interfaces.MessageExchangeDataBase
import project.productsandservice.domain.models.Message

class MessageExchange: MessageExchangeDataBase {

    override fun isConnected(context: Context): Boolean {
        return hasConnected(context)
    }

    override fun getMessage(): Message {
        TODO("Not yet implemented")
    }

    override fun setMessage(message: Message): Boolean {
        TODO("Not yet implemented")
    }

    private fun hasConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        val mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)

        return if (wifi != null && wifi.isConnected) {
            true
        } else mobile != null && mobile.isConnected
    }
}
