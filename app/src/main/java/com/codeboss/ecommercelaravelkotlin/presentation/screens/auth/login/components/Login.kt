package com.codeboss.ecommercelaravelkotlin.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.codeboss.ecommercelaravelkotlin.domain.util.Response
import com.codeboss.ecommercelaravelkotlin.presentation.navigation.AppScreen
import com.codeboss.ecommercelaravelkotlin.presentation.screens.auth.login.LoginViewModel

@Composable
fun Login(
    navController: NavHostController,
    vm: LoginViewModel = hiltViewModel()
){

    when(val response = vm.loginResponse) {

        Response.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator()
            }
        }

        is Response.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate(AppScreen.Home.route) {
                    popUpTo(AppScreen.Login.route) { inclusive = true }
                }
            }
        }

        is Response.Failure -> {
            Toast.makeText(LocalContext.current, "Error desconocido", Toast.LENGTH_LONG).show()
        }

        else -> {}
    }

}