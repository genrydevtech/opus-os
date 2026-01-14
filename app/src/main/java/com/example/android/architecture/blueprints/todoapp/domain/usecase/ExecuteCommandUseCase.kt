package com.example.android.architecture.blueprints.todoapp.domain.usecase

import com.example.android.architecture.blueprints.todoapp.domain.CommandResult
import javax.inject.Inject

/**
 * Use case for executing natural language commands.
 */
class ExecuteCommandUseCase @Inject constructor() {
    suspend operator fun invoke(command: String): CommandResult {
        // Mock implementation - parse command and return result
        val lowerCommand = command.lowercase()
        
        return when {
            lowerCommand.contains("battery") && lowerCommand.contains("saver") -> {
                CommandResult(
                    success = true,
                    message = "Battery saver enabled",
                    actionTaken = "toggle_setting:battery_saver:true"
                )
            }
            lowerCommand.contains("brightness") && lowerCommand.contains("lower") -> {
                CommandResult(
                    success = true,
                    message = "Brightness lowered",
                    actionTaken = "toggle_setting:display_brightness:false"
                )
            }
            lowerCommand.contains("do not disturb") || lowerCommand.contains("dnd") -> {
                CommandResult(
                    success = true,
                    message = "Do not disturb enabled",
                    actionTaken = "toggle_setting:dnd:true"
                )
            }
            lowerCommand.contains("wifi") && (lowerCommand.contains("on") || lowerCommand.contains("enable")) -> {
                CommandResult(
                    success = true,
                    message = "Wi-Fi enabled",
                    actionTaken = "toggle_setting:wifi:true"
                )
            }
            lowerCommand.contains("bluetooth") && (lowerCommand.contains("on") || lowerCommand.contains("enable")) -> {
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
}
