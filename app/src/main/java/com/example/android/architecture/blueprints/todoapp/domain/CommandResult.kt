package com.example.android.architecture.blueprints.todoapp.domain

/**
 * Result of executing a natural language command.
 */
data class CommandResult(
    val success: Boolean,
    val message: String,
    val actionTaken: String?
)
