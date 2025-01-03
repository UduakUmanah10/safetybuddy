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
import com.safetyapp.safetybuddy.ui.theme.PreviewLightDark
import com.safetyapp.safetybuddy.ui.theme.SafeBuddyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            SafeBuddyTheme {


                    Column{
                        favoursButton()
                        Text("update")
                        Greeting(
                            name = "Android",
                            // modifier = Modifier.padding(innerPadding)
                        )
                        Text("update")

                    }
            }




        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        color = SafeBuddyTheme.colorScheme.error
    )
}

@Composable
fun favoursButton(){
    Button(onClick = {}, modifier = Modifier.fillMaxWidth().padding(top = 40.dp)) {
        Text("favours button")
    }
}


@PreviewLightDark
@Composable
fun GreetingPreview() {
    SafeBuddyTheme {
        Greeting(modifier = Modifier.fillMaxWidth().fillMaxHeight(), name = "Android")
        favoursButton()
    }
}