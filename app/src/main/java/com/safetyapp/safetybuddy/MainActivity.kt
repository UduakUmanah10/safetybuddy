package com.safetyapp.safetybuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.safetyapp.safetybuddy.core.view.theme.PreviewLightDark
import com.safetyapp.safetybuddy.core.view.theme.SafeBuddyTheme
import com.safetyapp.safetybuddy.feature.home.homeScreen
import com.safetyapp.safetybuddy.feature.home.navigateToHome
import com.safetyapp.safetybuddy.feature.onboarding.presentation.onboardingScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            SafeBuddyTheme {

                val navController = rememberNavController()

                NavHost(
                    navController =navController,
                    startDestination = "onboardingScreen"
                ){
                    composable("test"){


                    }
                    homeScreen(onLogin = {})
                    onboardingScreen(onFinishedClicked = {})
                }


            }

        }
    }
}


@PreviewLightDark
@Composable
fun GreetingPreview() {
    SafeBuddyTheme{
        val navController = rememberNavController()

        NavHost(
            navController =navController,
            startDestination = "onboardingScreen"
        ) {
            onboardingScreen(onFinishedClicked = {})
        }

    }
}