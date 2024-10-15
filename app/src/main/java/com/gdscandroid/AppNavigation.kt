package com.gdscandroid

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.SignInScreen.route,
       // modifier = Modifier.padding(innerPadding),
    ) {
        composable(Screens.SignUpScreen.route){
            SignUpScreen(navController)
        }

        composable(Screens.SignInScreen.route){
            SignInScreen(navController)
        }
    }
}