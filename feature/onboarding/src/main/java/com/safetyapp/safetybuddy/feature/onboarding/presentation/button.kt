package com.safetyapp.safetybuddy.feature.onboarding.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.safetyapp.safetybuddy.core.view.theme.PreviewLightDark
import com.safetyapp.safetybuddy.core.view.theme.SafeBuddyTheme


@Composable
fun PagerScreenButton(
    modifier: Modifier,
    isButtonVisible: Boolean = true,
    onButtonClicked: ()->Unit
) {

        AnimatedVisibility(
            visible = isButtonVisible
        ) {
            Button(
                modifier = modifier,
                onClick = onButtonClicked,
                colors = ButtonDefaults.buttonColors(
                    containerColor =  SafeBuddyTheme.colorScheme.inverseSurface
                ),
                shape = MaterialTheme.shapes.extraLarge
            ) {
                Text(
                    text = "Finish",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondaryContainer,
                )
            }
        }
}

@PreviewLightDark
@Composable
fun PagerScreenButtonPreview() {
    PagerScreenButton(
        modifier = Modifier.fillMaxWidth(),
        onButtonClicked = {},
        )
}