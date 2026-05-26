package com.codeboss.ecommercelaravelkotlin.presentation.screens.admin.home.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.codeboss.ecommercelaravelkotlin.presentation.navigation.screen.admin.AdminScreen

@Composable
fun RowScope.AdminBottomItem(
    screen: AdminScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
){
    NavigationBarItem(
        label = { Text(text = screen.title) },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = screen.title
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        colors = NavigationBarItemDefaults.colors(
            unselectedIconColor = LocalContentColor.current.copy(alpha = 0.5f),
            unselectedTextColor = LocalContentColor.current.copy(alpha = 0.5f),
            selectedTextColor = Color.White,
            selectedIconColor = Color.White,
            indicatorColor = Color.Transparent,
        ),
        onClick = {
            navController.navigate(route = screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
            }
        }
    )

}