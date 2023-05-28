package project.productsandservice.di


import project.productsandservice.data.interfaces.AuthDataBaseInterface
import project.productsandservice.data.api.*
import dagger.*

@Module
class DataModule {
    @Provides
    fun provideAppClientImplement(stdbi: AuthDataBaseInterface) = AuthDataBaseImplement()

    @Provides
    fun provideAuthDataBaseImplement() = AuthDataBaseImplement()

    @Provides
    fun provideMessageExchange() = MessageExchange()

}
