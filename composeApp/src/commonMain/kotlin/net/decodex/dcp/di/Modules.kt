package net.decodex.dcp.di

import net.decodex.dcp.core.data.AppDatabase
import net.decodex.dcp.core.networking.AuthHttpClient
import net.decodex.dcp.core.networking.NoAuthHttpClient
import net.decodex.dcp.core.networking.createAuthHttpClient
import net.decodex.dcp.core.networking.createHttpClient
import net.decodex.dcp.user.domain.dao.UserDao
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelsModule =
    module {
    }

val daoModule =
    module {
        single<UserDao> { get<AppDatabase>().getUserDao() }
    }

val dataSourceModule =
    module {
    }

val repositoryModule =
    module {
    }

val networkModule =
    module {
        single<NoAuthHttpClient> { createHttpClient(get()) }
        single<AuthHttpClient> { createAuthHttpClient(get(), get()) }
    }

expect val platformModule: Module
