package com.codeboss.ecommercelaravelkotlin.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.codeboss.ecommercelaravelkotlin.R
import com.codeboss.ecommercelaravelkotlin.presentation.navigation.screen.auth.AuthScreen
import com.codeboss.ecommercelaravelkotlin.presentation.screens.auth.login.LoginViewModel

@Composable
fun LoginContent(
    navController: NavHostController,
    paddingValues: PaddingValues,
    vm: LoginViewModel = hiltViewModel()
){
    val state = vm.state
    val context = LocalContext.current

    LaunchedEffect(vm.errorMessage) {
        if (vm.errorMessage != ""){
            Toast.makeText(context, vm.errorMessage, Toast.LENGTH_LONG).show()
            vm.errorMessage = ""
        }
    }

    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.banner),
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
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(R.drawable.shopping_cart_blue),
                contentDescription = "logo"
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "ECOMMERCE APP",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.70f),
                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.85f)
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Bienvenido",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Inicie sesión para continuar",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.email,
                        onValueChange = {text ->
                            vm.onChangeEmail(text)
                        },
                        label = { Text("Correo electrónico") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = null
                            )
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.password,
                        onValueChange = {text->
                            vm.onChangePassword(text)
                        },
                        label = { Text(text = "Contraseña") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        singleLine = true,
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = null
                            )
                        },
                        trailingIcon = {
                            IconButton(
                                onClick = {
                                    vm.hiddePassword = !vm.hiddePassword
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.RemoveRedEye,
                                    contentDescription = "Eye"
                                )
                            }
                        },
                        visualTransformation = if(!vm.hiddePassword) VisualTransformation.None else PasswordVisualTransformation()
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    ElevatedButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = ShapeDefaults.ExtraSmall,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                        ),
                        onClick = { vm.login() }
                    ) {
                        Text("INICIAR SESIÓN")
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "¿No tienes una cuenta?"
                        )
                        TextButton(
                            onClick = {
                                navController.navigate(AuthScreen.Register.route)
                            }
                        ) {
                            Text(
                                text = "Registrate",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }

}