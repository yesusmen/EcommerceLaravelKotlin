package com.codeboss.ecommercelaravelkotlin.presentation.screens.profile.components

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.codeboss.ecommercelaravelkotlin.R
import com.codeboss.ecommercelaravelkotlin.presentation.MainActivity
import com.codeboss.ecommercelaravelkotlin.presentation.screens.profile.ProfileViewModel

@SuppressLint("ContextCastToActivity")
@Composable
fun ProfileContent(
    vm: ProfileViewModel = hiltViewModel(),
    //paddingValues: PaddingValues,
){
    val activity = LocalContext.current as? Activity

    Box(
        modifier = Modifier

            .fillMaxSize()
    ){
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.profile_background),
            contentDescription = "Image Background",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix().apply {
                    setToScale(0.5f, 0.5f, 0.5f, 1f)
                }
            )
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            IconButton(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 15.dp, top = 15.dp),
                onClick = {
                    vm.logout()
                    activity?.finish()
                    activity?.startActivity(Intent(activity, MainActivity::class.java))
                }
            ) {
                Icon(
                    modifier = Modifier.size(35.dp),
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "icon exit",
                    tint = Color.White
                )
            }
            if (!vm.user?.image.isNullOrBlank()){
                AsyncImage(
                    model = vm.user?.image,
                    contentDescription = "image profile",
                    contentScale = ContentScale.Crop
                )
            }
            else {
                Image(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally),
                    painter = painterResource(R.drawable.user_image),
                    contentDescription = "icon user"
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.7f)
                )
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Person, contentDescription = "")
                        Column {
                            Text(text = "${vm.user?.firstName ?: ""} ${vm.user?.lastName ?: ""}")
                            Text(text = "Nombre de usuario", fontSize = 12.sp, color = Color.Gray)
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Email, contentDescription = "")
                        Column {
                            Text(text = vm.user?.email ?: "usuario@usuario.com")
                            Text(text = "Correo electrónico", fontSize = 12.sp, color = Color.Gray)

                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Phone, contentDescription = "")
                        Column {
                            Text(text = vm.user?.phone ?: "58 412 1605552")
                            Text(text = "Teléfono", fontSize = 12.sp, color = Color.Gray)

                        }
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    ElevatedButton(
                        modifier = Modifier.fillMaxWidth(),
                        shape = ShapeDefaults.ExtraSmall,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                        ),
                        onClick = {}
                    ) {
                        Text(
                            text = "Actualizar información"
                        )
                    }
                }
            }
        }
    }
}


/*@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewProfile(){
        ProfileContent()
   *//* EcommerceLaravelKotlinTheme() {
    }*//*
}*/
