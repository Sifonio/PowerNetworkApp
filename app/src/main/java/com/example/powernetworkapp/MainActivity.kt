package com.example.powernetworkapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.powernetworkapp.composables.AdvancedNetworkApp
import com.example.powernetworkapp.composables.BasicNetworkApp
import com.example.powernetworkapp.composables.DisplayModeSelector
import com.example.powernetworkapp.composables.MediumNetworkApp
import com.example.powernetworkapp.ui.theme.PowerNetworkAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PowerNetworkAppTheme {
                var displayFor by remember { mutableStateOf(DisplayFor.BASIC_LEVEL) }

                Surface(modifier = Modifier.fillMaxSize()) {
                    Column {
                        DisplayModeSelector(
                            selected = displayFor,
                            onSelectedChange = { displayFor = it }
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        when (displayFor) {
                            DisplayFor.BASIC_LEVEL -> BasicNetworkApp()
                            DisplayFor.MIDDLE_LEVEL -> MediumNetworkApp()
                            DisplayFor.ADVANCED_LEVEL -> AdvancedNetworkApp()
                        }
                    }
                }
            }
        }
    }
}