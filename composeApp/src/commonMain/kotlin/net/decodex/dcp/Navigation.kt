package net.decodex.dcp

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.myunidays.launchdarkly.LDClient
import net.decodex.dcp.core.constants.FeatureFlags
import net.decodex.dcp.core.constants.NavRoutes
import net.decodex.dcp.core.supertokens.SuperTokensClient
import net.decodex.dcp.core.supertokens.models.AuthFactor
import net.decodex.dcp.core.supertokens.recipes.session.repository.AuthState
import net.decodex.dcp.features.auth.presentation.AuthScreen
import net.decodex.dcp.features.auth.presentation.AuthViewModel
import net.decodex.dcp.features.emailotp.presnetation.OtpScreen
import net.decodex.dcp.features.emailotp.presnetation.OtpViewModel
import net.decodex.dcp.features.forgotpassword.presentation.ForgotPasswordScreen
import net.decodex.dcp.features.forgotpassword.presentation.ForgotPasswordViewModel
import net.decodex.dcp.features.login.presentation.LoginScreen
import net.decodex.dcp.features.login.presentation.LoginViewModel
import net.decodex.dcp.features.mfa.presentation.MfaScreen
import net.decodex.dcp.features.mfa.presentation.MfaViewModel
import net.decodex.dcp.features.register.presentation.RegisterScreen
import net.decodex.dcp.features.register.presentation.RegisterViewModel
import net.decodex.dcp.features.totp.presentation.TotpScreen
import net.decodex.dcp.features.totp.presentation.TotpViewModel
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Composable
fun AnimatedNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    val initialRoute = getInitialRoute()
    val isInitialRoute = currentRoute == initialRoute
    AnimatedContent(targetState = currentRoute, transitionSpec = {
        if (isInitialRoute) {
            // No animation for the initial route
            fadeIn(animationSpec = tween(0)) togetherWith fadeOut(animationSpec = tween(0))
        } else {
            // Apply animations for transitions after the initial route
            slideInHorizontally(
                initialOffsetX = { fullWidth -> fullWidth },
                animationSpec = tween(durationMillis = 300),
            ) togetherWith
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> -fullWidth },
                    animationSpec = tween(durationMillis = 300),
                )
        }
    }) {
        AppNavHost(navController, initialRoute, modifier)
    }
}

@Composable
@OptIn(KoinExperimentalAPI::class)
private fun AppNavHost(
    navController: NavHostController,
    initialRoute: String,
    modifier: Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = initialRoute,
        modifier = modifier,
    ) {
        composable(route = NavRoutes.LOGIN) {
            val viewModel = koinViewModel<LoginViewModel>()
            val state by viewModel.state.collectAsState()
            viewModel.navigator = navController
            LoginScreen(state, viewModel::onEvent)
        }

        composable(route = NavRoutes.FORGOT_PASSWORD) {
            val viewModel = koinViewModel<ForgotPasswordViewModel>()
            val state by viewModel.state.collectAsState()
            viewModel.navigator = navController
            ForgotPasswordScreen(navController, state, viewModel::onEvent)
        }

        composable(route = NavRoutes.REGISTER) {
            val viewModel = koinViewModel<RegisterViewModel>()
            val state by viewModel.state.collectAsState()
            viewModel.navigator = navController
            RegisterScreen(navController, state, viewModel::onEvent)
        }

        composable(route = NavRoutes.AUTH) {
            val viewModel = koinViewModel<AuthViewModel>()
            val state by viewModel.state.collectAsState()
            viewModel.navigator = navController
            viewModel.authorizeUser()
            AuthScreen(state)
        }

        composable(route = NavRoutes.MFA) {
            val viewModel = koinViewModel<MfaViewModel>()
            val state by viewModel.state.collectAsState()
            viewModel.navigator = navController
            MfaScreen(navController, state, viewModel::onEvent)
        }

        composable(route = NavRoutes.EMAIL_OTP) {
            val viewModel = koinViewModel<OtpViewModel>()
            val state by viewModel.state.collectAsState()
            viewModel.init(AuthFactor.OtpEmail, navController)
            OtpScreen(navController, state, viewModel::onEvent)
        }

        composable(route = NavRoutes.PHONE_OTP) {
            val viewModel = koinViewModel<OtpViewModel>()
            val state by viewModel.state.collectAsState()
            viewModel.init(AuthFactor.OtpPhone, navController)
            OtpScreen(navController, state, viewModel::onEvent)
        }

        composable(route = NavRoutes.TOTP) {
            val viewModel = koinViewModel<TotpViewModel>()
            val state by viewModel.state.collectAsState()
            viewModel.navigator = navController
            TotpScreen(state, viewModel::onEvent)
        }

        composable(route = NavRoutes.HOME) {
            Text("Home")
        }
    }
}

@Composable
private fun getInitialRoute(): String {
    // TODO: Amplitude integration
    // TODO: Instabug Integration
    val client = koinInject<SuperTokensClient>()
    val ldClient = koinInject<LDClient>()
    if (ldClient.boolVariation(FeatureFlags.SUPER_TOKENS, false)) {
        return client.run {
            when (val authState = authRepository.authState.value) {
                is AuthState.Authenticated -> {
                    if (authState.multiFactorVerified) {
                        NavRoutes.HOME
                    } else {
                        NavRoutes.MFA
                    }
                }

                is AuthState.LoggedIn -> NavRoutes.AUTH
                AuthState.Unauthenticated -> NavRoutes.LOGIN
            }
        }
    } else {
        return NavRoutes.HOME
    }
}
