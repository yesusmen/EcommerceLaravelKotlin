package com.codeboss.ecommercelaravelkotlin.presentation.navigation

sealed class AppScreen(val route: String){
    object Login: AppScreen("login")
    object Register: AppScreen("register")
    object Roles: AppScreen("roles")
    object ClientHome: AppScreen("client/home")
    object AdminHome: AppScreen("admin/home")
}