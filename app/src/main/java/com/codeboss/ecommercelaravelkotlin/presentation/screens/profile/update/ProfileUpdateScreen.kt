package com.codeboss.ecommercelaravelkotlin.presentation.screens.profile.update

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.codeboss.ecommercelaravelkotlin.presentation.components.DefaultTopAppBar
import com.codeboss.ecommercelaravelkotlin.presentation.screens.profile.update.components.ProfileUpdateContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileUpdateScreen(navController: NavHostController, userParam: String){

    Scaffold(
        topBar = {
            DefaultTopAppBar(
                title = "Actualizar perfil",
                navController = navController,
                upAvailable = true
            )
        },
        content = {
            ProfileUpdateContent()
        },
    )

}