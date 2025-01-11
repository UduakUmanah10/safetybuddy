package com.safetyapp.safetybuddy.feature.onboarding.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.safetyapp.safetybuddy.core.view.theme.PreviewLightDark


@Composable
fun OnboardingScreen(
    listOfOnborrdingItems:List<OnBoardingPage>  = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third,
    )

) {

    val pagerState = rememberPagerState(0){
        listOfOnborrdingItems.size
    }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.secondary)
            .fillMaxSize()
            .statusBarsPadding().padding(top = 50.dp)
            .navigationBarsPadding(),
    ) {
        Column {



        HorizontalPager(
            modifier = Modifier,
            state = pagerState,
            verticalAlignment = Alignment.Top,
        ) { position ->

            Column {

                AnimatedDisplay(
                    modifier= Modifier,
                    currentOnBoardingPage = listOfOnborrdingItems[position],
                    playAnimation = true,
                    delayTime = 2700,
                    animationSpeed =1f
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = listOfOnborrdingItems[position].title,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.secondaryContainer,
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp)
                        .padding(top = 20.dp, bottom = 50.dp),
                    text = listOfOnborrdingItems[position].description,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondaryContainer,
                )

                PagerScreenButton(
                    modifier = Modifier.fillMaxWidth().padding( start = 5.dp, end = 5.dp),
                    isButtonVisible = pagerState.currentPage == 2,
                    onClick = {},
                    onButtonClicked = {}

                )

            }

        }





        }
    }
    }
//}


@Composable
@PreviewLightDark
fun onBoardingScreenPreview() {
    OnboardingScreen()

}