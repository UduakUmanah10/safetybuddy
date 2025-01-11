package com.safetyapp.safetybuddy.feature.onboarding.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.safetyapp.safetybuddy.core.view.theme.PreviewLightDark


@Composable
fun PagerScreenButton(
    modifier: Modifier,
   // pagerState: PagerState,
    onClick: () -> Unit,
    isButtonVisible: Boolean = true,
    onButtonClicked: ()->Unit
) {

        AnimatedVisibility(
        //   modifier = modifier, //Modifier.fillMaxWidth().padding(10.dp),
            visible = isButtonVisible //pagerState.currentPage == 2,
        ) {
            Button(
                modifier = modifier,
                onClick = onButtonClicked,
                colors = ButtonDefaults.buttonColors(
                    contentColor = MaterialTheme.colorScheme.inverseSurface,
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
        onClick =   {},
        onButtonClicked = {},
        )
}