package com.codeboss.ecommercelaravelkotlin.presentation.navigation.graph.client

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.codeboss.ecommercelaravelkotlin.presentation.navigation.Graph
import com.codeboss.ecommercelaravelkotlin.presentation.navigation.screen.client.ClientScreen
import com.codeboss.ecommercelaravelkotlin.presentation.screens.client.category.list.ClientCategoryListScreen
import com.codeboss.ecommercelaravelkotlin.presentation.screens.client.product.list.ClientProductListScreen
import com.codeboss.ecommercelaravelkotlin.presentation.screens.profile.ProfileScreen


@Composable
fun ClientNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.ProductList.route
    ){
        composable(ClientScreen.CategoryList.route){
            ClientCategoryListScreen()
        }

        composable(ClientScreen.ProductList.route) {
            ClientProductListScreen()
        }

        composable(ClientScreen.Profile.route) {
            ProfileScreen()
        }
    }
}
