package com.codeboss.ecommercelaravelkotlin.presentation.screens.client.home.components

import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.codeboss.ecommercelaravelkotlin.presentation.navigation.screen.client.ClientScreen
import com.codeboss.ecommercelaravelkotlin.presentation.ui.theme.Blue700

@Composable
fun ClientBottomBar(navController: NavHostController) {

    val screens = listOf(
        ClientScreen.ProductList,
        ClientScreen.CategoryList,
        ClientScreen.Profile
    )

    val navBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackEntry?.destination
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {
        NavigationBar(
            containerColor = Blue700,
            contentColor = Color.White
        ) {
            screens.forEach { screen ->
                ClientBottomItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}