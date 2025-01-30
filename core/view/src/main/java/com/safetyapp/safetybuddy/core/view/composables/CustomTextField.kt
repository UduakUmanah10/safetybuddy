package com.safetyapp.safetybuddy.core.view.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.safetyapp.safetybuddy.core.view.R
import com.safetyapp.safetybuddy.core.view.theme.SafeBuddyTheme



@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    text: String,
    onTextChanged: (String) -> Unit,
    labelText: String,
    placeholderText: String = "",
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = {SwitchIcons(showIcon = false)},
    visualTransformation: VisualTransformation = VisualTransformation.None,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    shape: Shape = OutlinedTextFieldDefaults.shape,
    singleLine: Boolean = true,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = SafeBuddyTheme.colorScheme.primary,
        unfocusedBorderColor = Color.Yellow,
        disabledBorderColor = Color.Blue,
        disabledTextColor = Color.Blue,
        disabledSupportingTextColor = Color.Blue,

        ),
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    showtrailingIcon: Boolean = true,
    supportingText: @Composable (() -> Unit)? = null,

    ) {

    Column(modifier = modifier) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = onTextChanged,
            enabled = enabled,
            readOnly = readOnly,
            textStyle = LocalTextStyle.current,
            label = { Text(labelText) },
            placeholder = { Text(placeholderText) },
            leadingIcon = leadingIcon,
            trailingIcon =  if (showtrailingIcon) trailingIcon else null,
            isError =  false,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            maxLines = maxLines,
            minLines = minLines,
            shape = shape,
            colors = colors,
            supportingText = supportingText
        )

    }
}



@PreviewLightDark
@Composable
fun CustomTextFieldPreview() {
    SafeBuddyTheme {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CustomTextField(
                text = "",
                onTextChanged = {},
                labelText = "Password",
                placeholderText = "enter  a valid password",
                leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.shieldlockx),
                            contentDescription = "",
                            tint = SafeBuddyTheme.colorScheme.error,
                            modifier = Modifier.size(20.dp),
                        )
                },
                shape = SafeBuddyTheme.appShape.button,

            )

            CustomTextField(
                text = "",
                onTextChanged = {},
                labelText = "Email",
                placeholderText = "email@example.com",
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.mail),
                        contentDescription = "",
                        tint = SafeBuddyTheme.colorScheme.error,
                        modifier = Modifier.size(20.dp),
                    )
                },
                shape = SafeBuddyTheme.appShape.button,
                showtrailingIcon = false,
            )

            CustomTextField(
                text = "",
                onTextChanged = {},
                labelText = "",
                enabled = false,
                shape = SafeBuddyTheme.appShape.button,
            )

            CustomTextField(
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.shieldlockx),
                        contentDescription = "",
                        tint = SafeBuddyTheme.colorScheme.error,
                        modifier = Modifier.size(20.dp),
                    )
                },
                text = "password",
                onTextChanged = {},
                labelText = "Password",
                visualTransformation = PasswordVisualTransformation('*'),
                enabled = true,
                shape = SafeBuddyTheme.appShape.button,

            )
        }
    }
}