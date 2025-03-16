package com.safetyapp.safetybuddy.feature.onboarding.presentation

import androidx.annotation.RawRes
import androidx.compose.runtime.Stable
import com.safetyapp.safetybuddy.core.view.R.raw.men_at_work
import com.safetyapp.safetybuddy.core.view.R.raw.dataanalysis
import com.safetyapp.safetybuddy.core.view.R.raw.ambulancia
import com.safetyapp.safetybuddy.core.view.R.raw.location
import com.safetyapp.safetybuddy.core.view.R.raw.secondlocation


@Stable
sealed class OnBoardingPage(
    @RawRes val image: Int,
    val title: String,
    val description: String,
) {
    data object First : OnBoardingPage(
        image = men_at_work,
        title = "Real-Time Situational Report",
        description = "Get real-time incident data and respond appropriately to prevent severe accidents."
    )

    data object Second : OnBoardingPage(
        image = dataanalysis,
        title = "AI-Driven Data Analysis",
        description = "Leverage AI-powered analytics to detect patterns, predict risks, and take proactive measures."
    )

    data object Third : OnBoardingPage(
        image = ambulancia,
        title = "Automated Distress Calls",
        description = "Automate emergency calls, execute emergency action plans, and prevent life loss."
    )

    data object Fourth : OnBoardingPage(
        image = location,
        title = "Locate the Nearest Emergency Point",
        description = "Quickly find the closest emergency response point and get immediate assistance."
    )

    data object Fifth : OnBoardingPage(
        image = secondlocation,
        title = "Enhanced Navigation",
        description = "Navigate efficiently to emergency points using real-time location tracking."
    )
}