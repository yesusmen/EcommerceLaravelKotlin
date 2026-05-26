package com.codeboss.ecommercelaravelkotlin.presentation.screens.auth.register.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PermIdentity
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
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
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.codeboss.ecommercelaravelkotlin.R
import com.codeboss.ecommercelaravelkotlin.presentation.screens.auth.register.RegisterViewModel

@Composable
fun RegisterContent(
    navController: NavHostController,
    paddingValues: PaddingValues,
    vm: RegisterViewModel = hiltViewModel()
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
            painter = painterResource(R.drawable.banner_form),
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
            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 5.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.width(60.dp).height(60.dp),
                    painter = painterResource(R.drawable.user_form),
                    contentDescription = "logo"
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "PERFIL USUARIO",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
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
                        text = "Crear una Cuenta",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.firstName,
                        onValueChange = {text ->
                            vm.onChangeFirstName(text)
                        },
                        label = { Text("Nombre") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null
                            )
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text
                        )
                    )
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.lastName,
                        onValueChange = {text ->
                            vm.onChangeLastName(text)
                        },
                        label = { Text("Apellido") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.PermIdentity,
                                contentDescription = null
                            )
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text
                        )
                    )
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
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.phone,
                        onValueChange = {text ->
                            vm.onChangePhone(text)
                        },
                        label = { Text("Teléfono") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Phone,
                                contentDescription = null
                            )
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone
                        )
                    )
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
                                    vm.hiddenPassword = !vm.hiddenPassword
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.RemoveRedEye,
                                    contentDescription = "Eye"
                                )
                            }
                        },
                        visualTransformation = if(!vm.hiddenPassword) VisualTransformation.None else PasswordVisualTransformation()
                    )
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.confirmPassword,
                        onValueChange = {text->
                            vm.onChangeConfirmPassword(text)
                        },
                        label = { Text(text = "Confirmar Contraseña") },
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
                                    vm.hiddenConfirmPassword = !vm.hiddenConfirmPassword
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.RemoveRedEye,
                                    contentDescription = "Eye"
                                )
                            }
                        },
                        visualTransformation = if(!vm.hiddenConfirmPassword) VisualTransformation.None else PasswordVisualTransformation()
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    ElevatedButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = ShapeDefaults.ExtraSmall,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                        ),
                        onClick = { vm.register() }
                    ) {
                        Text("REGISTRATE")
                    }
                }
            }
        }
    }

}