package com.example.kotlin_duoc.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_duoc.data.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    
    private val _authState = MutableStateFlow<AuthState>(AuthState.Initial)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()
    
    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn.asStateFlow()
    
    // Simulación de base de datos de usuarios
    private val users = mutableListOf(
        User("admin@dietas.com", "admin123", "Administrador"),
        User("usuario@dietas.com", "user123", "Usuario"),
        User("test@dietas.com", "test123", "Test")
    )
    
    fun login(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            
            // Simular delay de red
            kotlinx.coroutines.delay(1000)
            
            val user = users.find { it.email == email && it.password == password }
            
            if (user != null) {
                _authState.value = AuthState.Success(user)
                _isLoggedIn.value = true
            } else {
                _authState.value = AuthState.Error("Credenciales incorrectas")
            }
        }
    }
    
    fun register(email: String, password: String, name: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            
            // Simular delay de red
            kotlinx.coroutines.delay(1000)
            
            // Verificar si el usuario ya existe
            if (users.any { it.email == email }) {
                _authState.value = AuthState.Error("El email ya está registrado")
                return@launch
            }
            
            // Verificar que la contraseña tenga al menos 6 caracteres
            if (password.length < 6) {
                _authState.value = AuthState.Error("La contraseña debe tener al menos 6 caracteres")
                return@launch
            }
            
            val newUser = User(email, password, name)
            users.add(newUser)
            _authState.value = AuthState.Success(newUser)
            _isLoggedIn.value = true
        }
    }
    
    fun resetPassword(email: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            
            // Simular delay de red
            kotlinx.coroutines.delay(1000)
            
            val user = users.find { it.email == email }
            
            if (user != null) {
                _authState.value = AuthState.PasswordReset("Se ha enviado un enlace de recuperación a tu email")
            } else {
                _authState.value = AuthState.Error("Email no encontrado")
            }
        }
    }
    
    fun logout() {
        _isLoggedIn.value = false
        _authState.value = AuthState.Initial
    }
    
    fun clearError() {
        _authState.value = AuthState.Initial
    }
}

sealed class AuthState {
    object Initial : AuthState()
    object Loading : AuthState()
    data class Success(val user: User) : AuthState()
    data class Error(val message: String) : AuthState()
    data class PasswordReset(val message: String) : AuthState()
}
