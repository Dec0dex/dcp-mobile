package net.decodex.dcp.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            platformModule,
            libsModule,
            networkModule,
            viewModelsModule,
            daoModule,
            viewModelsModule,
            dataSourceModule,
            repositoryModule,
        )
    }
}
