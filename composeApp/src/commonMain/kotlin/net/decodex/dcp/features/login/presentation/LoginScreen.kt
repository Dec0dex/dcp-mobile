package net.decodex.dcp.features.login.presentation

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dcp_mobile.composeapp.generated.resources.Res
import dcp_mobile.composeapp.generated.resources.forgot_password
import dcp_mobile.composeapp.generated.resources.login_button_text
import dcp_mobile.composeapp.generated.resources.login_error
import dcp_mobile.composeapp.generated.resources.login_title
import dcp_mobile.composeapp.generated.resources.new_here
import dcp_mobile.composeapp.generated.resources.sign_up
import net.decodex.dcp.ui.components.AppleLoginButton
import net.decodex.dcp.ui.components.BitbucketLoginButton
import net.decodex.dcp.ui.components.EmailField
import net.decodex.dcp.ui.components.ErrorDialog
import net.decodex.dcp.ui.components.FacebookLoginButton
import net.decodex.dcp.ui.components.GitHubLoginButton
import net.decodex.dcp.ui.components.GitLabLoginButton
import net.decodex.dcp.ui.components.GoogleLoginButton
import net.decodex.dcp.ui.components.LoadingOverlay
import net.decodex.dcp.ui.components.ORComponent
import net.decodex.dcp.ui.components.PasswordField
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoginScreen(
    state: LoginState,
    onEvent: (LoginEvent) -> Unit,
) {
    Scaffold {
        LoginForm(state, onEvent)
    }
}

@Composable
fun LoginForm(
    state: LoginState,
    onEvent: (LoginEvent) -> Unit,
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
            text = stringResource(Res.string.login_title),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(24.dp))
        EmailField(
            value = state.email,
            onChange = { onEvent(LoginEvent.OnEmailChanged(it)) },
            modifier = Modifier.fillMaxWidth(),
            error = state.emailError,
        )
        Spacer(modifier = Modifier.height(8.dp))
        PasswordField(
            value = state.password,
            onChange = { onEvent(LoginEvent.OnPasswordChanged(it)) },
            submit = { onEvent(LoginEvent.OnLoginClick) },
            error = state.passwordError,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextButton(
            onClick = { onEvent(LoginEvent.OnForgotPasswordClicked) },
            modifier = Modifier.align(Alignment.Start),
        ) {
            Text(text = stringResource(Res.string.forgot_password))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onEvent(LoginEvent.OnLoginClick) },
            enabled = state.isInputValid,
            shape = RoundedCornerShape(32.dp),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = stringResource(Res.string.login_button_text),
                modifier = Modifier.padding(vertical = 4.dp),
                style = MaterialTheme.typography.bodyLarge,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text(text = stringResource(Res.string.new_here), modifier = Modifier.alignByBaseline())
            TextButton(
                onClick = { onEvent(LoginEvent.OnRegisterClicked) },
                modifier = Modifier.alignByBaseline(),
            ) {
                Text(text = stringResource(Res.string.sign_up))
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        ORComponent()
        Spacer(modifier = Modifier.height(24.dp))
        GoogleLoginButton(onClick = {})
        Spacer(modifier = Modifier.height(8.dp))
        FacebookLoginButton(onClick = {})
        Spacer(modifier = Modifier.height(8.dp))
        GitHubLoginButton(onClick = {})
        Spacer(modifier = Modifier.height(8.dp))
        GitLabLoginButton(onClick = {})
        Spacer(modifier = Modifier.height(8.dp))
        BitbucketLoginButton(onClick = {})
        Spacer(modifier = Modifier.height(8.dp))
        AppleLoginButton(onClick = {})
    }

    LoadingOverlay(isLoading = state.isLoading)
    if (state.isErrorVisible) {
        ErrorDialog(
            title = stringResource(Res.string.login_error),
            errorMessage = state.apiError?.message,
            onDismiss = { onEvent(LoginEvent.DismissErrorDialog) },
        )
    }
}
