package com.safetyapp.safetybuddy.feature.onboarding.presentation

import androidx.annotation.RawRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Stable
import com.safetyapp.safetybuddy.core.view.R.raw.men_at_work
import com.safetyapp.safetybuddy.core.view.R.raw.dataanalysis
import com.safetyapp.safetybuddy.core.view.R.raw.ambulancia
import com.safetyapp.safetybuddy.core.view.R.raw.location
import com.safetyapp.safetybuddy.core.view.R.raw.secondlocation
import com.safetyapp.safetybuddy.core.view.R


@Stable
sealed class OnBoardingPage(
    @RawRes val image: Int,
    @StringRes val title: Int,
    @StringRes val description: Int,
) {
    data object First : OnBoardingPage(
        image = men_at_work,
        title = R.string.Real_Time_Situational_Report,
        description = R.string.IncidentResponse
    )

    data object Second : OnBoardingPage(
        image = dataanalysis,
        title = R.string.data_analysis,
        description = R.string.Leverage_AI
    )

    data object Third : OnBoardingPage(
        image = ambulancia,
        title = R.string.Emergency_Calls,
        description = R.string.Emergency_Response
    )

    data object Fourth : OnBoardingPage(
        image = location,
        title = R.string.Location_Tracking,
        description = R.string.Real_Time_Location
    )

    data object Fifth : OnBoardingPage(
        image = secondlocation,
        title = R.string.Tracking_location,
        description = R.string.Navigate_Effectively
    )
}