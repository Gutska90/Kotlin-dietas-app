package com.example.kotlin_duoc.data

object DietRepository {
    
    private val dietMenus = listOf(
        DietMenu(
            id = 1,
            name = "Dieta Mediterránea",
            description = "Dieta equilibrada basada en la cocina mediterránea",
            calories = 1800,
            category = DietCategory.MAINTENANCE,
            meals = listOf(
                Meal(
                    name = "Desayuno",
                    time = "08:00",
                    totalCalories = 400,
                    foods = listOf(
                        Food("Pan integral", "2 rebanadas", 160, Nutrients(8.0, 30.0, 2.0, 4.0)),
                        Food("Aceite de oliva", "1 cucharada", 120, Nutrients(0.0, 0.0, 14.0, 0.0)),
                        Food("Tomate", "1 unidad", 22, Nutrients(1.0, 5.0, 0.0, 1.5)),
                        Food("Café con leche", "1 taza", 98, Nutrients(6.0, 8.0, 5.0, 0.0))
                    )
                ),
                Meal(
                    name = "Almuerzo",
                    time = "13:00",
                    totalCalories = 600,
                    foods = listOf(
                        Food("Pollo a la plancha", "150g", 250, Nutrients(45.0, 0.0, 5.0, 0.0)),
                        Food("Ensalada mixta", "1 plato", 120, Nutrients(8.0, 15.0, 8.0, 6.0)),
                        Food("Arroz integral", "1/2 taza", 110, Nutrients(2.5, 22.0, 0.5, 2.0)),
                        Food("Aceite de oliva", "1 cucharada", 120, Nutrients(0.0, 0.0, 14.0, 0.0))
                    )
                ),
                Meal(
                    name = "Cena",
                    time = "20:00",
                    totalCalories = 500,
                    foods = listOf(
                        Food("Pescado blanco", "120g", 200, Nutrients(35.0, 0.0, 4.0, 0.0)),
                        Food("Verduras al vapor", "1 taza", 80, Nutrients(5.0, 15.0, 0.5, 8.0)),
                        Food("Patata pequeña", "1 unidad", 110, Nutrients(3.0, 25.0, 0.0, 2.5)),
                        Food("Yogur natural", "1 taza", 110, Nutrients(12.0, 8.0, 5.0, 0.0))
                    )
                )
            )
        ),
        
        DietMenu(
            id = 2,
            name = "Dieta Proteica",
            description = "Dieta alta en proteínas para ganancia muscular",
            calories = 2200,
            category = DietCategory.MUSCLE_GAIN,
            meals = listOf(
                Meal(
                    name = "Desayuno",
                    time = "07:00",
                    totalCalories = 500,
                    foods = listOf(
                        Food("Avena", "1 taza", 150, Nutrients(6.0, 27.0, 3.0, 4.0)),
                        Food("Proteína en polvo", "1 scoop", 120, Nutrients(25.0, 3.0, 1.0, 0.0)),
                        Food("Plátano", "1 unidad", 105, Nutrients(1.3, 27.0, 0.4, 3.1)),
                        Food("Leche descremada", "1 taza", 125, Nutrients(8.0, 12.0, 5.0, 0.0))
                    )
                ),
                Meal(
                    name = "Almuerzo",
                    time = "12:30",
                    totalCalories = 700,
                    foods = listOf(
                        Food("Carne de res magra", "200g", 350, Nutrients(60.0, 0.0, 12.0, 0.0)),
                        Food("Quinoa", "1 taza", 222, Nutrients(8.0, 39.0, 4.0, 5.0)),
                        Food("Brócoli", "1 taza", 55, Nutrients(3.7, 11.0, 0.6, 5.2)),
                        Food("Aceite de oliva", "1 cucharada", 120, Nutrients(0.0, 0.0, 14.0, 0.0))
                    )
                ),
                Meal(
                    name = "Cena",
                    time = "19:30",
                    totalCalories = 600,
                    foods = listOf(
                        Food("Salmón", "150g", 280, Nutrients(45.0, 0.0, 12.0, 0.0)),
                        Food("Batata", "1 unidad mediana", 130, Nutrients(2.0, 30.0, 0.0, 4.0)),
                        Food("Espinacas", "1 taza", 41, Nutrients(5.0, 6.0, 0.5, 4.0)),
                        Food("Claras de huevo", "4 unidades", 149, Nutrients(32.0, 2.0, 0.0, 0.0))
                    )
                )
            )
        ),
        
        DietMenu(
            id = 3,
            name = "Dieta Vegetariana",
            description = "Dieta completa sin productos animales",
            calories = 1600,
            category = DietCategory.VEGETARIAN,
            meals = listOf(
                Meal(
                    name = "Desayuno",
                    time = "08:30",
                    totalCalories = 350,
                    foods = listOf(
                        Food("Tofu", "100g", 144, Nutrients(16.0, 3.0, 8.0, 0.0)),
                        Food("Pan integral", "2 rebanadas", 160, Nutrients(8.0, 30.0, 2.0, 4.0)),
                        Food("Aguacate", "1/4 unidad", 46, Nutrients(0.5, 2.0, 4.5, 2.0))
                    )
                ),
                Meal(
                    name = "Almuerzo",
                    time = "13:30",
                    totalCalories = 550,
                    foods = listOf(
                        Food("Lentejas", "1 taza", 230, Nutrients(18.0, 40.0, 0.8, 16.0)),
                        Food("Arroz integral", "1/2 taza", 110, Nutrients(2.5, 22.0, 0.5, 2.0)),
                        Food("Zanahorias", "1 taza", 52, Nutrients(1.2, 12.0, 0.3, 3.6)),
                        Food("Aceite de oliva", "1 cucharada", 120, Nutrients(0.0, 0.0, 14.0, 0.0)),
                        Food("Nueces", "30g", 38, Nutrients(8.0, 2.0, 18.0, 2.0))
                    )
                ),
                Meal(
                    name = "Cena",
                    time = "20:30",
                    totalCalories = 400,
                    foods = listOf(
                        Food("Garbanzos", "1 taza", 269, Nutrients(14.5, 45.0, 4.0, 12.5)),
                        Food("Espinacas", "1 taza", 41, Nutrients(5.0, 6.0, 0.5, 4.0)),
                        Food("Tomate", "1 unidad", 22, Nutrients(1.0, 5.0, 0.0, 1.5)),
                        Food("Aceite de oliva", "1 cucharada", 68, Nutrients(0.0, 0.0, 8.0, 0.0))
                    )
                )
            )
        ),
        
        DietMenu(
            id = 4,
            name = "Dieta Baja en Carbohidratos",
            description = "Dieta cetogénica para pérdida de peso",
            calories = 1400,
            category = DietCategory.LOW_CARB,
            meals = listOf(
                Meal(
                    name = "Desayuno",
                    time = "08:00",
                    totalCalories = 400,
                    foods = listOf(
                        Food("Huevos", "3 unidades", 210, Nutrients(18.0, 1.5, 15.0, 0.0)),
                        Food("Aguacate", "1/2 unidad", 120, Nutrients(1.0, 6.0, 11.0, 5.0)),
                        Food("Queso cottage", "1/2 taza", 70, Nutrients(12.0, 3.0, 2.0, 0.0))
                    )
                ),
                Meal(
                    name = "Almuerzo",
                    time = "13:00",
                    totalCalories = 500,
                    foods = listOf(
                        Food("Pollo a la plancha", "150g", 250, Nutrients(45.0, 0.0, 5.0, 0.0)),
                        Food("Ensalada verde", "2 tazas", 50, Nutrients(5.0, 8.0, 0.5, 4.0)),
                        Food("Aceite de oliva", "2 cucharadas", 240, Nutrients(0.0, 0.0, 28.0, 0.0))
                    )
                ),
                Meal(
                    name = "Cena",
                    time = "19:00",
                    totalCalories = 500,
                    foods = listOf(
                        Food("Salmón", "120g", 224, Nutrients(36.0, 0.0, 8.0, 0.0)),
                        Food("Espárragos", "1 taza", 27, Nutrients(3.0, 5.0, 0.2, 2.8)),
                        Food("Mantequilla", "1 cucharada", 102, Nutrients(0.1, 0.0, 11.5, 0.0)),
                        Food("Queso parmesano", "30g", 129, Nutrients(12.0, 1.0, 9.0, 0.0))
                    )
                )
            )
        ),
        
        DietMenu(
            id = 5,
            name = "Dieta de Pérdida de Peso",
            description = "Dieta hipocalórica para reducir peso",
            calories = 1200,
            category = DietCategory.WEIGHT_LOSS,
            meals = listOf(
                Meal(
                    name = "Desayuno",
                    time = "08:00",
                    totalCalories = 300,
                    foods = listOf(
                        Food("Avena", "1/2 taza", 75, Nutrients(3.0, 13.5, 1.5, 2.0)),
                        Food("Leche descremada", "1 taza", 125, Nutrients(8.0, 12.0, 5.0, 0.0)),
                        Food("Fresas", "1/2 taza", 25, Nutrients(0.5, 6.0, 0.2, 1.5)),
                        Food("Yogur griego", "1/4 taza", 75, Nutrients(8.0, 3.0, 4.0, 0.0))
                    )
                ),
                Meal(
                    name = "Almuerzo",
                    time = "13:00",
                    totalCalories = 400,
                    foods = listOf(
                        Food("Pechuga de pollo", "100g", 165, Nutrients(31.0, 0.0, 3.6, 0.0)),
                        Food("Ensalada mixta", "2 tazas", 80, Nutrients(6.0, 12.0, 4.0, 6.0)),
                        Food("Vinagreta light", "1 cucharada", 45, Nutrients(0.0, 1.0, 4.0, 0.0)),
                        Food("Manzana", "1 unidad", 95, Nutrients(0.5, 25.0, 0.3, 4.4))
                    )
                ),
                Meal(
                    name = "Cena",
                    time = "19:00",
                    totalCalories = 500,
                    foods = listOf(
                        Food("Pescado blanco", "120g", 160, Nutrients(28.0, 0.0, 3.0, 0.0)),
                        Food("Verduras al vapor", "1 taza", 80, Nutrients(5.0, 15.0, 0.5, 8.0)),
                        Food("Arroz integral", "1/4 taza", 55, Nutrients(1.2, 11.0, 0.2, 1.0)),
                        Food("Aceite de oliva", "1 cucharada", 120, Nutrients(0.0, 0.0, 14.0, 0.0)),
                        Food("Yogur natural", "1/2 taza", 85, Nutrients(6.0, 4.0, 2.5, 0.0))
                    )
                )
            )
        )
    )
    
    fun getAllDiets(): List<DietMenu> = dietMenus
    
    fun getDietById(id: Int): DietMenu? = dietMenus.find { it.id == id }
    
    fun getDietsByCategory(category: DietCategory): List<DietMenu> = 
        dietMenus.filter { it.category == category }
}
