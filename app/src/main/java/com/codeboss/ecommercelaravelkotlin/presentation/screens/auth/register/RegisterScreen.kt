package com.codeboss.ecommercelaravelkotlin.presentation.screens.auth.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.codeboss.ecommercelaravelkotlin.presentation.components.DefaultTopAppBar
import com.codeboss.ecommercelaravelkotlin.presentation.navigation.AppScreen
import com.codeboss.ecommercelaravelkotlin.presentation.screens.auth.register.components.Register
import com.codeboss.ecommercelaravelkotlin.presentation.screens.auth.register.components.RegisterContent

@Composable
fun RegisterScreen(
    navController: NavHostController
){
    Scaffold(
        topBar = {
            DefaultTopAppBar(
                title = "Registro",
                upAvailable = true,
                navController = navController
            )
        },
        content = {paddingValues ->
            RegisterContent(navController, paddingValues)
        },
        bottomBar = {}
    )

    Register(navController)
}