package project.productsandservice.di


import org.koin.core.qualifier.named
import org.koin.dsl.module
import project.productsandservice.domain.usecase.*


val domainModule = module {
    single(
        named("authUseCase")
    ) {
        AuthUseCase(aci = get())
    }

    single(
        named("registerUseCase")
    ) {
        RegisterUseCase(aci = get())
    }

    single(
        named("getTextCurrencyInSymbolUseCase")
    ) {
        GetTextCurrencyInSymbolUseCase()
    }

    single(
        named("getDateTimeUseCase")
    ) {
        GetDateTimeUseCase()
    }
}
