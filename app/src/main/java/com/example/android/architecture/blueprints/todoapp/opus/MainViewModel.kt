package com.example.android.architecture.blueprints.todoapp.opus

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.architecture.blueprints.todoapp.data.SystemRepository
import com.example.android.architecture.blueprints.todoapp.domain.CommandResult
import com.example.android.architecture.blueprints.todoapp.domain.OpusState
import com.example.android.architecture.blueprints.todoapp.domain.PrivacyState
import com.example.android.architecture.blueprints.todoapp.domain.SystemContext
import com.example.android.architecture.blueprints.todoapp.domain.SystemSetting
import com.example.android.architecture.blueprints.todoapp.domain.UIScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Main ViewModel for OpuS OS demo.
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val systemRepository: SystemRepository
) : ViewModel() {
    
    private val _currentScreen = MutableStateFlow<UIScreen>(UIScreen.HERO)
    val currentScreen: StateFlow<UIScreen> = _currentScreen.asStateFlow()
    
    private val _opusState = MutableStateFlow<OpusState>(OpusState.IDLE)
    val opusState: StateFlow<OpusState> = _opusState.asStateFlow()
    
    private val _commandResult = MutableStateFlow<CommandResult?>(null)
    val commandResult: StateFlow<CommandResult?> = _commandResult.asStateFlow()
    
    private val _systemContext = MutableStateFlow<SystemContext?>(null)
    val systemContext: StateFlow<SystemContext?> = _systemContext.asStateFlow()
    
    private val _privacyState = MutableStateFlow<PrivacyState?>(null)
    val privacyState: StateFlow<PrivacyState?> = _privacyState.asStateFlow()
    
    val settings = systemRepository.settings
    
    init {
        viewModelScope.launch {
            loadSystemContext()
            loadPrivacyState()
        }
    }
    
    fun setCurrentScreen(screen: UIScreen) {
        _currentScreen.value = screen
        
        // Load relevant data when switching screens
        viewModelScope.launch {
            when (screen) {
                UIScreen.CONTEXT_AWARE -> loadSystemContext()
                UIScreen.PRIVACY -> loadPrivacyState()
                else -> {}
            }
        }
    }
    
    fun askOpus() {
        viewModelScope.launch {
            _opusState.value = OpusState.LISTENING
            delay(800)
            _opusState.value = OpusState.THINKING
            delay(1200)
            _opusState.value = OpusState.RESPONDING
            delay(1000)
            _opusState.value = OpusState.IDLE
        }
    }
    
    fun executeCommand(command: String) {
        viewModelScope.launch {
            _opusState.value = OpusState.THINKING
            delay(800)
            
            val result = systemRepository.executeCommand(command)
            _commandResult.value = result
            
            _opusState.value = OpusState.RESPONDING
            delay(1000)
            _opusState.value = OpusState.IDLE
        }
    }
    
    fun toggleSetting(key: String, enabled: Boolean) {
        viewModelScope.launch {
            systemRepository.toggleSetting(key, enabled)
        }
    }
    
    fun clearCommandResult() {
        _commandResult.value = null
    }
    
    private suspend fun loadSystemContext() {
        _systemContext.value = systemRepository.getSystemContext()
    }
    
    private suspend fun loadPrivacyState() {
        _privacyState.value = systemRepository.getPrivacyState()
    }
}
