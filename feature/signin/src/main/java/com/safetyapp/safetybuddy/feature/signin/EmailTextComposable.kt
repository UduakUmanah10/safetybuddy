package com.safetyapp.safetybuddy.feature.signin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.safetyapp.safetybuddy.core.view.R
import com.safetyapp.safetybuddy.core.view.composables.CustomTextField
import com.safetyapp.safetybuddy.core.view.composables.PreviewLightDark
import com.safetyapp.safetybuddy.core.view.theme.SafeBuddyTheme

val focusRequester = FocusRequester()

@Composable
fun EmailTextComposable(
    modifier: Modifier,

    emailBoardActions: KeyboardActions =
        KeyboardActions(onNext = {
            focusRequester.requestFocus()
        }),
    emailBoardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Email,
        imeAction = ImeAction.Next
    ),
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = Color.Red,
        unfocusedBorderColor = Color.Yellow,
        disabledBorderColor = Color.Blue,
        disabledTextColor = Color.Blue,
        disabledSupportingTextColor = Color.Blue,
        errorBorderColor = SafeBuddyTheme.colorScheme.error,

        ),
    emailValue: String = "",
    onEmailChanged: (String) -> Unit,
    isError: Boolean = false,
    label: String = "Enter Password",
    placeHolder: String = "please enter a valid Pssword",
    isEmailEnabled: Boolean =true


) {

    CustomTextField(
        modifier = modifier,
        enabled = isEmailEnabled,
        isError = isError,
        text = emailValue,
        onTextChanged = onEmailChanged,
        labelText = label,
        placeholderText = placeHolder,
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.mail),
                contentDescription = "",
                tint = SafeBuddyTheme.colorScheme.inverseSurface,
                modifier = Modifier.size(20.dp),
            )
        },
        keyboardActions = emailBoardActions,

        keyboardOptions = emailBoardOptions,
        trailingIcon = null,
        shape = SafeBuddyTheme.appShape.button,
        colors = colors,
        testTag = "emailTextField"

    )
}


@Composable
@PreviewLightDark
fun PreviewEmailComposable() {
    val emailTestTag  = ""
    SafeBuddyTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            EmailTextComposable(
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester)
                    .testTag(emailTestTag)
                    .padding(10.dp),

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
                label = "Enter Password",
                placeHolder = "please enter a valid Pssword",


                )

        }


    }
}