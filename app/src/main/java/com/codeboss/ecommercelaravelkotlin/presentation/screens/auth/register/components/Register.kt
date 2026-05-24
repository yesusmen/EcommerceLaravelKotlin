package com.codeboss.ecommercelaravelkotlin.presentation.screens.auth.register.components

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
import com.codeboss.ecommercelaravelkotlin.domain.util.Resource
import com.codeboss.ecommercelaravelkotlin.presentation.navigation.AppScreen
import com.codeboss.ecommercelaravelkotlin.presentation.screens.auth.register.RegisterViewModel

@Composable
fun Register(
    navController: NavHostController,
    vm: RegisterViewModel = hiltViewModel()
) {

    when(val response = vm.registerResource) {

        Resource.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator()
            }
        }

        is Resource.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate(route = AppScreen.Home.route) {
                    popUpTo(AppScreen.Register.route) { inclusive = true }
                }
            }
        }

        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }

        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Hubo un error desconocido", Toast.LENGTH_LONG).show()
            }
        }

    }

}