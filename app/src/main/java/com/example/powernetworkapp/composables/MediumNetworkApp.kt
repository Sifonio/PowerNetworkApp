package com.example.powernetworkapp.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.powernetworkapp.data.NetworkCalculator

@Composable
fun MediumNetworkApp() {
    var current by remember { mutableStateOf("") }
    var resistance by remember { mutableStateOf("") }
    var result by remember { mutableStateOf(0.0) }

    val calculator = NetworkCalculator()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Розрахунок втрат потужності в ЛЕП", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(
            value = current,
            onValueChange = { current = it },
            label = { Text("Струм у лінії (А)") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = resistance,
            onValueChange = { resistance = it },
            label = { Text("Опір лінії (Ом)") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { result = calculator.calculateLosses(current, resistance) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Розрахувати втрати")
        }

        Text(
            text = "Втрати потужності: $result кВт",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}