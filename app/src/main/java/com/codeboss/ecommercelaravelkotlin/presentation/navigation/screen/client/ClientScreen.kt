package com.codeboss.ecommercelaravelkotlin.presentation.navigation.screen.client

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ClientScreen(
    val route: String,
    val title: String,
    val icon: ImageVector,
) {
    object CategoryList: ClientScreen(
        route = "client/category/list",
        title = "Categorías",
        icon = Icons.AutoMirrored.Filled.List
    )

    object ProductList: ClientScreen(
        route = "client/product/list",
        title = "Productos",
        icon = Icons.Default.ThumbUp
    )

    object Profile: ClientScreen(
        route = "client/profile",
        title = "Perfil",
        icon = Icons.Default.Person
    )

}