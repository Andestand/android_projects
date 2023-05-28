package project.productsandservice.di

import dagger.*
import project.productsandservice.data.interfaces.AuthDataBaseInterface
import project.productsandservice.domain.usecase.*


@Module
class DomainModule {
    @Provides
    fun provideDataAndTimeUseCase() = GetDateTimeUseCase()

    @Provides
    fun providerTextCurrencyInSymbolUseCase() = GetTextCurrencyInSymbolUseCase()

    @Provides
    fun provideAuthUseCase(adbi: AuthDataBaseInterface) = AuthUseCase(adbi)

    @Provides
    fun provideRegisterUseCase(adbi: AuthDataBaseInterface) = RegisterUseCase(adbi)

}
