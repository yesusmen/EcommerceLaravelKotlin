package com.codeboss.ecommercelaravelkotlin.presentation.navigation.graph.auth

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.codeboss.ecommercelaravelkotlin.presentation.navigation.root.Graph
import com.codeboss.ecommercelaravelkotlin.presentation.navigation.screen.auth.AuthScreen
import com.codeboss.ecommercelaravelkotlin.presentation.screens.auth.login.LoginScreen
import com.codeboss.ecommercelaravelkotlin.presentation.screens.auth.register.RegisterScreen

fun NavGraphBuilder.AuthNavGraph(
    navController: NavHostController
){
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ){
        composable(AuthScreen.Login.route){
            LoginScreen(navController)
        }

        composable(AuthScreen.Register.route) {
            RegisterScreen(navController)
        }

    }

}