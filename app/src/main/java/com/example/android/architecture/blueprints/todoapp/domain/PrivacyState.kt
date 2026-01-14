package com.example.android.architecture.blueprints.todoapp.domain

/**
 * Privacy control state.
 */
data class PrivacyState(
    val localProcessing: Boolean,
    val cloudProcessing: Boolean
)
