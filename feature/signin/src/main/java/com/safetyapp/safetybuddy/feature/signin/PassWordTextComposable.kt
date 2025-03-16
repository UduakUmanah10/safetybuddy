package com.safetyapp.safetybuddy.feature.signin

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
import com.safetyapp.safetybuddy.core.view.composables.SwitchIcons
import com.safetyapp.safetybuddy.core.view.theme.SafeBuddyTheme


@Composable
fun PassWordTextComposable(

    modifier: Modifier,
    passWordKeyBoardActions: KeyboardActions =
        KeyboardActions(
            onDone = {}
        ),
    passWordKeyBoardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Email,
        imeAction = ImeAction.Done
    ),
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = Color.Red,
        unfocusedBorderColor = Color.Yellow,
        disabledBorderColor = Color.Blue,
        disabledTextColor = Color.Blue,
        disabledSupportingTextColor = Color.Blue,
        errorBorderColor = SafeBuddyTheme.colorScheme.error,

        ),
    passwordValue: String = "",
    onPasswordChanged: (String) -> Unit,
    isError: Boolean = false,
    maskPassword: Boolean = true,
    label: String = "Enter Password",
    placeHolder: String = "please enter a valid Pssword",
    isPasswordEnabled: Boolean
) {

    CustomTextField(
        modifier = modifier,
        text = passwordValue,
        onTextChanged = onPasswordChanged,
        labelText = label,
        enabled = isPasswordEnabled,
        placeholderText = placeHolder,
        isError = isError,
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.shieldlockx),
                contentDescription = "",
                tint = SafeBuddyTheme.colorScheme.inverseSurface,
                modifier = Modifier.size(20.dp),
            )
        },
        trailingIcon = { SwitchIcons(showIcon = maskPassword) },
        keyboardActions = passWordKeyBoardActions,
        keyboardOptions = passWordKeyBoardOptions,
        shape = SafeBuddyTheme.appShape.button,
        colors = colors,
        testTag = "emailTextField"

    )

}

@PreviewLightDark
@Composable
fun PreviewPasswordComposable() {
    val testTag: String = ""
    SafeBuddyTheme {
        PassWordTextComposable(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester)
                    .testTag(testTag)
                    .padding(10.dp),
            onPasswordChanged = {},
            isPasswordEnabled = true
        )

    }
}