package com.example.kotlin_duoc.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_duoc.data.DietMenu
import com.example.kotlin_duoc.ui.screens.DietDetailScreen
import com.example.kotlin_duoc.ui.screens.DietListScreen
import com.example.kotlin_duoc.ui.screens.ForgotPasswordScreen
import com.example.kotlin_duoc.ui.screens.LoginScreen
import com.example.kotlin_duoc.ui.screens.RegisterScreen
import com.example.kotlin_duoc.viewmodel.AuthViewModel
import com.example.kotlin_duoc.viewmodel.DietViewModel

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object ForgotPassword : Screen("forgot_password")
    object DietList : Screen("diet_list")
    object DietDetail : Screen("diet_detail/{dietId}") {
        fun createRoute(dietId: Int) = "diet_detail/$dietId"
    }
}

@Composable
fun AppNavigation(
    authViewModel: AuthViewModel,
    dietViewModel: DietViewModel,
    navController: NavHostController = rememberNavController()
) {
    val isLoggedIn by authViewModel.isLoggedIn.collectAsState()
    
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(
                authViewModel = authViewModel,
                onNavigateToRegister = {
                    navController.navigate(Screen.Register.route)
                },
                onNavigateToForgotPassword = {
                    navController.navigate(Screen.ForgotPassword.route)
                },
                onLoginSuccess = {
                    navController.navigate(Screen.DietList.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                }
            )
        }
        
        composable(Screen.Register.route) {
            RegisterScreen(
                authViewModel = authViewModel,
                onNavigateToLogin = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Register.route) { inclusive = true }
                    }
                },
                onRegisterSuccess = {
                    navController.navigate(Screen.DietList.route) {
                        popUpTo(Screen.Register.route) { inclusive = true }
                    }
                }
            )
        }
        
        composable(Screen.ForgotPassword.route) {
            ForgotPasswordScreen(
                authViewModel = authViewModel,
                onNavigateToLogin = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.ForgotPassword.route) { inclusive = true }
                    }
                }
            )
        }
        
        composable(Screen.DietList.route) {
            DietListScreen(
                dietViewModel = dietViewModel,
                authViewModel = authViewModel,
                onDietSelected = { diet ->
                    navController.navigate(Screen.DietDetail.createRoute(diet.id))
                },
                onLogout = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }
        
        composable(Screen.DietDetail.route) { backStackEntry ->
            // Recupera dietId y muestra DietDetailScreen solo si es válido
            val dietId = backStackEntry.arguments?.getString("dietId") ?: return@composable
            val diet = dietViewModel.getDietById(dietId.toIntOrNull() ?: return@composable)
            
            if (diet != null) {
                DietDetailScreen(
                    diet = diet,
                    onBackPressed = {
                        navController.popBackStack()
                    }
                )
            } else {
                // Mostrar pantalla de error si no se encuentra la dieta
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Dieta no encontrada",
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.error
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Button(
                        onClick = { navController.popBackStack() }
                    ) {
                        Text("Volver")
                    }
                }
            }
        }
    }
}
