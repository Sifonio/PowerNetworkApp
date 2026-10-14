package com.example.powernetworkapp.forms

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegistrationForm(
    onRegister: (String, String, String, String) -> String,
    onSwitchToLogin: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Text("Реєстрація інженера мережі", fontSize = 22.sp, modifier = Modifier.padding(bottom = 16.dp))

    OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("ПІБ") }, modifier = Modifier.fillMaxWidth())
    Spacer(modifier = Modifier.height(8.dp))

    OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Робочий Email") }, modifier = Modifier.fillMaxWidth())
    Spacer(modifier = Modifier.height(8.dp))

    OutlinedTextField(
        value = password, onValueChange = { password = it },
        label = { Text("Пароль") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(8.dp))

    OutlinedTextField(
        value = confirmPassword, onValueChange = { confirmPassword = it },
        label = { Text("Підтвердження пароля") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(16.dp))

    Button(onClick = { message = onRegister(name, email, password, confirmPassword) }, modifier = Modifier.fillMaxWidth()) {
        Text("Зареєструватися")
    }
    Spacer(modifier = Modifier.height(8.dp))

    TextButton(onClick = onSwitchToLogin) {
        Text("Вже маєте доступ? Увійти")
    }
    Spacer(modifier = Modifier.height(16.dp))

    Text(
        text = message,
        color = if (message.contains("успішна")) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
    )
}
