package com.safetyapp.safetybuddy.feature.signin

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class SignInViewModel(
    savedStateHandle: SavedStateHandle,
):ViewModel(

){

    private val postdevailsArgs = postDSetailsArgs(savedStateHandle)


    fun loadPost(){
        val postid =  postdevailsArgs.postId
    }

}