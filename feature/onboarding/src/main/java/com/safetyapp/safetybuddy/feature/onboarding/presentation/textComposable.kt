package com.safetyapp.safetybuddy.feature.onboarding.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun TextForOnBoarding(){

    Text(
        modifier = Modifier
            .fillMaxWidth(),
        text =  "",//onBoardingPage.title,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.displaySmall,
        color = MaterialTheme.colorScheme.secondaryContainer,
    )

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp)
            .padding(top = 20.dp),
        text = "" ,//onBoardingPage.description,
        fontWeight = FontWeight.Medium,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.secondaryContainer,
    )

}