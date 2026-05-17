package com.codeboss.ecommercelaravelkotlin.presentation.screens.auth.login

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.codeboss.ecommercelaravelkotlin.presentation.screens.auth.login.components.LoginContent


@Composable
fun LoginScreen(navController: NavHostController){
    Scaffold(
        topBar = {},
        content = {paddingValues ->
            LoginContent(navController,paddingValues)
        },
        bottomBar = {}
    )

}