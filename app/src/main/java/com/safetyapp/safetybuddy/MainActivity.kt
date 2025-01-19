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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            SafeBuddyTheme {

                val navController = rememberNavController()

                NavHost(
                    navController =navController,
                    startDestination = "test"
                ){
                    composable("test"){
                        Greeting("test") {
                            navController.navigateToHome()
                        }

                    }
                    homeScreen(onLogin = {})
                }


            }

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier,onClick: ()-> Unit,) {
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier,
            color = SafeBuddyTheme.colorScheme.error
        )
        Button(onClick = onClick, modifier = Modifier.fillMaxWidth().padding(top = 40.dp)) {
            Text("favours button")
        }

    }

}

@Composable
fun FavoursButton(){
    Button(onClick = {}, modifier = Modifier.fillMaxWidth().padding(top = 40.dp)) {
        Text("favours button")
    }
}


@PreviewLightDark
@Composable
fun GreetingPreview() {
    SafeBuddyTheme {
        Greeting(modifier = Modifier.fillMaxWidth().fillMaxHeight(), name = "Android", onClick = {})
        FavoursButton()
    }
}