package com.safetyapp.safetybuddy.feature.onboarding.presentation

import androidx.annotation.RawRes
import androidx.compose.runtime.Stable
import com.safetyapp.safetybuddy.core.view.R.raw.men_at_work
import com.safetyapp.safetybuddy.core.view.R.raw.dataanalysis
import com.safetyapp.safetybuddy.core.view.R.raw.ambulancia

@Stable
sealed class OnBoardingPage(
    @RawRes
    val image: Int,
    val title: String,
    val description: String,
) {
    data object First : OnBoardingPage(
        image = men_at_work,
        title = "Real Time Situational Report",
        description = "Get real time Incident data, Respond appropriately to prevent severe Accident.",
    )

    data object Second : OnBoardingPage(
        image = dataanalysis,
        title = "Data Analysis",
        description = "Analyze incident data, Take necessary Actions, prevent future occurrences .",
    )

    data object Third : OnBoardingPage(
        image = ambulancia,
        title = "Automated Distress Calls",
        description = " Automate emergency calls, execute emergency action plans, prevent life loss.",
    )
}
