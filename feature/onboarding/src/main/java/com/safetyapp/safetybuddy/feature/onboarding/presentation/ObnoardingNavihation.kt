package com.safetyapp.safetybuddy.feature.onboarding.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.safetyapp.safetybuddy.core.view.theme.PreviewLightDark

const val ONBOARDING_ROUTE = "onboardingScreen"
fun NavGraphBuilder.onboardingScreen(onFinishedClicked:()->Unit){

    composable(ONBOARDING_ROUTE){
        OnboardingScreen(onFinishedClicked = onFinishedClicked)
    }

}

fun NavController.navigateToHome(){
    navigate(ONBOARDING_ROUTE)
}


@Composable
internal fun HomeScreen(
    onLogin:()->Unit
) {

    Column{
        Text("i am in the home screen")
        TextButton(
            onClick = onLogin
        ){
            Text("login")
        }

    }


}

@PreviewLightDark
@Composable
fun HomeScreenPreview(){
    HomeScreen(onLogin = {})
}
