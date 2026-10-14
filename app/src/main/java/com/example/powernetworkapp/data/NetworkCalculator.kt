package com.example.powernetworkapp.data

class NetworkCalculator {
    // Обчислює втрати потужності (P = I^2 * R) і переводить у кВт
    fun calculateLosses(currentStr: String, resistanceStr: String): Double {
        val current = currentStr.toDoubleOrNull() ?: 0.0
        val resistance = resistanceStr.toDoubleOrNull() ?: 0.0

        val lossesWatts = (current * current) * resistance
        return lossesWatts / 1000.0 // Переведення у кВт
    }
}

