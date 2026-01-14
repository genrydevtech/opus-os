package com.example.android.architecture.blueprints.todoapp.domain.usecase

import com.example.android.architecture.blueprints.todoapp.domain.UIScreen
import javax.inject.Inject

/**
 * Use case for getting UI script/flow information.
 * In a real implementation, this would drive the demo flow.
 */
class GetUIScriptUseCase @Inject constructor() {
    suspend operator fun invoke(screen: UIScreen): String {
        // Mock implementation - return script description
        return when (screen) {
            UIScreen.HERO -> "Welcome to OpuS OS"
            UIScreen.SYSTEM_LEVEL -> "System-level Claude Opus integration"
            UIScreen.NATURAL_LANGUAGE -> "Natural language OS control"
            UIScreen.CONTEXT_AWARE -> "Full system context awareness"
            UIScreen.PRIVACY -> "Privacy-first architecture"
        }
    }
}
