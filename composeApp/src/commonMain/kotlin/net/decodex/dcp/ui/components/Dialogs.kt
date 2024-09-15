package net.decodex.dcp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dcp_mobile.composeapp.generated.resources.Res
import dcp_mobile.composeapp.generated.resources.ok
import org.jetbrains.compose.resources.stringResource

@Composable
fun ErrorDialog(
    title: String,
    errorMessage: String?,
    onDismiss: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = {
            onDismiss()
        },
        title = { Text(text = title) },
        text = { Text(text = errorMessage.orEmpty()) },
        confirmButton = {
            Button(
                onClick = {
                    onDismiss()
                },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onErrorContainer),
            ) {
                Text(stringResource(Res.string.ok))
            }
        },
        containerColor = MaterialTheme.colorScheme.errorContainer,
        modifier =
            Modifier
                .padding(16.dp),
    )
}
