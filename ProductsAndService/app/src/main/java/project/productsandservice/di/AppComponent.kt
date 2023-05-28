package project.productsandservice.di

import dagger.Component
import project.productsandservice.data.api.MessageExchange
import project.productsandservice.domain.usecase.*
import project.productsandservice.ui.advert.AdvertImagesAdapter
import project.productsandservice.ui.chat.ChatAdapter
import project.productsandservice.ui.chats.AdapterChats
import project.productsandservice.ui.profile.AdapterMyAds

@Component(
    modules = [
        AppModule::class,
        DataModule::class,
        DomainModule::class
    ]
)
interface AppComponent {
    fun dateAndTimeUseCase(): GetDateTimeUseCase
    fun textCurrencyInSymbolUseCase(): GetTextCurrencyInSymbolUseCase
    //fun authUseCase(acli: AppClientInterface) = AuthUseCase(acli)
    fun adapterChats() = AdapterChats()
    fun adapterAdverts() = AdapterMyAds()
    fun chatAdapter() = ChatAdapter()
    fun advertImagesAdapter() = AdvertImagesAdapter()
    fun messageExchange() = MessageExchange()
}
