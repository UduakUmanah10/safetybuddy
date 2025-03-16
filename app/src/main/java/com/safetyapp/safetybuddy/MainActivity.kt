package com.safetyapp.safetybuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.safetyapp.safetybuddy.core.view.composables.PreviewLightDark
import com.safetyapp.safetybuddy.core.view.theme.SafeBuddyTheme
import com.safetyapp.safetybuddy.feature.home.homeScreen
import com.safetyapp.safetybuddy.feature.onboarding.presentation.onboardingScreen
import com.safetyapp.safetybuddy.feature.signin.navigateToSignInScreen
import com.safetyapp.safetybuddy.feature.signin.signInScreen
import com.safetyapp.safetybuddy.feature.signin.signInScreen1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            SafeBuddyTheme {

                val navController = rememberNavController()

                NavHost(
                    navController =navController,
                    startDestination = "onboardingScreen",
                    enterTransition = {

                        slideIntoContainer(
                            towards = AnimatedContentTransitionScope.SlideDirection.Left, animationSpec = tween()
                        )
                    },
                    exitTransition = {
                        scaleOut(targetScale = .9f, animationSpec = tween())
                    },
                    popEnterTransition = {
                        scaleIn(initialScale = .9f, animationSpec = tween())
                    },
                    popExitTransition = {
                        slideOutOfContainer(
                            towards = AnimatedContentTransitionScope.SlideDirection.Right, animationSpec = tween()
                        )
                    }


                ){
                    composable("test"){


                    }
                    homeScreen(onLogin = {})
                    onboardingScreen(onFinishedClicked = {navController.navigateToSignInScreen(1)})
                    signInScreen1 {  }
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
            onboardingScreen(onFinishedClicked = {navController.navigateToSignInScreen(1)})
        }

    }
}