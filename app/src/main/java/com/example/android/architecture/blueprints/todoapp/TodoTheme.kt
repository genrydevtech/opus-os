package com.example.android.architecture.blueprints.todoapp

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * OpuS OS theme - Dark background with Android green + Opus orange accents.
 */
@Composable
fun TodoTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = Color(0xFF4CAF50), // Android green
            onPrimary = Color(0xFF000000),
            primaryContainer = Color(0xFF2E7D32),
            onPrimaryContainer = Color(0xFFFFFFFF),
            secondary = Color(0xFFFF9800), // Opus orange
            onSecondary = Color(0xFF000000),
            secondaryContainer = Color(0xFFE65100),
            onSecondaryContainer = Color(0xFFFFFFFF),
            tertiary = Color(0xFF9E9E9E),
            onTertiary = Color(0xFF000000),
            tertiaryContainer = Color(0xFF616161),
            onTertiaryContainer = Color(0xFFFFFFFF),
            error = Color(0xFFB00020),
            onError = Color(0xFFFFFFFF),
            errorContainer = Color(0xFF690005),
            onErrorContainer = Color(0xFFFFDAD6),
            background = Color(0xFF121212), // Dark background
            onBackground = Color(0xFFE0E0E0),
            surface = Color(0xFF1E1E1E),
            onSurface = Color(0xFFE0E0E0),
            surfaceContainerHighest = Color(0xFF2C2C2C),
            surfaceContainerHigh = Color(0xFF252525),
            surfaceContainer = Color(0xFF1F1F1F),
            surfaceContainerLow = Color(0xFF1A1A1A),
            surfaceContainerLowest = Color(0xFF121212),
            outline = Color(0xFF424242),
            outlineVariant = Color(0xFF616161),
            scrim = Color(0xFF000000),
            inverseSurface = Color(0xFFE0E0E0),
            inverseOnSurface = Color(0xFF121212),
            inversePrimary = Color(0xFF4CAF50),
        )
    ) {
        content()
    }
}
