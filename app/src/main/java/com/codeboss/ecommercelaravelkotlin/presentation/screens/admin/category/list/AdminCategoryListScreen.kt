package com.codeboss.ecommercelaravelkotlin.presentation.screens.admin.category.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.codeboss.ecommercelaravelkotlin.presentation.screens.admin.category.list.components.AdminCategoryListContent

@Composable
fun AdminCategoryListScreen() {
    Scaffold(
        topBar = {},
        content = {paddingValues ->
            AdminCategoryListContent(paddingValues)
        },
        bottomBar = {}
    )
}