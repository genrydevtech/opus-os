package com.example.android.architecture.blueprints.todoapp.domain.usecase

import com.example.android.architecture.blueprints.todoapp.domain.SystemSetting
import javax.inject.Inject

/**
 * Use case for toggling system settings.
 */
class ToggleSettingUseCase @Inject constructor() {
    suspend operator fun invoke(settingKey: String, enabled: Boolean): SystemSetting {
        // Mock implementation - return updated setting
        val label = when (settingKey) {
            "wifi" -> "Wi-Fi"
            "bluetooth" -> "Bluetooth"
            "display" -> "Display"
            "battery_saver" -> "Battery Saver"
            "display_brightness" -> "Display Brightness"
            "dnd" -> "Do Not Disturb"
            else -> settingKey.replace("_", " ").replaceFirstChar { it.uppercase() }
        }
        
        return SystemSetting(
            key = settingKey,
            label = label,
            enabled = enabled
        )
    }
}
