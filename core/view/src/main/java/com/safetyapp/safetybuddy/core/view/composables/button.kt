package com.safetyapp.safetybuddy.core.view.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.safetyapp.safetybuddy.core.view.theme.SafeBuddyTheme


@Composable
fun CustomButton(
    modifier: Modifier,
    buttonText: String = "Finish",
    onButtonClicked: () -> Unit,
    enabled: Boolean = true,
) {

    Button(
        modifier = modifier,
        onClick = onButtonClicked,
        colors = ButtonDefaults.buttonColors(
            containerColor = SafeBuddyTheme.colorScheme.inverseSurface
        ),
        shape = MaterialTheme.shapes.extraLarge,
        enabled = enabled
    ) {
        Text(
            text = buttonText,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.secondaryContainer,
        )
    }
}

@PreviewLightDark
@Composable
fun PagerScreenButtonPreview() {
    CustomButton(
        modifier = Modifier.fillMaxWidth(),
        onButtonClicked = {},
    )
}