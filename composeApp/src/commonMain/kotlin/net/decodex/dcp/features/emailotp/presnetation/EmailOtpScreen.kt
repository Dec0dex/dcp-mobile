package net.decodex.dcp.features.emailotp.presnetation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dcp_mobile.composeapp.generated.resources.Res
import dcp_mobile.composeapp.generated.resources.confirm
import dcp_mobile.composeapp.generated.resources.confirm_login_with
import dcp_mobile.composeapp.generated.resources.did_not_receive_code
import dcp_mobile.composeapp.generated.resources.otp_code
import dcp_mobile.composeapp.generated.resources.otp_error
import dcp_mobile.composeapp.generated.resources.otp_verification
import dcp_mobile.composeapp.generated.resources.resend_code
import dcp_mobile.composeapp.generated.resources.send_code
import net.decodex.dcp.core.supertokens.models.AuthFactor
import net.decodex.dcp.ui.components.ErrorDialog
import net.decodex.dcp.ui.components.LoadingOverlay
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpScreen(
    navController: NavController,
    state: OtpState,
    onEvent: (OtpEvent) -> Unit,
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
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                },
                title = { Text(stringResource(Res.string.otp_verification)) },
            )
        },
    ) {
        OtpContent(modifier = Modifier.padding(it), state, onEvent)
    }
    LoadingOverlay(isLoading = state.isLoading)
    if (state.isErrorVisible) {
        ErrorDialog(
            title = stringResource(Res.string.otp_error),
            errorMessage = state.errorMessage,
            onDismiss = { onEvent(OtpEvent.DismissErrorDialog) },
        )
    }
}

@Composable
fun OtpContent(
    modifier: Modifier,
    state: OtpState,
    onEvent: (OtpEvent) -> Unit,
) {
    Column(
        modifier =
            modifier.then(Modifier.padding(horizontal = 16.dp, vertical = 24.dp))
                .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.align(alignment = Alignment.Start),
            text =
                stringResource(
                    Res.string.confirm_login_with,
                    if (state.authFactor == AuthFactor.OtpPhone) state.phoneNumber.orEmpty() else state.email.orEmpty(),
                ),
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.size(24.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1,
            enabled = state.otpSent,
            label = { Text(text = stringResource(Res.string.otp_code)) },
            placeholder = { Text(text = "123456") },
            value = state.inputCode.orEmpty(),
            onValueChange = { onEvent(OtpEvent.OnCodeInput(it)) },
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done,
                ),
            keyboardActions =
                KeyboardActions(
                    onDone = {
                        if (!state.inputCode.isNullOrEmpty() && state.otpSent) {
                            onEvent(OtpEvent.ConfirmCode)
                        }
                    },
                ),
        )
        Spacer(modifier = Modifier.size(24.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            enabled = state.otpSent && !state.inputCode.isNullOrEmpty(),
            onClick = { onEvent(OtpEvent.ConfirmCode) },
        ) {
            Text(
                text = stringResource(Res.string.confirm),
                modifier = Modifier.padding(vertical = 8.dp),
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Row {
            Text(
                text = stringResource(Res.string.did_not_receive_code),
                modifier = Modifier.alignByBaseline(),
            )
            TextButton(
                onClick = { onEvent(OtpEvent.SendOtp) },
                modifier = Modifier.alignByBaseline(),
            ) {
                Text(
                    text = stringResource(if (state.otpSent) Res.string.resend_code else Res.string.send_code),
                )
            }
        }
    }
}
