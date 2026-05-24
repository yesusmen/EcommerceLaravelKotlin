package com.codeboss.ecommercelaravelkotlin.presentation.screens.roles.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.codeboss.ecommercelaravelkotlin.domain.model.Rol
import com.codeboss.ecommercelaravelkotlin.presentation.navigation.AppScreen

@Composable
fun RolesItem(rol: Rol, navController: NavHostController) {
    Column(
        modifier = Modifier.clickable {
            navController.navigate(route = rol.route) {
                popUpTo(route = AppScreen.Login.route) { inclusive = true }
            }
        }
    ) {
        Spacer(modifier = Modifier.width(20.dp))
        SubcomposeAsyncImage(
            modifier = Modifier.height(150.dp).width(150.dp),
            model = ImageRequest.Builder(LocalContext.current)
                .data(rol.image)
                .crossfade(true)
                .build(),
            loading = {
                CircularProgressIndicator(modifier = Modifier.requiredSize(40.dp))
            },
            contentDescription = rol.name,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = rol.name.uppercase(),
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

/*Spacer(modifier = Modifier.width(20.dp))
SubcomposeAsyncImage(
modifier = Modifier.height(150.dp).width(150.dp),
model = ImageRequest.Builder(context)
.data(rol.image)
.crossfade(true)
.build(),
loading = {
    CircularProgressIndicator(modifier = Modifier.requiredSize(40.dp))
},
contentDescription = rol.name,
contentScale = ContentScale.Crop
)
Spacer(modifier = Modifier.width(10.dp))
Text(
text = rol.name,
fontSize = 17.sp,
fontWeight = FontWeight.Bold
)*/