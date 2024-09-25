package net.decodex.dcp.features.totp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import dcp_mobile.composeapp.generated.resources.Res
import dcp_mobile.composeapp.generated.resources.code
import dcp_mobile.composeapp.generated.resources.create_device
import dcp_mobile.composeapp.generated.resources.device_name
import dcp_mobile.composeapp.generated.resources.qr_code_referring_to
import dcp_mobile.composeapp.generated.resources.totp_error
import dcp_mobile.composeapp.generated.resources.totp_title
import dcp_mobile.composeapp.generated.resources.verify
import io.github.alexzhirkevich.qrose.rememberQrCodePainter
import net.decodex.dcp.BuildKonfig
import net.decodex.dcp.ui.components.ErrorDialog
import net.decodex.dcp.ui.components.LoadingOverlay
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TotpScreen(
    state: TotpState,
    onEvent: (TotpEvent) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(Res.string.totp_title)) },
                colors =
                    TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    ),
                navigationIcon = {
                    IconButton(onClick = { onEvent(TotpEvent.GoBack) }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
            )
        },
    ) {
        Column(
            modifier =
                Modifier.padding(it)
                    .then(Modifier.padding(horizontal = 16.dp, vertical = 24.dp))
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement =
                Arrangement.spacedBy(
                    16.dp,
                    alignment = Alignment.CenterVertically,
                ),
        ) {
            when (state) {
                is TotpState.AddDevice -> AddDeviceView(state, onEvent)
                is TotpState.VerifyDevice -> VerifyDeviceView(state, onEvent)
                is TotpState.EnterTotp -> VerifyView(state, onEvent)
                else -> {}
            }
        }
    }

    LoadingOverlay(isLoading = state is TotpState.Loading)
    if (state is TotpState.Error && state.isDialogVisible) {
        ErrorDialog(
            title = stringResource(Res.string.totp_error),
            errorMessage = state.errorMessage,
            onDismiss = { onEvent(TotpEvent.OnDismissErrorDialog) },
        )
    }
}

@Composable
private fun AddDeviceView(
    state: TotpState.AddDevice,
    onEvent: (TotpEvent) -> Unit,
) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = stringResource(Res.string.device_name)) },
        value = state.deviceName,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions =
            KeyboardActions(
                onDone = {
                    if (state.deviceName.isNotEmpty()) {
                        onEvent(TotpEvent.CreateDevice(state.deviceName))
                    }
                },
            ),
        onValueChange = { onEvent(TotpEvent.OnDeviceNameChange(it)) },
    )

    Spacer(modifier = Modifier.height(8.dp))

    Button(
        modifier = Modifier.fillMaxWidth(),
        enabled = state.deviceName.isNotEmpty(),
        onClick = { onEvent(TotpEvent.CreateDevice(state.deviceName)) },
    ) {
        Text(
            text = stringResource(Res.string.create_device),
            modifier = Modifier.padding(vertical = 8.dp),
        )
    }
}

@Composable
private fun VerifyDeviceView(
    state: TotpState.VerifyDevice,
    onEvent: (TotpEvent) -> Unit,
) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = stringResource(Res.string.code)) },
        value = state.totp,
        onValueChange = { onEvent(TotpEvent.OnTotpChange(it)) },
        keyboardOptions =
            KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done,
            ),
    )

    Text(state.deviceName)

    Image(
        modifier = Modifier.size(200.dp),
        painter = rememberQrCodePainter(state.qrCodeValue),
        contentDescription =
            stringResource(
                Res.string.qr_code_referring_to,
                BuildKonfig.WEBSITE_URL,
            ),
    )

    Text(state.secret, style = MaterialTheme.typography.bodyLarge)

    Spacer(modifier = Modifier.height(8.dp))

    Button(
        modifier = Modifier.fillMaxWidth(),
        enabled = state.totp.isNotEmpty(),
        onClick = { onEvent(TotpEvent.Verify(totp = state.totp)) },
    ) {
        Text(text = stringResource(Res.string.verify), modifier = Modifier.padding(vertical = 8.dp))
    }
}

@Composable
private fun VerifyView(
    state: TotpState.EnterTotp,
    onEvent: (TotpEvent) -> Unit,
) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = stringResource(Res.string.code)) },
        value = state.totp,
        onValueChange = { onEvent(TotpEvent.OnTotpChange(it)) },
        keyboardOptions =
            KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done,
            ),
        keyboardActions =
            KeyboardActions(
                onDone = {
                    if (state.totp.isNotEmpty()) {
                        onEvent(TotpEvent.Verify(state.totp))
                    }
                },
            ),
    )

    Spacer(modifier = Modifier.height(8.dp))
    Button(
        enabled = state.totp.isNotEmpty(),
        modifier = Modifier.fillMaxWidth(),
        onClick = { onEvent(TotpEvent.Verify(totp = state.totp)) },
    ) {
        Text(stringResource(Res.string.verify), modifier = Modifier.padding(vertical = 8.dp))
    }
}
