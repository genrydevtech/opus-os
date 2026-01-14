package com.example.android.architecture.blueprints.todoapp.domain.usecase

import com.example.android.architecture.blueprints.todoapp.domain.SystemContext
import javax.inject.Inject

/**
 * Use case for getting current system context.
 */
class GetSystemContextUseCase @Inject constructor() {
    suspend operator fun invoke(): SystemContext {
        // Mock implementation - return hardcoded context
        return SystemContext(
            currentApp = "OpuS OS Demo",
            batteryLevel = 73,
            batteryStatus = "Charging",
            storageUsed = 45,
            storageTotal = 128
        )
    }
}
