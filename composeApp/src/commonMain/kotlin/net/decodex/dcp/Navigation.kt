package net.decodex.dcp

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import net.decodex.dcp.core.constants.NavRoutes
import net.decodex.dcp.core.supertokens.SuperTokensClient
import net.decodex.dcp.core.supertokens.recipes.session.repository.AuthState
import net.decodex.dcp.features.login.presentation.LoginScreen
import net.decodex.dcp.features.login.presentation.LoginViewModel
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
            LoginScreen(state, viewModel::onEvent)
        }
    }
}

@Composable
private fun getInitialRoute(): String {
    // TODO: Launchdarkly integration
    // TODO: Amplitude integration
    // TODO: Instabug Integration
    val client = koinInject<SuperTokensClient>()
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
}
