package com.example.android.architecture.blueprints.todoapp.domain.usecase

import com.example.android.architecture.blueprints.todoapp.domain.PrivacyState
import javax.inject.Inject

/**
 * Use case for getting privacy state.
 */
class GetPrivacyStateUseCase @Inject constructor() {
    suspend operator fun invoke(): PrivacyState {
        // Mock implementation - return hardcoded privacy state
        return PrivacyState(
            localProcessing = true,
            cloudProcessing = false
        )
    }
}
