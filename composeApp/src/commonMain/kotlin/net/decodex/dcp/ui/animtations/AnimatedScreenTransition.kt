package net.decodex.dcp.ui.animtations

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun AnimatedScreenTransition(
    navController: NavHostController,
    targetScreen: String,
    content: @Composable () -> Unit,
) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val targetReached = remember { mutableStateOf(false) }
    val animatedOffset by animateDpAsState(
        targetValue = if (targetReached.value) 0.dp else 300.dp,
    )

    Box(
        modifier =
            Modifier
                .offset(x = animatedOffset)
                .fillMaxSize(),
    ) {
        content()
    }

    LaunchedEffect(currentBackStackEntry) {
        targetReached.value = currentBackStackEntry?.destination?.route == targetScreen
    }
}
