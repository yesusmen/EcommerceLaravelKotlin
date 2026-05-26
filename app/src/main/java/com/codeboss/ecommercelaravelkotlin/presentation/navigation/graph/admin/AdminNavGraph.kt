package com.codeboss.ecommercelaravelkotlin.presentation.navigation.graph.admin

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.codeboss.ecommercelaravelkotlin.presentation.navigation.Graph
import com.codeboss.ecommercelaravelkotlin.presentation.navigation.screen.admin.AdminScreen
import com.codeboss.ecommercelaravelkotlin.presentation.screens.admin.category.list.AdminCategoryListScreen
import com.codeboss.ecommercelaravelkotlin.presentation.screens.admin.product.list.AdminProductListScreen
import com.codeboss.ecommercelaravelkotlin.presentation.screens.profile.ProfileScreen

@Composable
fun AdminNavGraph(navController: NavHostController){

    NavHost(
        navController = navController,
        route = Graph.ADMIN,
        startDestination = AdminScreen.ProductList.route
    ) {
        composable(route = AdminScreen.ProductList.route) {
            AdminProductListScreen()
        }

        composable(route = AdminScreen.CategoryList.route){
            AdminCategoryListScreen()
        }

        composable(route = AdminScreen.Profile.route){
            ProfileScreen()
        }
    }

}