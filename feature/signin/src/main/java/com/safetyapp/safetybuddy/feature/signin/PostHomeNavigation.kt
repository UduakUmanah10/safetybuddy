package com.safetyapp.safetybuddy.feature.signin

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


private const val POST_ID_Args = "postId"

private const val POST_DETAILS_ROUTE:String = "postdetails/$POST_ID_Args={$POST_ID_Args}"

fun  NavGraphBuilder.signInScreen1(
    onNavigateUp: () -> Unit,
){

    composable(POST_DETAILS_ROUTE){

        signInScreen(onSubmitButtonClicked = {}, isEmailEnabled = true, isPasswordEnabled = true)
    }


}

fun NavController.navigateToSignInScreen(postId:Int){
    navigate("postdetails/$POST_ID_Args=$postId")
}

internal class postDSetailsArgs(val postId:String){

    constructor(savedStateHandle: SavedStateHandle) :this( requireNotNull( savedStateHandle.get<String>(POST_ID_Args)))
}