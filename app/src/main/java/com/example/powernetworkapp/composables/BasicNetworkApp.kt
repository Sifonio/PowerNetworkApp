package com.example.powernetworkapp.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.powernetworkapp.R

@Composable
fun BasicNetworkApp() {
    var load by remember { mutableStateOf(150) }
    var status by remember { mutableStateOf("Норма") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Мережа передачі електроенергії", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { status = "Норма"; load = 150 }) { Text("Штатний") }
            Button(onClick = { status = "Пік"; load = 850 }) { Text("Піковий") }
            Button(onClick = { status = "Аварія"; load = 0 }) { Text("Аварійний") }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Переконайтеся, що у вас є файл power_line.jpg у папці res/drawable
        // Якщо його ще немає, можете тимчасово закоментувати наступні 6 рядків
        /*Image(
            painter = painterResource(id = R.drawable.power_line),
            contentDescription = "Лінія електропередач",
            modifier = Modifier.height(180.dp).fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))*/

        Text("Статус мережі: $status", fontSize = 18.sp)
        Text("Поточне навантаження: $load МВт", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
    }
}