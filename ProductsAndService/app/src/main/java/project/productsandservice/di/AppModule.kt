package project.productsandservice.di

import project.productsandservice.ui.profile.*
import project.productsandservice.ui.advert.*
import project.productsandservice.ui.chats.*
import project.productsandservice.ui.chat.*
import dagger.*

@Module
class AppModule {

    @Provides
    fun provideAdapterAdverts() = AdapterMyAds()

    @Provides
    fun provideAdapterChats() = AdapterChats()

    @Provides
    fun provideChatAdapter() = ChatAdapter()

    @Provides
    fun provideAdvertImagesAdapter() = AdvertImagesAdapter()
}
