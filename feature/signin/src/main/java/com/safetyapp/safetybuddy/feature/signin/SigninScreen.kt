package com.safetyapp.safetybuddy.feature.signin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.safetyapp.safetybuddy.core.view.composables.PreviewLightDark
import com.safetyapp.safetybuddy.core.view.theme.SafeBuddyTheme

@Composable
fun signInScreen(
    passwordTesTag: String = "",
    emailTestTag: String = "",
    onSubmitButtonClicked: () -> Unit,
    isPasswordEnabled: Boolean,
    isEmailEnabled: Boolean,
) {
    val focusRequester = FocusRequester()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        EmailTextComposable(
            modifier = Modifier
                .fillMaxWidth()
                .testTag(emailTestTag)
                .padding(5.dp),

            emailBoardActions =
                KeyboardActions(onNext = {
                    focusRequester.requestFocus()
                }),
            emailBoardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Red,
                unfocusedBorderColor = Color.Yellow,
                disabledBorderColor = Color.Blue,
                disabledTextColor = Color.Blue,
                disabledSupportingTextColor = Color.Blue,
                errorBorderColor = SafeBuddyTheme.colorScheme.error,

                ),
            emailValue = "",
            onEmailChanged = {},
            isError = false,
            label = "Enter a valid Email",
            placeHolder = "email@company.com",
            isEmailEnabled = isEmailEnabled,
        )

        PassWordTextComposable(
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)
                .padding(start = 3.dp, end = 3.dp)
                .testTag(passwordTesTag),
            passWordKeyBoardActions =
                KeyboardActions(
                    onDone = { onSubmitButtonClicked() }
                ),
            passWordKeyBoardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Red,
                unfocusedBorderColor = Color.Yellow,
                disabledBorderColor = Color.Blue,
                disabledTextColor = Color.Blue,
                disabledSupportingTextColor = Color.Blue,
                errorBorderColor = SafeBuddyTheme.colorScheme.error,
            ),
            onPasswordChanged = {},
            isError = true,
            isPasswordEnabled = isPasswordEnabled,

            )
    }


}

@PreviewLightDark
@Composable
fun PreviewSignInScreen() {

    SafeBuddyTheme {
        signInScreen(
            onSubmitButtonClicked = {},
            isPasswordEnabled = true,
            isEmailEnabled = true
        )


    }
}