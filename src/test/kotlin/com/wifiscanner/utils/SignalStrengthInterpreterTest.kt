package com.wifiscanner.utils

import org.junit.Test
import org.junit.Assert.*

class SignalStrengthInterpreterTest {

    @Test
    fun `test signal strength interpretation`() {
        // Test excellent signal strength
        assertEquals("Excellent (Strong)", SignalStrengthInterpreter.interpretSignalStrength(-40))
        
        // Test good signal strength
        assertEquals("Good", SignalStrengthInterpreter.interpretSignalStrength(-55))
        
        // Test fair signal strength
        assertEquals("Fair", SignalStrengthInterpreter.interpretSignalStrength(-65))
        
        // Test weak signal strength
        assertEquals("Weak", SignalStrengthInterpreter.interpretSignalStrength(-75))
        
        // Test very weak signal strength
        assertEquals("Very Weak (Poor Connection)", SignalStrengthInterpreter.interpretSignalStrength(-90))
    }

    @Test
    fun `test signal strength to percentage conversion`() {
        // Test excellent signal strength
        assertEquals(100, SignalStrengthInterpreter.signalStrengthToPercentage(-40))
        
        // Test good signal strength
        assertEquals(80, SignalStrengthInterpreter.signalStrengthToPercentage(-55))
        
        // Test fair signal strength
        assertEquals(60, SignalStrengthInterpreter.signalStrengthToPercentage(-65))
        
        // Test weak signal strength
        assertEquals(40, SignalStrengthInterpreter.signalStrengthToPercentage(-75))
        
        // Test very weak signal strength
        assertEquals(20, SignalStrengthInterpreter.signalStrengthToPercentage(-85))
        
        // Test extremely weak signal strength
        assertEquals(0, SignalStrengthInterpreter.signalStrengthToPercentage(-100))
    }
}