package com.codeboss.ecommercelaravelkotlin.presentation.screens.admin.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.codeboss.ecommercelaravelkotlin.presentation.navigation.graph.admin.AdminNavGraph
import com.codeboss.ecommercelaravelkotlin.presentation.screens.admin.home.components.AdminBottomBar

@Composable
fun AdminHomeScreen(
    navController: NavHostController = rememberNavController()
){
    Scaffold(
        bottomBar = { AdminBottomBar(navController = navController) }
    ) {paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues)
        ){
            AdminNavGraph(navController = navController)
        }
    }
}