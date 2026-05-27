package com.codeboss.ecommercelaravelkotlin.presentation.navigation.graph.roles

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.codeboss.ecommercelaravelkotlin.presentation.navigation.root.Graph
import com.codeboss.ecommercelaravelkotlin.presentation.navigation.screen.roles.RolesScreen
import com.codeboss.ecommercelaravelkotlin.presentation.screens.admin.home.AdminHomeScreen
import com.codeboss.ecommercelaravelkotlin.presentation.screens.client.home.ClientHomeScreen
import com.codeboss.ecommercelaravelkotlin.presentation.screens.roles.RolesScreen


fun NavGraphBuilder.RolesNavGraph (
    navController: NavHostController
){

    navigation(
        route = Graph.ROLES,
        startDestination = RolesScreen.Roles.route
    ){
        composable(route = RolesScreen.Roles.route){
           RolesScreen(navController)
        }

        composable(route = Graph.CLIENT) {
            ClientHomeScreen()
        }

        composable(route = Graph.ADMIN) {
            AdminHomeScreen()
        }
    }

}