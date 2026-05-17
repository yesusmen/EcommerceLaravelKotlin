package com.codeboss.ecommercelaravelkotlin.presentation.navigation

sealed class AppScreen(val route: String){
    object Login: AppScreen("login")
    object Register: AppScreen("register")
    object Home: AppScreen("home")
}