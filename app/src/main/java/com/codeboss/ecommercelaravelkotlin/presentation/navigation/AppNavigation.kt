package com.codeboss.ecommercelaravelkotlin.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codeboss.ecommercelaravelkotlin.presentation.screens.auth.login.LoginScreen
import com.codeboss.ecommercelaravelkotlin.presentation.screens.auth.register.RegisterScreen
import com.codeboss.ecommercelaravelkotlin.presentation.screens.home.HomeScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    startOnHome: Boolean
){
    NavHost(
        navController = navController,
        startDestination = if (startOnHome) AppScreen.Home.route else AppScreen.Login.route
    ){
        composable(AppScreen.Login.route){
            LoginScreen(navController)
        }

        composable(AppScreen.Register.route) {
            RegisterScreen(navController)
        }

        composable(AppScreen.Home.route) {
            HomeScreen()
        }
    }

}