package com.safetyapp.safetybuddy.feature.onboarding.presentation

import androidx.annotation.RawRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.safetyapp.safetybuddy.core.view.composables.AnimatedDisplayComposable
import com.safetyapp.safetybuddy.core.view.composables.PreviewLightDark
import com.safetyapp.safetybuddy.core.view.theme.SafeBuddyTheme
import kotlinx.coroutines.delay


val listOfOnboardingItems: List<OnBoardingPage> = listOf(
    OnBoardingPage.First,
    OnBoardingPage.Second,
    OnBoardingPage.Third,
    OnBoardingPage.Fourth,
    OnBoardingPage.Fifth
)

@Composable
fun PagerComposable(

    @RawRes image: Int,
    isAnimationPlaying: Boolean = true,
    speed: Float = 1f,


    ) {

    Column(modifier = Modifier.wrapContentSize()) {

        AnimatedDisplayComposable(
            modifier = Modifier
                .height(400.dp)
                .fillMaxWidth(),
            image = image,//,
            isAnimationPlaying = isAnimationPlaying,
            speed = speed

        )

    }

}


/**
 * This is a preview of the pager composable that views individual pages of the pager screen
 * you can change the pager screen by changing the listOfOnboardingItems list and the index,
 * **/
@PreviewLightDark
@Composable
fun Txtprev() {
    SafeBuddyTheme {
        val speed by remember { mutableFloatStateOf(1F) }
        var isAnimationPlaying by remember { mutableStateOf(true) }

        LaunchedEffect(key1 = isAnimationPlaying) {
            delay(2700)
            isAnimationPlaying = false
        }


        PagerComposable(
            speed = speed,
            isAnimationPlaying = isAnimationPlaying,
            image = listOfOnboardingItems[4].image,


            )
    }

}