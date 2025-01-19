package com.safetyapp.safetybuddy.feature.onboarding.presentation

import androidx.annotation.RawRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.safetyapp.safetybuddy.core.view.theme.PreviewLightDark
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
    onfinishClicked: () -> Unit = {}

){

    Column(modifier = Modifier.fillMaxHeight()) {

        AnimatedDisplayComposable(
            modifier= Modifier,
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

        PagerScreenButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding( start = 10.dp, end = 10.dp),
            isButtonVisible = currentIndex == 2,
            onButtonClicked = onfinishClicked

        )


    }


}



@PreviewLightDark
@Composable
fun Txtprev(){
    SafeBuddyTheme {
        PagerComposable(
            currentIndex = 2,
            image = listOfOnboardingItems[0].image,
            firstScreenText = "Real Time Situational Report",
            secondScreenText = "Get real time Incident data, Respond appropriately to prevent severe Accident."

        )
    }

}