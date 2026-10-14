package com.example.powernetworkapp.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.powernetworkapp.forms.LoginForm
import com.example.powernetworkapp.forms.RegistrationForm

@Composable
fun AdvancedNetworkApp() {
    var isRegisterMode by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (isRegisterMode) {
            RegistrationForm(
                onRegister = { name, email, password, confirmPassword ->
                    when {
                        name.isBlank() || email.isBlank() || password.isBlank() || confirmPassword.isBlank() -> "Заповніть усі поля"
                        password != confirmPassword -> "Паролі не співпадають"
                        else -> "Реєстрація інженера успішна!"
                    }
                },
                onSwitchToLogin = { isRegisterMode = false }
            )
        } else {
            LoginForm(
                onLogin = { login, password ->
                    if (login.isBlank() || password.isBlank()) "Заповніть усі поля" else "Доступ до ЛЕП дозволено!"
                },
                onSwitchToRegister = { isRegisterMode = true }
            )
        }

        if (isLoading) {
            Spacer(modifier = Modifier.height(16.dp))
            CircularProgressIndicator()
        }
    }
}