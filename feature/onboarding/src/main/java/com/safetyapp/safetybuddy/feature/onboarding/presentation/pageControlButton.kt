package com.safetyapp.safetybuddy.feature.onboarding.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.qamar.qindicators.Indicators
import com.safetyapp.safetybuddy.core.view.composables.PreviewLightDark
import com.safetyapp.safetybuddy.core.view.theme.SafeBuddyTheme

@Composable
fun pagerControllerButtons(
    modifier: Modifier,
    currentPage:Int = 0,
    indicatorCount: Int = 4,
    indicatorSize : Int = 10,
    indicatorSpacer: Int = 5,
    indicatorSelectedLength:Int = 30,
    selectedColor:Color = SafeBuddyTheme.colorScheme.inverseSurface,
    unSelectedColor:Color = Color.White,
    onNextButtonClicked: ()->Unit ={},
    onBackButtonClicked: ()->Unit={},
    nextButtonText:String = "Next",
    previousButtonText:String = "Back",
    backButtonTestag:String = "",
    nextButtonTestag:String = "",
    indicatorTestag:String = ""

){
    Row(
        modifier = Modifier.fillMaxWidth().padding(all = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(contentAlignment = Alignment.CenterStart, modifier = Modifier.weight(1f)) {
        if (currentPage > 0){
        Button(
            modifier = Modifier.testTag(backButtonTestag),
            onClick = onBackButtonClicked,
            colors = ButtonDefaults.buttonColors(
                containerColor =  SafeBuddyTheme.colorScheme.inverseSurface
            ),
            shape = MaterialTheme.shapes.extraLarge,
            enabled = true
        ) {
            Text(
                text = previousButtonText,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondaryContainer,
            )
          }
        }
        }

        Box(contentAlignment = Alignment.Center, modifier = Modifier.weight(1f)) {

            Indicators(
                modifier = Modifier.testTag(indicatorTestag),
                count = indicatorCount,
                size = indicatorSize,
                spacer = indicatorSpacer,
                selectedPage =currentPage,
                indicatorSelectedLength = indicatorSelectedLength,
                selectedColor = selectedColor,
                unselectedColor = unSelectedColor,
            )
        }

        Box(contentAlignment = Alignment.CenterEnd, modifier = Modifier.weight(1f)) {

            Button(
                modifier = Modifier.testTag(nextButtonTestag),
                onClick = onNextButtonClicked,
                colors = ButtonDefaults.buttonColors(
                    containerColor =  SafeBuddyTheme.colorScheme.inverseSurface
                ),
                shape = MaterialTheme.shapes.extraLarge,
                enabled = true
            ) {
                Text(
                    text = nextButtonText,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondaryContainer,
                )
            }

        }

    }
}


@PreviewLightDark
@Composable
fun PagerScreenButtonPreview() {
    SafeBuddyTheme{
 val modifier = Modifier
    pagerControllerButtons( currentPage = 1,  modifier =modifier)
    }
}