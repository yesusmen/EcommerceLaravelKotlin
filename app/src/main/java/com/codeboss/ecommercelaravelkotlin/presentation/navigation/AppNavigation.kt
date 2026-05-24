package com.codeboss.ecommercelaravelkotlin.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codeboss.ecommercelaravelkotlin.presentation.screens.admin.home.AdminHomeScreen
import com.codeboss.ecommercelaravelkotlin.presentation.screens.auth.login.LoginScreen
import com.codeboss.ecommercelaravelkotlin.presentation.screens.auth.register.RegisterScreen
import com.codeboss.ecommercelaravelkotlin.presentation.screens.client.home.ClientHomeScreen
import com.codeboss.ecommercelaravelkotlin.presentation.screens.roles.RolesScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
){
    NavHost(
        navController = navController,
        startDestination = AppScreen.Login.route
    ){
        composable(AppScreen.Login.route){
            LoginScreen(navController)
        }

        composable(AppScreen.Register.route) {
            RegisterScreen(navController)
        }


        composable(AppScreen.Roles.route) {
            RolesScreen(navController)
        }

        composable(AppScreen.ClientHome.route) {
            ClientHomeScreen(navController)
        }

        composable(AppScreen.AdminHome.route) {
            AdminHomeScreen(navController)
        }
    }

}