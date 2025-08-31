package com.example.kotlin_duoc.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_duoc.data.DietCategory
import com.example.kotlin_duoc.data.DietMenu
import com.example.kotlin_duoc.data.DietRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DietViewModel : ViewModel() {
    
    private val _diets = MutableStateFlow<List<DietMenu>>(emptyList())
    val diets: StateFlow<List<DietMenu>> = _diets.asStateFlow()
    
    private val _selectedDiet = MutableStateFlow<DietMenu?>(null)
    val selectedDiet: StateFlow<DietMenu?> = _selectedDiet.asStateFlow()
    
    private val _selectedCategory = MutableStateFlow<DietCategory?>(null)
    val selectedCategory: StateFlow<DietCategory?> = _selectedCategory.asStateFlow()
    
    init {
        loadAllDiets()
    }
    
    fun loadAllDiets() {
        viewModelScope.launch {
            _diets.value = DietRepository.getAllDiets()
        }
    }
    
    fun selectDiet(diet: DietMenu) {
        _selectedDiet.value = diet
    }
    
    fun filterByCategory(category: DietCategory?) {
        _selectedCategory.value = category
        viewModelScope.launch {
            if (category != null) {
                _diets.value = DietRepository.getDietsByCategory(category)
            } else {
                _diets.value = DietRepository.getAllDiets()
            }
        }
    }
    
    fun getDietById(id: Int): DietMenu? {
        return DietRepository.getDietById(id)
    }
    
    fun clearSelection() {
        _selectedDiet.value = null
    }
}
