package com.example.kotlin_duoc.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.kotlin_duoc.data.DietCategory
import com.example.kotlin_duoc.data.DietMenu
import com.example.kotlin_duoc.viewmodel.AuthViewModel
import com.example.kotlin_duoc.viewmodel.DietViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DietListScreen(
    dietViewModel: DietViewModel,
    authViewModel: AuthViewModel,
    onDietSelected: (DietMenu) -> Unit,
    onLogout: () -> Unit
) {
    val diets by dietViewModel.diets.collectAsState()
    val selectedCategory by dietViewModel.selectedCategory.collectAsState()
    var showFilterDialog by remember { mutableStateOf(false) }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dietas Sugeridas") },
                actions = {
                    IconButton(onClick = { showFilterDialog = true }) {
                        Icon(Icons.Default.Search, contentDescription = "Filtrar")
                    }
                    IconButton(onClick = { 
                        authViewModel.logout()
                        onLogout()
                    }) {
                        Icon(Icons.Default.ExitToApp, contentDescription = "Cerrar Sesión")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Text(
                    text = "Encuentra tu dieta ideal",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Selecciona una dieta que se adapte a tus objetivos",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            
            items(items = diets ?: emptyList()) { diet ->
                DietCard(
                    diet = diet,
                    onClick = { onDietSelected(diet) }
                )
            }
        }
    }
    
    if (showFilterDialog) {
        FilterDialog(
            selectedCategory = selectedCategory,
            onCategorySelected = { category ->
                dietViewModel.filterByCategory(category)
                showFilterDialog = false
            },
            onDismiss = { showFilterDialog = false }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DietCard(
    diet: DietMenu,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = diet.name,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                AssistChip(
                    onClick = { },
                    label = {
                        Text(
                            text = "${diet.calories} cal",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                )
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = diet.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "3 comidas diarias",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                
                AssistChip(
                    onClick = { },
                    label = {
                        Text(
                            text = when (diet.category) {
                                DietCategory.WEIGHT_LOSS -> "Pérdida"
                                DietCategory.MUSCLE_GAIN -> "Muscular"
                                DietCategory.MAINTENANCE -> "Mantenimiento"
                                DietCategory.VEGETARIAN -> "Vegetariana"
                                DietCategory.LOW_CARB -> "Baja Carb"
                            },
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun FilterDialog(
    selectedCategory: DietCategory?,
    onCategorySelected: (DietCategory?) -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Filtrar por Categoría") },
        text = {
            Column {
                FilterOption(
                    text = "Todas las dietas",
                    selected = selectedCategory == null,
                    onClick = { onCategorySelected(null) }
                )
                DietCategory.values().forEach { category ->
                    FilterOption(
                        text = when (category) {
                            DietCategory.WEIGHT_LOSS -> "Pérdida de Peso"
                            DietCategory.MUSCLE_GAIN -> "Ganancia Muscular"
                            DietCategory.MAINTENANCE -> "Mantenimiento"
                            DietCategory.VEGETARIAN -> "Vegetariana"
                            DietCategory.LOW_CARB -> "Baja en Carbohidratos"
                        },
                        selected = selectedCategory == category,
                        onClick = { onCategorySelected(category) }
                    )
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Cerrar")
            }
        }
    )
}

@Composable
fun FilterOption(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}
