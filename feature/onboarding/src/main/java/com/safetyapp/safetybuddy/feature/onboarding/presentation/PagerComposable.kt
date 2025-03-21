package com.safetyapp.safetybuddy.feature.onboarding.presentation

import androidx.annotation.RawRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.safetyapp.safetybuddy.core.view.composables.PagerScreenButton
import com.safetyapp.safetybuddy.core.view.composables.AnimatedDisplayComposable
import com.safetyapp.safetybuddy.core.view.composables.PreviewLightDark
import com.safetyapp.safetybuddy.core.view.theme.SafeBuddyTheme


val listOfOnboardingItems:List<OnBoardingPage>  = listOf(
OnBoardingPage.First,
OnBoardingPage.Second,
OnBoardingPage.Third,
    OnBoardingPage.Fourth,
    OnBoardingPage.Fifth
    )

@Composable
fun PagerComposable(

    @RawRes image:Int,


){

    Column(modifier = Modifier.wrapContentSize()) {

        AnimatedDisplayComposable(
            modifier= Modifier.height(400.dp).fillMaxWidth(),
            image =  image,//,
            playAnimation = true,
            delayTime = 2700,
            animationSpeed =1f
        )




    }


}


/**
 * This is a preview of the pager composable that views individual pages of the pager screen
 * you can change the pager screen by changing the listOfOnboardingItems list and the index,
 * **/
@PreviewLightDark
@Composable
fun Txtprev(){
    SafeBuddyTheme {
        PagerComposable(

            image = listOfOnboardingItems[4].image,


        )
    }

}