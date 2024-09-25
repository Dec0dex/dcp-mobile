package net.decodex.dcp.di

import io.ktor.client.HttpClient
import net.decodex.dcp.core.data.AppDatabase
import net.decodex.dcp.core.launchdarkly.createLDClient
import net.decodex.dcp.core.networking.createAuthHttpClient
import net.decodex.dcp.core.networking.createHttpClient
import net.decodex.dcp.core.networking.createSuperTokensClient
import net.decodex.dcp.features.auth.presentation.AuthViewModel
import net.decodex.dcp.features.emailotp.presnetation.OtpViewModel
import net.decodex.dcp.features.forgotpassword.presentation.ForgotPasswordViewModel
import net.decodex.dcp.features.login.presentation.LoginViewModel
import net.decodex.dcp.features.mfa.presentation.MfaViewModel
import net.decodex.dcp.features.register.presentation.RegisterViewModel
import net.decodex.dcp.features.totp.presentation.TotpViewModel
import net.decodex.dcp.features.user.domain.dao.UserDao
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelsModule =
    module {
        viewModelOf(::LoginViewModel)
        viewModelOf(::AuthViewModel)
        viewModelOf(::MfaViewModel)
        viewModelOf(::OtpViewModel)
        viewModelOf(::RegisterViewModel)
        viewModelOf(::ForgotPasswordViewModel)
        viewModelOf(::TotpViewModel)
    }

val daoModule =
    module {
        single<UserDao> { get<AppDatabase>().getUserDao() }
    }

val dataSourceModule = module {}

val repositoryModule = module {}

val libsModule =
    module {
        singleOf(::createLDClient)
    }

val networkModule =
    module {
        single<HttpClient>(named("NoAuth")) { createHttpClient(get()) }
        singleOf(::createSuperTokensClient)
        singleOf(::createAuthHttpClient)
    }

expect val platformModule: Module
