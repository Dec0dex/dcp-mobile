package net.decodex.dcp.di

import net.decodex.dcp.core.data.AppDatabase
import net.decodex.dcp.core.networking.AuthHttpClient
import net.decodex.dcp.core.networking.NoAuthHttpClient
import net.decodex.dcp.core.networking.createAuthHttpClient
import net.decodex.dcp.core.networking.createHttpClient
import net.decodex.dcp.core.networking.createSuperTokensClient
import net.decodex.dcp.core.supertokens.SuperTokensClient
import net.decodex.dcp.features.login.presentation.LoginViewModel
import net.decodex.dcp.user.domain.dao.UserDao
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelsModule =
    module {
        viewModelOf(::LoginViewModel)
    }

val daoModule =
    module {
        single<UserDao> { get<AppDatabase>().getUserDao() }
    }

val dataSourceModule = module {}

val repositoryModule = module {}

val networkModule =
    module {
        single<NoAuthHttpClient> { createHttpClient(get()) }
        single<SuperTokensClient> { createSuperTokensClient(get(), get()) }
        single<AuthHttpClient> { createAuthHttpClient(get()) }
    }

expect val platformModule: Module
