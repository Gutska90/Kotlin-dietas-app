package com.example.kotlin_duoc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.kotlin_duoc.navigation.AppNavigation
import com.example.kotlin_duoc.ui.theme.Kotlin_duocTheme
import com.example.kotlin_duoc.viewmodel.AuthViewModel
import com.example.kotlin_duoc.viewmodel.DietViewModel

class MainActivity : ComponentActivity() {

    private val authViewModel: AuthViewModel by viewModels()
    private val dietViewModel: DietViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Kotlin_duocTheme(darkTheme = false, dynamicColor = false) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // 🔑 Renderiza el grafo de navegación (pantallas reales)
                    AppNavigation(
                        authViewModel = authViewModel,
                        dietViewModel = dietViewModel
                    )
                }
            }
        }
    }
}