package com.safetyapp.safetybuddy.core.view.composables

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(name = "Light", uiMode = Configuration.UI_MODE_NIGHT_NO, showSystemUi = false, showBackground = true)
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = false, showBackground = true)
annotation class PreviewLightDark