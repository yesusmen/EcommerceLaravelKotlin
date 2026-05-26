package com.codeboss.ecommercelaravelkotlin.presentation.screens.admin.home.components

import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.codeboss.ecommercelaravelkotlin.presentation.navigation.screen.admin.AdminScreen
import com.codeboss.ecommercelaravelkotlin.presentation.ui.theme.Blue700

@Composable
fun AdminBottomBar(
    navController: NavHostController
){

    val screens = listOf(
        AdminScreen.ProductList,
        AdminScreen.CategoryList,
        AdminScreen.Profile
    )

    val navBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackEntry?.destination
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    if (bottomBarDestination){
        NavigationBar(
            containerColor = Blue700,
            contentColor = Color.White
        ) {
            screens.forEach { screen ->
                AdminBottomItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }


}