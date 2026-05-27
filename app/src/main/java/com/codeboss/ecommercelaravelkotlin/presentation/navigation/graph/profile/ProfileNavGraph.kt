package com.codeboss.ecommercelaravelkotlin.presentation.navigation.graph.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.codeboss.ecommercelaravelkotlin.presentation.navigation.root.Graph
import com.codeboss.ecommercelaravelkotlin.presentation.navigation.screen.profile.ProfileScreen
import com.codeboss.ecommercelaravelkotlin.presentation.screens.profile.update.ProfileUpdateScreen

fun NavGraphBuilder.ProfileNavGraph(
    navController: NavHostController
) {
    navigation(
        route = Graph.PROFILE + "/{userParam}",
        startDestination = ProfileScreen.ProfileUpdate.route
    ){
        composable(
            route = ProfileScreen.ProfileUpdate.route,
            arguments = listOf(navArgument("userParam"){
                type = NavType.StringType
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("userParam")?.let { userParam ->
                ProfileUpdateScreen(navController, userParam = userParam)
            }
        }
    }

}