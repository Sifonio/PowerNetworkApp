package com.example.powernetworkapp.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.powernetworkapp.DisplayFor

@Composable
fun DisplayModeSelector(selected: DisplayFor, onSelectedChange: (DisplayFor) -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(12.dp).padding(top = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Вибір режиму роботи додатку", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(12.dp))

        DisplayFor.values().forEach { mode ->
            Button(
                onClick = { onSelectedChange(mode) },
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                enabled = mode != selected
            ) {
                Text(text = when (mode) {
                    DisplayFor.BASIC_LEVEL -> "Моніторинг мережі (Базовий)"
                    DisplayFor.MIDDLE_LEVEL -> "Калькулятор втрат (Середній)"
                    DisplayFor.ADVANCED_LEVEL -> "Авторизація диспетчера (Просунутий)"
                })
            }
        }
    }
}