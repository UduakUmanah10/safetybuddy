package com.safetyapp.safetybuddy.core.view.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.safetyapp.safetybuddy.core.view.R
import com.safetyapp.safetybuddy.core.view.theme.SafeBuddyTheme

/**
 * This is a composable that is used to toggle between two icons.
 * @param[showIcon] : a value that is used to determine which icon to show.
 * @param[onFirstIconClicked]: a lambda function that is called when the first icon is clicked.
 * @param[onSecondIconClicked]: a lambda function that is called when the second icon is clicked.
 * @param[iconSize]: the size of the icon.
 * @param[enabled]: a boolean value that is used to determine if the icon is enabled.
 * @param[onLabelClicked]: a string value that is used to determine the label of the icon.
 * @param[role]: a Role value that is used to determine the role of the icon.
 * @param[firstIconTint]: the tint color of the first icon.
 * @param[secondIconTint]: the tint color of the second icon.
 * @return Unit
 * **/

@Composable
fun SwitchIcons(
    showIcon: Boolean,
    firstIconTint: Color = SafeBuddyTheme.colorScheme.error,
    secondIconTint: Color = SafeBuddyTheme.colorScheme.error,
    firstIconDescription: String = "",
    secondIconDescription: String = "",
    @DrawableRes visibleIcon: Int = R.drawable.visibility,
    @DrawableRes maskIcon: Int = R.drawable.visibility_off,
    onFirstIconClicked : ()->Unit ={},
    onSecondIconClicked : ()->Unit ={},
    iconSize: Dp = 20.dp,
    enabled :Boolean = true,
    onLabelClicked:String? = null,
    role: Role? = null
){
    if (showIcon) Icon(
        painter = painterResource(id = visibleIcon),
        contentDescription = firstIconDescription,
        tint = firstIconTint,
        modifier = Modifier.size(iconSize).clickable(
            enabled = enabled,
            onClickLabel = onLabelClicked,
            role = role,
            onClick = onFirstIconClicked),
    ) else Icon(
        painter = painterResource(id = maskIcon),
        contentDescription = secondIconDescription,
        tint = secondIconTint,
        modifier = Modifier.size(iconSize).clickable(
            enabled = enabled,
            onClickLabel = onLabelClicked,
            role = role,
            onClick = onSecondIconClicked
        ),
    )
}

@PreviewLightDark
@Composable
fun ToggleIconPreview(){
  var toggleImage by remember { mutableStateOf(false) }
    SafeBuddyTheme {
        SwitchIcons(
            showIcon = toggleImage,
            onSecondIconClicked = {toggleImage=!toggleImage},
            onFirstIconClicked = {toggleImage=!toggleImage}
        )
    }

}