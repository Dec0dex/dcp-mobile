package net.decodex.dcp.features.forgotpassword.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dcp_mobile.composeapp.generated.resources.Res
import dcp_mobile.composeapp.generated.resources.cancel
import dcp_mobile.composeapp.generated.resources.forgot_password_title
import dcp_mobile.composeapp.generated.resources.password_reset_sent
import dcp_mobile.composeapp.generated.resources.request_password_reset
import net.decodex.dcp.ui.components.EmailField
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordScreen(
    navController: NavHostController,
    state: ForgotPasswordState,
    onEvent: (ForgotPasswordEvent) -> Unit,
) {
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
                title = { Text(stringResource(Res.string.forgot_password_title)) },
            )
        },
    ) {
        ForgotPasswordContent(state, onEvent)
    }
}

@Composable
fun ForgotPasswordContent(
    state: ForgotPasswordState,
    onEvent: (ForgotPasswordEvent) -> Unit,
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

        if (state.emailSent) {
            SuccessTooltip()
        }

        EmailField(
            value = state.email,
            onChange = { onEvent(ForgotPasswordEvent.OnEmailChange(it)) },
            modifier = Modifier.fillMaxWidth(),
            error = state.emailError,
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { onEvent(ForgotPasswordEvent.SendEmail) },
            enabled = state.isInputValid,
            shape = RoundedCornerShape(32.dp),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = stringResource(Res.string.request_password_reset),
                modifier = Modifier.padding(vertical = 4.dp),
                style = MaterialTheme.typography.bodyLarge,
            )
        }

        Button(
            onClick = { onEvent(ForgotPasswordEvent.GoBack) },
            shape = RoundedCornerShape(32.dp),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = stringResource(Res.string.cancel),
                modifier = Modifier.padding(vertical = 4.dp),
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}

@Composable
private fun ErrorTooltip(state: ForgotPasswordState) {
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

@Composable
private fun SuccessTooltip() {
    Card(
        colors =
            CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
            ),
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Filled.Info,
                contentDescription = "Info",
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = stringResource(Res.string.password_reset_sent))
        }
    }

    Spacer(modifier = Modifier.size(16.dp))
}
