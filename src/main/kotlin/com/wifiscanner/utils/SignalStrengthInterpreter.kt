package com.wifiscanner.utils

/**
 * Provides interpretations of WiFi signal strength levels.
 * Converts raw signal strength (RSSI) to human-readable descriptions.
 */
object SignalStrengthInterpreter {
    /**
     * Converts signal strength in dBm to a descriptive text level.
     * 
     * @param signalStrength Signal strength in dBm (typically negative values)
     * @return A human-readable description of the signal strength
     */
    fun interpretSignalStrength(signalStrength: Int): String {
        return when {
            signalStrength >= -50 -> "Excellent (Strong)"
            signalStrength >= -60 -> "Good"
            signalStrength >= -70 -> "Fair"
            signalStrength >= -80 -> "Weak"
            else -> "Very Weak (Poor Connection)"
        }
    }

    /**
     * Converts signal strength to an integer percentage representation.
     * 
     * @param signalStrength Signal strength in dBm
     * @return Signal strength as a percentage (0-100)
     */
    fun signalStrengthToPercentage(signalStrength: Int): Int {
        return when {
            signalStrength >= -50 -> 100
            signalStrength >= -60 -> 80
            signalStrength >= -70 -> 60
            signalStrength >= -80 -> 40
            signalStrength >= -90 -> 20
            else -> 0
        }
    }
}