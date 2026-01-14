package com.example.android.architecture.blueprints.todoapp.data

import com.example.android.architecture.blueprints.todoapp.domain.CommandResult
import com.example.android.architecture.blueprints.todoapp.domain.PrivacyState
import com.example.android.architecture.blueprints.todoapp.domain.SystemContext
import com.example.android.architecture.blueprints.todoapp.domain.SystemSetting
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository for system operations.
 * Mock implementation with hardcoded data.
 */
@Singleton
class SystemRepository @Inject constructor() {
    
    private val _settings = MutableStateFlow(
        mapOf(
            "wifi" to SystemSetting("wifi", "Wi-Fi", true),
            "bluetooth" to SystemSetting("bluetooth", "Bluetooth", false),
            "display" to SystemSetting("display", "Display", true),
            "battery_saver" to SystemSetting("battery_saver", "Battery Saver", false),
            "display_brightness" to SystemSetting("display_brightness", "Display Brightness", true),
            "dnd" to SystemSetting("dnd", "Do Not Disturb", false)
        )
    )
    
    val settings: StateFlow<Map<String, SystemSetting>> = _settings
    
    suspend fun executeCommand(command: String): CommandResult {
        // Mock command parsing
        val lowerCommand = command.lowercase()
        
        return when {
            lowerCommand.contains("battery") && lowerCommand.contains("saver") -> {
                updateSetting("battery_saver", true)
                CommandResult(
                    success = true,
                    message = "Battery saver enabled",
                    actionTaken = "toggle_setting:battery_saver:true"
                )
            }
            lowerCommand.contains("brightness") && lowerCommand.contains("lower") -> {
                updateSetting("display_brightness", false)
                CommandResult(
                    success = true,
                    message = "Brightness lowered",
                    actionTaken = "toggle_setting:display_brightness:false"
                )
            }
            lowerCommand.contains("do not disturb") || lowerCommand.contains("dnd") -> {
                updateSetting("dnd", true)
                CommandResult(
                    success = true,
                    message = "Do not disturb enabled",
                    actionTaken = "toggle_setting:dnd:true"
                )
            }
            lowerCommand.contains("wifi") && (lowerCommand.contains("on") || lowerCommand.contains("enable")) -> {
                updateSetting("wifi", true)
                CommandResult(
                    success = true,
                    message = "Wi-Fi enabled",
                    actionTaken = "toggle_setting:wifi:true"
                )
            }
            lowerCommand.contains("bluetooth") && (lowerCommand.contains("on") || lowerCommand.contains("enable")) -> {
                updateSetting("bluetooth", true)
                CommandResult(
                    success = true,
                    message = "Bluetooth enabled",
                    actionTaken = "toggle_setting:bluetooth:true"
                )
            }
            else -> {
                CommandResult(
                    success = false,
                    message = "I didn't understand that command. Try: 'Turn on battery saver' or 'Lower brightness'",
                    actionTaken = null
                )
            }
        }
    }
    
    suspend fun toggleSetting(key: String, enabled: Boolean): SystemSetting {
        return updateSetting(key, enabled)
    }
    
    private fun updateSetting(key: String, enabled: Boolean): SystemSetting {
        val current = _settings.value[key]
        val updated = current?.copy(enabled = enabled) ?: SystemSetting(key, key, enabled)
        _settings.value = _settings.value.toMutableMap().apply {
            put(key, updated)
        }
        return updated
    }
    
    suspend fun getSystemContext(): SystemContext {
        return SystemContext(
            currentApp = "OpuS OS Demo",
            batteryLevel = 73,
            batteryStatus = "Charging",
            storageUsed = 45,
            storageTotal = 128
        )
    }
    
    suspend fun getPrivacyState(): PrivacyState {
        return PrivacyState(
            localProcessing = true,
            cloudProcessing = false
        )
    }
    
    fun getSetting(key: String): SystemSetting? {
        return _settings.value[key]
    }
}
