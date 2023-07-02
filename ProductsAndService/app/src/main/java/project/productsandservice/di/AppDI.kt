package project.productsandservice.di

import org.koin.core.qualifier.named
import project.productsandservice.ui.profile.*
import project.productsandservice.ui.advert.*
import project.productsandservice.ui.chats.*
import project.productsandservice.ui.chat.*
import org.koin.dsl.module

val appModule = module {
    single(
        named("advertImagesAdapter")
    ) {
        AdvertImagesAdapter()
    }

    single(
        named("chatAdapter")
    ) {
        ChatAdapter()
    }

    single(
        named("adapterMyAds")
    ) {
        AdapterMyAds()
    }

    single(
        named("adapterChats")
    ) {
        AdapterChats()
    }
}