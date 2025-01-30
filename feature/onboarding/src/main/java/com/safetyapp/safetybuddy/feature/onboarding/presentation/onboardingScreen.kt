package com.safetyapp.safetybuddy.feature.onboarding.presentation
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.safetyapp.safetybuddy.core.view.composables.PreviewLightDark
import com.safetyapp.safetybuddy.core.view.theme.SafeBuddyTheme


@Composable
internal fun  OnboardingScreen(
   listOfOnboardingItems: List<OnBoardingPage> = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third,
    ),
    statusBarPadding: Dp = 50.dp,
    onFinishedClicked: () -> Unit = {},
    backgroundColor: Color = SafeBuddyTheme.colorScheme.secondary

) {

    val pagerState = rememberPagerState(0){
        listOfOnboardingItems.size
    }
    
    Column(
        modifier = Modifier
            .background(backgroundColor)
            .fillMaxSize()
            .statusBarsPadding()
            .padding(top = statusBarPadding)
            .navigationBarsPadding(),
    ) {

        HorizontalPager(
            modifier = Modifier,
            state = pagerState,
            verticalAlignment = Alignment.Top,
        ) { position ->
                PagerComposable(
                    currentIndex = position,
                    image = listOfOnboardingItems[position].image,
                    firstScreenText = listOfOnboardingItems[position].title,
                    secondScreenText = listOfOnboardingItems[position].description,
                    onfinishClicked = onFinishedClicked
                )
        }
    }
}



@Composable
@PreviewLightDark
fun OnBoardingScreenPreview() {
    SafeBuddyTheme{
        OnboardingScreen()

    }

}