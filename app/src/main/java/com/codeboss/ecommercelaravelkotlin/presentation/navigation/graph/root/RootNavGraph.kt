package com.codeboss.ecommercelaravelkotlin.presentation.navigation.graph.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codeboss.ecommercelaravelkotlin.presentation.navigation.Graph
import com.codeboss.ecommercelaravelkotlin.presentation.navigation.graph.auth.AuthNavGraph
import com.codeboss.ecommercelaravelkotlin.presentation.navigation.graph.roles.RolesNavGraph
import com.codeboss.ecommercelaravelkotlin.presentation.screens.client.home.ClientHomeScreen


@Composable
fun RooNavGraph(
    navController: NavHostController = rememberNavController()
){
    NavHost(
        navController = navController,
        route =  Graph.ROOT,
        startDestination = Graph.AUTH
    ){
        AuthNavGraph(navController = navController)
        RolesNavGraph(navController = navController)
    }
}