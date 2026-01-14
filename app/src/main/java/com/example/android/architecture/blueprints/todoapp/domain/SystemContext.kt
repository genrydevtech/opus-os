package com.example.android.architecture.blueprints.todoapp.domain

/**
 * System context information.
 */
data class SystemContext(
    val currentApp: String,
    val batteryLevel: Int,
    val batteryStatus: String,
    val storageUsed: Int,
    val storageTotal: Int
)
