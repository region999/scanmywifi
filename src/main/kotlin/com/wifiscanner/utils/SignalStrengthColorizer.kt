package com.wifiscanner.utils

import android.graphics.Color
import androidx.annotation.ColorInt

/**
 * Utility class for converting WiFi signal strength to color representations.
 * Follows Material Design color guidelines for visual feedback.
 */
object SignalStrengthColorizer {
    /**
     * Enum representing signal strength levels
     */
    enum class SignalLevel {
        VERY_WEAK,   // Less than -85 dBm
        WEAK,        // Between -85 and -70 dBm
        MODERATE,    // Between -70 and -55 dBm
        STRONG,      // Between -55 and -40 dBm
        VERY_STRONG  // Greater than -40 dBm
    }

    /**
     * Convert signal strength in dBm to SignalLevel
     * @param signalStrength Signal strength in dBm
     * @return SignalLevel enum representing the strength
     */
    fun getSignalLevel(signalStrength: Int): SignalLevel {
        return when {
            signalStrength <= -85 -> SignalLevel.VERY_WEAK
            signalStrength <= -70 -> SignalLevel.WEAK
            signalStrength <= -55 -> SignalLevel.MODERATE
            signalStrength <= -40 -> SignalLevel.STRONG
            else -> SignalLevel.VERY_STRONG
        }
    }

    /**
     * Get color representation for a given signal level
     * Uses Material Design color palette for clear visual feedback
     * @param level Signal strength level
     * @return Color integer for the corresponding signal strength
     */
    @ColorInt
    fun getColorForSignalLevel(level: SignalLevel): Int {
        return when (level) {
            SignalLevel.VERY_WEAK -> Color.RED       // Strong visual warning
            SignalLevel.WEAK -> Color.rgb(255, 152, 0)  // Orange warning
            SignalLevel.MODERATE -> Color.YELLOW     // Caution color
            SignalLevel.STRONG -> Color.rgb(76, 175, 80)  // Green success
            SignalLevel.VERY_STRONG -> Color.GREEN   // Bright green for excellent
        }
    }

    /**
     * Get human-readable description for signal level
     * @param level Signal strength level
     * @return Descriptive string for the signal level
     */
    fun getDescriptionForSignalLevel(level: SignalLevel): String {
        return when (level) {
            SignalLevel.VERY_WEAK -> "Very Weak Signal"
            SignalLevel.WEAK -> "Weak Signal"
            SignalLevel.MODERATE -> "Moderate Signal"
            SignalLevel.STRONG -> "Strong Signal"
            SignalLevel.VERY_STRONG -> "Excellent Signal"
        }
    }
}