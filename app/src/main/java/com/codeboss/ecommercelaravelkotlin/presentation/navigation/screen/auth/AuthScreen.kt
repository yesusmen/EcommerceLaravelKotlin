package com.codeboss.ecommercelaravelkotlin.presentation.navigation.screen.auth

sealed class AuthScreen(val route: String){
    object Login: AuthScreen("login")
    object Register: AuthScreen("register")
    //object Roles: AuthScreen("roles")
    //object ClientHome: AuthScreen("client/home")
    //object AdminHome: AuthScreen("admin/home")
}