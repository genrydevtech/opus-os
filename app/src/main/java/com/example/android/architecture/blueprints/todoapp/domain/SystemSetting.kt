package com.example.android.architecture.blueprints.todoapp.domain

/**
 * System setting model.
 */
data class SystemSetting(
    val key: String,
    val label: String,
    val enabled: Boolean
)
