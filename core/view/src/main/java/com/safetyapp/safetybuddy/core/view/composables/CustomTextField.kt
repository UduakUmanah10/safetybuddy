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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
    errorMessage: String? = null,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    shape: Shape = OutlinedTextFieldDefaults.shape,
    onFocusChanged: (FocusState) -> Unit = {},
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
            trailingIcon = trailingIcon,
            isError = errorMessage != null,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            maxLines = maxLines,
            minLines = minLines,
            shape = shape,
            colors = colors,
            supportingText =  { Text("supporting Teext") }
        )

        //ErrorText(errorMessage = errorMessage)
    }
}

@Composable
private fun ErrorText(errorMessage: String?) {
    errorMessage?.let {
        Text(
            text = it,
            color = SafeBuddyTheme.colorScheme.error,
            style = SafeBuddyTheme.appTypography.bodySmall,
            modifier = Modifier
                .padding(start = 16.dp, top = 4.dp)
                .fillMaxWidth()
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
            // Normal state
            CustomTextField(
                leadingIcon = {

                        Icon(
                            painter = painterResource(id = R.drawable.shieldlockx),
                            contentDescription = "",
                            tint = SafeBuddyTheme.colorScheme.error,
                            modifier = Modifier.size(20.dp),
                        )

                },
                text = "",
                onTextChanged = {},
                labelText = "Email",
                placeholderText = "email@example.com",
                shape = SafeBuddyTheme.appShape.button
            )

            // Error state
            CustomTextField(
                text = "",
                onTextChanged = {},
                labelText = "Email",
                placeholderText = "email@example.com",
                errorMessage = "Invalid email format",
                shape = SafeBuddyTheme.appShape.button
               // isError = true
            )
          //  val passwordIcon = if (passwordvisibility) R.drawable.visibility else R.drawable.visibility_off

            // Disabled state
            CustomTextField(

                text = "",
                onTextChanged = {},
                labelText = "",
                shape = SafeBuddyTheme.appShape.button,
                enabled = false
            )

            CustomTextField(
                text = "passwordtest",
                onTextChanged = {},
                labelText = "Password",
                shape = SafeBuddyTheme.appShape.button,
                visualTransformation = PasswordVisualTransformation('*'),
                enabled = true
            )
        }
    }
}