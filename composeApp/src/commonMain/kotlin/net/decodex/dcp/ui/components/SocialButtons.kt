package net.decodex.dcp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import dcp_mobile.composeapp.generated.resources.Res
import dcp_mobile.composeapp.generated.resources.ic_apple_logo
import dcp_mobile.composeapp.generated.resources.ic_bitbucket_logo
import dcp_mobile.composeapp.generated.resources.ic_facebook_logo
import dcp_mobile.composeapp.generated.resources.ic_github_logo
import dcp_mobile.composeapp.generated.resources.ic_gitlab_logo
import dcp_mobile.composeapp.generated.resources.ic_google_logo
import dcp_mobile.composeapp.generated.resources.sign_in_with
import dcp_mobile.composeapp.generated.resources.sign_up_with
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun GoogleLoginButton(
    isSignup: Boolean = false,
    onClick: () -> Unit,
) {
    val buttonText =
        if (!isSignup) {
            stringResource(Res.string.sign_in_with, "Google")
        } else {
            stringResource(Res.string.sign_up_with, "Google")
        }
    SocialLoginButton(
        onClick = onClick,
        buttonText = stringResource(Res.string.sign_in_with, "Google"),
        backgroundColor = Color(0xFF4285F4),
        contentColor = Color.White,
        icon = painterResource(Res.drawable.ic_google_logo),
    )
}

@Composable
fun BitbucketLoginButton(
    isSignup: Boolean = false,
    onClick: () -> Unit,
) {
    val buttonText =
        if (!isSignup) {
            stringResource(Res.string.sign_in_with, "Bitbucket")
        } else {
            stringResource(Res.string.sign_up_with, "Bitbucket")
        }
    SocialLoginButton(
        onClick = onClick,
        buttonText = buttonText,
        backgroundColor = Color(0xFF205081),
        contentColor = Color.White,
        icon = painterResource(Res.drawable.ic_bitbucket_logo),
    )
}

@Composable
fun GitLabLoginButton(
    isSignup: Boolean = false,
    onClick: () -> Unit,
) {
    val buttonText =
        if (!isSignup) {
            stringResource(Res.string.sign_in_with, "GitLab")
        } else {
            stringResource(Res.string.sign_up_with, "GitLab")
        }
    SocialLoginButton(
        onClick = onClick,
        buttonText = buttonText,
        backgroundColor = Color(0xFFE24329),
        contentColor = Color.White,
        icon = painterResource(Res.drawable.ic_gitlab_logo),
    )
}

@Composable
fun AppleLoginButton(
    isSignup: Boolean = false,
    onClick: () -> Unit,
) {
    val buttonText =
        if (!isSignup) {
            stringResource(Res.string.sign_in_with, "Apple")
        } else {
            stringResource(Res.string.sign_up_with, "Apple")
        }
    SocialLoginButton(
        onClick = onClick,
        buttonText = buttonText,
        backgroundColor = Color.Black,
        contentColor = Color.White,
        icon = painterResource(Res.drawable.ic_apple_logo),
    )
}

@Composable
fun FacebookLoginButton(
    isSignup: Boolean = false,
    onClick: () -> Unit,
) {
    val buttonText =
        if (!isSignup) {
            stringResource(Res.string.sign_in_with, "Facebook")
        } else {
            stringResource(Res.string.sign_up_with, "Facebook")
        }
    SocialLoginButton(
        onClick = onClick,
        buttonText = buttonText,
        backgroundColor = Color(0xFF1877F2),
        contentColor = Color.White,
        icon = painterResource(Res.drawable.ic_facebook_logo),
    )
}

@Composable
fun GitHubLoginButton(
    isSignup: Boolean = false,
    onClick: () -> Unit,
) {
    val buttonText =
        if (!isSignup) {
            stringResource(Res.string.sign_in_with, "GitHub")
        } else {
            stringResource(Res.string.sign_up_with, "GitHub")
        }
    SocialLoginButton(
        onClick = onClick,
        buttonText = buttonText,
        backgroundColor = Color.Black,
        contentColor = Color.White,
        icon = painterResource(Res.drawable.ic_github_logo),
    )
}

@Composable
fun SocialLoginButton(
    onClick: () -> Unit,
    buttonText: String,
    backgroundColor: Color,
    contentColor: Color,
    icon: Painter,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        modifier =
            modifier
                .fillMaxWidth(),
        shape = RoundedCornerShape(32.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                tint = contentColor,
                modifier = Modifier.size(24.dp),
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = buttonText,
                color = contentColor,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}
