package net.decodex.dcp.features.mfa.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dcp_mobile.composeapp.generated.resources.Res
import dcp_mobile.composeapp.generated.resources.email_otp
import dcp_mobile.composeapp.generated.resources.mfa_title
import dcp_mobile.composeapp.generated.resources.phone_otp
import dcp_mobile.composeapp.generated.resources.totp
import dev.materii.pullrefresh.PullRefreshIndicator
import dev.materii.pullrefresh.PullRefreshLayout
import dev.materii.pullrefresh.rememberPullRefreshState
import net.decodex.dcp.core.supertokens.models.AuthFactor
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MfaScreen(
    navController: NavHostController,
    state: MfaState,
    onEvent: (MfaEvent) -> Unit,
) {
    val isRefreshing by remember { mutableStateOf(state.isLoading) }
    val pullRefreshState =
        rememberPullRefreshState(
            refreshing = isRefreshing,
            onRefresh = { onEvent(MfaEvent.RefreshStatus) },
        )
    Scaffold(
        topBar = {
            TopAppBar(
                colors =
                    TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    ),
                navigationIcon = {
                    if (navController.previousBackStackEntry != null) {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                            )
                        }
                    }
                },
                title = { Text(stringResource(Res.string.mfa_title)) },
                actions = {
                    IconButton(onClick = { onEvent(MfaEvent.RefreshStatus) }) {
                        Icon(Icons.Default.Refresh, contentDescription = "Refresh")
                    }
                },
            )
        },
    ) {
        PullRefreshLayout(
            modifier = Modifier.fillMaxSize(),
            state = pullRefreshState,
            indicator = {
                PullRefreshIndicator(
                    state = pullRefreshState,
                    backgroundColor = MaterialTheme.colorScheme.surfaceColorAtElevation(4.dp),
                    contentColor = MaterialTheme.colorScheme.primary,
                )
            },
        ) {
            MfaContent(state, onEvent)
        }
    }
}

@Composable
fun MfaContent(
    state: MfaState,
    onEvent: (MfaEvent) -> Unit,
) {
    Column(
        modifier =
            Modifier.padding(vertical = 24.dp, horizontal = 16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.CenterVertically),
    ) {
        if (state.isErrorVisible && !state.isLoading) {
            ErrorTooltip(state)
        }
        Button(
            enabled = state.mfaStatus?.factors?.next?.contains(AuthFactor.TOTP.key) == true,
            onClick = { onEvent(MfaEvent.GotoTotp) },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(stringResource(Res.string.totp), modifier = Modifier.padding(vertical = 8.dp))
        }
        Button(
            enabled = state.mfaStatus?.factors?.next?.any { it == AuthFactor.OtpEmail.key } == true,
            onClick = { onEvent(MfaEvent.GotoEmailOtp) },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(stringResource(Res.string.email_otp), modifier = Modifier.padding(vertical = 8.dp))
        }

        Button(
            enabled = state.mfaStatus?.factors?.next?.any { it == AuthFactor.OtpPhone.key } == true,
            onClick = { onEvent(MfaEvent.GotoPhoneOtp) },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(stringResource(Res.string.phone_otp), modifier = Modifier.padding(vertical = 8.dp))
        }

        TextButton(onClick = { onEvent(MfaEvent.Cancel) }) { Text("Cancel") }
    }
}

@Composable
private fun ErrorTooltip(state: MfaState) {
    Card(
        colors =
            CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.errorContainer,
                contentColor = MaterialTheme.colorScheme.onErrorContainer,
            ),
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Filled.Error,
                contentDescription = "Error",
            )
            state.errorMessage?.let {
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = it)
            }
        }
    }

    Spacer(modifier = Modifier.size(16.dp))
}
