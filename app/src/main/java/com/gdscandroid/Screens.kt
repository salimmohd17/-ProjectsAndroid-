package com.gdscandroid

sealed class Screens(
    val route: String,
) {
    object SignUpScreen : Screens("signUp_screen")

    object SignInScreen : Screens("signIn_screen")

}