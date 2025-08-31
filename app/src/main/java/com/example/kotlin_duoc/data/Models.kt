package com.example.kotlin_duoc.data

data class User(
    val email: String,
    val password: String,
    val name: String = ""
)

data class DietMenu(
    val id: Int,
    val name: String,
    val description: String,
    val calories: Int,
    val meals: List<Meal>,
    val category: DietCategory
)

data class Meal(
    val name: String,
    val time: String,
    val foods: List<Food>,
    val totalCalories: Int
)

data class Food(
    val name: String,
    val quantity: String,
    val calories: Int,
    val nutrients: Nutrients
)

data class Nutrients(
    val protein: Double,
    val carbs: Double,
    val fats: Double,
    val fiber: Double
)

enum class DietCategory {
    WEIGHT_LOSS,
    MAINTENANCE,
    MUSCLE_GAIN,
    VEGETARIAN,
    LOW_CARB
}
