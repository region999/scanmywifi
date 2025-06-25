package com.wifiscanner.utils

import android.graphics.Color
import org.junit.Assert.*
import org.junit.Test

class SignalStrengthColorizerTest {

    @Test
    fun `test signal level detection`() {
        // Very Weak Signal
        assertEquals(SignalStrengthColorizer.SignalLevel.VERY_WEAK, SignalStrengthColorizer.getSignalLevel(-90))
        
        // Weak Signal
        assertEquals(SignalStrengthColorizer.SignalLevel.WEAK, SignalStrengthColorizer.getSignalLevel(-80))
        
        // Moderate Signal
        assertEquals(SignalStrengthColorizer.SignalLevel.MODERATE, SignalStrengthColorizer.getSignalLevel(-65))
        
        // Strong Signal
        assertEquals(SignalStrengthColorizer.SignalLevel.STRONG, SignalStrengthColorizer.getSignalLevel(-50))
        
        // Very Strong Signal
        assertEquals(SignalStrengthColorizer.SignalLevel.VERY_STRONG, SignalStrengthColorizer.getSignalLevel(-30))
    }

    @Test
    fun `test color representation`() {
        // Very Weak Signal should be red
        assertEquals(Color.RED, SignalStrengthColorizer.getColorForSignalLevel(SignalStrengthColorizer.SignalLevel.VERY_WEAK))
        
        // Weak Signal should be orange
        assertEquals(Color.rgb(255, 152, 0), SignalStrengthColorizer.getColorForSignalLevel(SignalStrengthColorizer.SignalLevel.WEAK))
        
        // Strong Signal should be green
        assertEquals(Color.rgb(76, 175, 80), SignalStrengthColorizer.getColorForSignalLevel(SignalStrengthColorizer.SignalLevel.STRONG))
    }

    @Test
    fun `test signal level descriptions`() {
        assertEquals("Very Weak Signal", 
            SignalStrengthColorizer.getDescriptionForSignalLevel(SignalStrengthColorizer.SignalLevel.VERY_WEAK))
        
        assertEquals("Excellent Signal", 
            SignalStrengthColorizer.getDescriptionForSignalLevel(SignalStrengthColorizer.SignalLevel.VERY_STRONG))
    }
}