package com.safetyapp.safetybuddy.feature.onboarding.presentation
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.safetyapp.safetybuddy.core.view.composables.PreviewLightDark
import com.safetyapp.safetybuddy.core.view.theme.SafeBuddyTheme
import kotlinx.coroutines.launch


@Composable
internal fun  OnboardingScreen(
   listOfOnboardingItems: List<OnBoardingPage> = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third,
       OnBoardingPage.Fourth,
       OnBoardingPage.Fifth
    ),
    statusBarPadding: Dp = 50.dp,
    onFinishedClicked: () -> Unit = {},
    backgroundColor: Color = SafeBuddyTheme.colorScheme.secondary,

) {

    val scope = rememberCoroutineScope()

    val pagerState = rememberPagerState(0){
        listOfOnboardingItems.size
    }

    val currentPage = pagerState.currentPage

    val name: String = if (currentPage < listOfOnboardingItems.size - 1) "next" else "Done"
    Column(
        modifier = Modifier
            .background(backgroundColor)
            .fillMaxHeight()
            .statusBarsPadding()
            .padding(top = statusBarPadding)
            .navigationBarsPadding(),
    ) {


        HorizontalPager(
            modifier = Modifier,
            state = pagerState,

        ) { position ->
                PagerComposable(
                    image = listOfOnboardingItems[position].image,

                )

        }

        Column(modifier = Modifier.padding(30.dp)) {
            Text(
                modifier = Modifier
                    .fillMaxWidth().height(100.dp),
                text = listOfOnboardingItems[currentPage].title,
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
                text =listOfOnboardingItems[currentPage].description,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondaryContainer,
            )

        }


        pagerControllerButtons(

            modifier =Modifier.padding(all=10.dp),
            currentPage = currentPage,
            previousButtonText =  "back",
            nextButtonText = name,
            indicatorCount = listOfOnboardingItems.size,
            onBackButtonClicked = {
                scope.launch {
                    if ( currentPage > 0 )
                        pagerState.animateScrollToPage(currentPage-1)
                }
            },
            onNextButtonClicked = {
                if ( currentPage <  listOfOnboardingItems.size -1 ){
                scope.launch {

                    pagerState.animateScrollToPage(currentPage+1)}

                }else { onFinishedClicked() }
            }
        )

    }
}



@Composable
@PreviewLightDark
fun OnBoardingScreenPreview() {
    SafeBuddyTheme{
        OnboardingScreen()

    }

}