package com.safetyapp.safetybuddy.feature.onboarding.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.safetyapp.safetybuddy.core.view.composables.AnimatedDisplayComposable
import com.safetyapp.safetybuddy.core.view.composables.CustomButton
import com.safetyapp.safetybuddy.core.view.composables.PreviewLightDark
import com.safetyapp.safetybuddy.core.view.theme.SafeBuddyTheme
import com.safetyapp.safetybuddy.feature.onboarding.R



@Composable
fun SignInAndSignup() {

    Column(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {


        AnimatedDisplayComposable(
            modifier= Modifier.height(250.dp).fillMaxWidth(),
            image = com.safetyapp.safetybuddy.core.view.R.raw.logins,//,

        )


        CustomButton(
            modifier = Modifier.fillMaxWidth(),
            buttonText = "Sign In",
            onButtonClicked = { /*TODO*/ },
            enabled = true

        )

        CustomButton(
            modifier = Modifier.fillMaxWidth(),
            buttonText = "Sign up",
            onButtonClicked = { /*TODO*/ },
            enabled = true
        )

    }

}


@PreviewLightDark
@Composable
fun SignInAndSignupPreview() {
    SafeBuddyTheme {
        SignInAndSignup()
    }
}