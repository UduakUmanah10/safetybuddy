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
    )

@Composable
fun PagerComposable(
    currentIndex:Int,
    firstScreenText:String,
    secondScreenText:String,
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

        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = firstScreenText,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.secondaryContainer,
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .padding(top = 20.dp, bottom = 100.dp),
            text =secondScreenText,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.secondaryContainer,
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
            currentIndex = 1,
            image = listOfOnboardingItems[0].image,
            firstScreenText = "Real Time Situational Report",
            secondScreenText = "Get real time Incident data, Respond appropriately to prevent severe Accident."

        )
    }

}