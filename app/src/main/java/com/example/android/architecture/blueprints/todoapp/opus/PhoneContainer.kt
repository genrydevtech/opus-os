package com.example.android.architecture.blueprints.todoapp.opus

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.android.architecture.blueprints.todoapp.domain.UIScreen
import com.example.android.architecture.blueprints.todoapp.opus.screens.ContextAwareScreen
import com.example.android.architecture.blueprints.todoapp.opus.screens.HeroScreen
import com.example.android.architecture.blueprints.todoapp.opus.screens.NaturalLanguageScreen
import com.example.android.architecture.blueprints.todoapp.opus.screens.PrivacyScreen
import com.example.android.architecture.blueprints.todoapp.opus.screens.SystemLevelScreen
import kotlinx.coroutines.delay

/**
 * Main phone container that holds all demo screens.
 * Handles scroll-based navigation between screens.
 */
@Composable
fun PhoneContainer(
    viewModel: MainViewModel = hiltViewModel()
) {
    val currentScreen by viewModel.currentScreen.collectAsStateWithLifecycle()
    var isLocked by remember { mutableStateOf(false) }
    
    // Phone frame dimensions
    val phoneWidth = 360.dp
    val phoneHeight = 780.dp
    
    // Simple swipe detection for screen changes
    var dragOffset by remember { mutableStateOf(0f) }
    
    LaunchedEffect(dragOffset) {
        if (!isLocked && kotlin.math.abs(dragOffset) > 200f) {
            val currentIndex = currentScreen.ordinal
            val targetScreen = when {
                dragOffset > 0 && currentIndex > 0 -> UIScreen.values()[currentIndex - 1]
                dragOffset < 0 && currentIndex < UIScreen.values().size - 1 -> UIScreen.values()[currentIndex + 1]
                else -> null
            }
            
            targetScreen?.let { screen ->
                isLocked = true
                viewModel.setCurrentScreen(screen)
                dragOffset = 0f
                delay(800) // Lock duration
                isLocked = false
            }
        }
    }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
        contentAlignment = Alignment.Center
    ) {
        // Phone frame
        Surface(
            modifier = Modifier
                .width(phoneWidth)
                .height(phoneHeight)
                .clip(RoundedCornerShape(24.dp)),
            color = MaterialTheme.colorScheme.surfaceContainerHighest,
            shadowElevation = 8.dp
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surface)
            ) {
                // Screen content - show current screen with swipe detection
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .pointerInput(Unit) {
                            detectVerticalDragGestures(
                                onDragEnd = {
                                    // Reset drag offset if no screen change occurred
                                    if (!isLocked) {
                                        dragOffset = 0f
                                    }
                                }
                            ) { change, dragAmount ->
                                if (!isLocked) {
                                    dragOffset += dragAmount
                                }
                            }
                        }
                ) {
                    Crossfade(
                        targetState = currentScreen,
                        animationSpec = tween(400),
                        label = "screen_transition"
                    ) { screen ->
                        when (screen) {
                            UIScreen.HERO -> HeroScreen(viewModel = viewModel)
                            UIScreen.SYSTEM_LEVEL -> SystemLevelScreen(viewModel = viewModel)
                            UIScreen.NATURAL_LANGUAGE -> NaturalLanguageScreen(viewModel = viewModel)
                            UIScreen.CONTEXT_AWARE -> ContextAwareScreen(viewModel = viewModel)
                            UIScreen.PRIVACY -> PrivacyScreen(viewModel = viewModel)
                        }
                    }
                }
            }
        }
    }
}
