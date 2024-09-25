package net.decodex.dcp.features.register.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dcp_mobile.composeapp.generated.resources.Res
import dcp_mobile.composeapp.generated.resources.already_have_account
import dcp_mobile.composeapp.generated.resources.log_in
import dcp_mobile.composeapp.generated.resources.register_button_text
import dcp_mobile.composeapp.generated.resources.register_error
import dcp_mobile.composeapp.generated.resources.register_title
import net.decodex.dcp.ui.components.AppleLoginButton
import net.decodex.dcp.ui.components.EmailField
import net.decodex.dcp.ui.components.ErrorDialog
import net.decodex.dcp.ui.components.FacebookLoginButton
import net.decodex.dcp.ui.components.GitHubLoginButton
import net.decodex.dcp.ui.components.GoogleLoginButton
import net.decodex.dcp.ui.components.LoadingOverlay
import net.decodex.dcp.ui.components.ORComponent
import net.decodex.dcp.ui.components.PasswordField
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    navController: NavController,
    state: RegisterState,
    onEvent: (RegisterEvent) -> Unit,
) {
    Scaffold {
        RegisterForm(state, onEvent)
    }
    LoadingOverlay(isLoading = state.isLoading)
    if (state.isErrorVisible) {
        ErrorDialog(
            title = stringResource(Res.string.register_error),
            errorMessage = state.errorMessage,
            onDismiss = { onEvent(RegisterEvent.DismissErrorDialog) },
        )
    }
}

@Composable
fun RegisterForm(
    state: RegisterState,
    onEvent: (RegisterEvent) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =
            Modifier.fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 24.dp)
                .verticalScroll(rememberScrollState()),
    ) {
        Text(
            text = stringResource(Res.string.register_title),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(24.dp))
        EmailField(
            value = state.email,
            onChange = { onEvent(RegisterEvent.OnEmailChanged(it)) },
            modifier = Modifier.fillMaxWidth(),
            error = state.emailError,
        )
        Spacer(modifier = Modifier.height(8.dp))
        PasswordField(
            value = state.password,
            onChange = { onEvent(RegisterEvent.OnPasswordChanged(it)) },
            submit = { onEvent(RegisterEvent.OnRegisterClick) },
            error = state.passwordError,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onEvent(RegisterEvent.OnRegisterClick) },
            enabled = state.isInputValid,
            shape = RoundedCornerShape(32.dp),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = stringResource(Res.string.register_button_text),
                modifier = Modifier.padding(vertical = 4.dp),
                style = MaterialTheme.typography.bodyLarge,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text(
                text = stringResource(Res.string.already_have_account),
                modifier = Modifier.alignByBaseline(),
            )
            TextButton(
                onClick = { onEvent(RegisterEvent.OnLoginClick) },
                modifier = Modifier.alignByBaseline(),
            ) {
                Text(text = stringResource(Res.string.log_in))
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        ORComponent()
        Spacer(modifier = Modifier.height(24.dp))
        GoogleLoginButton(onClick = { onEvent(RegisterEvent.SignUpWithGoogle) })
        Spacer(modifier = Modifier.height(8.dp))
        GitHubLoginButton(onClick = { onEvent(RegisterEvent.SignUpWithGitHub) })
        Spacer(modifier = Modifier.height(8.dp))
        FacebookLoginButton(onClick = { onEvent(RegisterEvent.SignUpWithFacebook) })
        Spacer(modifier = Modifier.height(8.dp))
        AppleLoginButton(onClick = { onEvent(RegisterEvent.SignUpWithApple) })
    }
}
