package com.safetyapp.safetybuddy.core.view.composables

import androidx.annotation.RawRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.safetyapp.safetybuddy.core.view.R.raw.secondlocation
import kotlinx.coroutines.delay

/** <==To see this composable in preview screen switch the preview to interactive mode ==>
These composable renders a view pager component from the material 3 design system.
it takes in parameters such as
from the onboarding page class.
@Param[modifier] : to modify the composable
@Param[playAnimation] : to play or stop the animation
@Param[delayTime]: to delay the animation
@Param[animationSpeed]: to determine the speed of the animation
 * **/

@Composable
fun AnimatedDisplayComposable(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(400.dp)
        .background(Color.Transparent),
    @RawRes image: Int,
    restartOnPlay: Boolean = true,
    isAnimationPlaying: Boolean = true,
    speed: Float = 1f,

    ) {
    Column(
        modifier = modifier
    ) {
        val composition by rememberLottieComposition(
            spec = LottieCompositionSpec.RawRes(
                image
            )
        )


        val progress by animateLottieCompositionAsState(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            isPlaying = isAnimationPlaying,
            speed = speed,
            restartOnPlay = restartOnPlay,
        )
        LottieAnimation(
            composition = composition,
            progress = progress,
            modifier = modifier,
        )
    }
}


@PreviewLightDark
@Composable
fun AnimatedContentPreview() {

    val speed by remember { mutableFloatStateOf(1F) }
    var isAnimationPlaying by remember { mutableStateOf(true) }

    LaunchedEffect(key1 = isAnimationPlaying) {
        delay(2700)
        isAnimationPlaying = false
    }



    AnimatedDisplayComposable(
        speed = speed,
        modifier = Modifier
            .height(300.dp)
            .fillMaxWidth()
            .background(Color.Transparent),
        image = secondlocation,
        isAnimationPlaying = isAnimationPlaying
    )
}

