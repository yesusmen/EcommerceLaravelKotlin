package com.codeboss.ecommercelaravelkotlin.presentation.navigation.screen.roles

import com.codeboss.ecommercelaravelkotlin.presentation.navigation.screen.auth.AuthScreen

sealed class RolesScreen(val route: String) {

    object Roles: RolesScreen("roles")

}