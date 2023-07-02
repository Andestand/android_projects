package project.productsandservice.di


import org.koin.core.qualifier.named
import project.productsandservice.data.interfaces.*
import project.productsandservice.data.api.*
import org.koin.dsl.module


val dataModule = module {
    single<MessageExchangeDataBase>(
        named("messageExchange")
    ) {
        MessageExchange()
    }

    single<AuthDataBaseInterface>(
        named("authDataBaseImplement")
    ) {
        AuthDataBaseImplement()
    }

}