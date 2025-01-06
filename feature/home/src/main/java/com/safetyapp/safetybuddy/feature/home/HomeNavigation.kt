package com.safetyapp.safetybuddy.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.safetyapp.safetybuddy.core.view.theme.PreviewLightDark


const val HOME_ROUTE = "home"
fun NavGraphBuilder.homeScreen(onLogin:()->Unit){

    composable(HOME_ROUTE){
        HomeScreen(onLogin = onLogin)
    }

}

fun NavController.navigateToHome(){
    navigate(HOME_ROUTE)
}


@Composable
internal fun HomeScreen(
    onLogin:()->Unit
) {

    Column{
        Text("i am in the home screen")
        TextButton(
           onClick = onLogin
        ){
            Text("login")
        }

    }


}

@PreviewLightDark
@Composable
fun HomeScreenPreview(){
    HomeScreen(onLogin = {})
}
