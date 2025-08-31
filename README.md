# Dietas Sugeridas - App Android

Una aplicación de dietas sugeridas desarrollada en Kotlin con Jetpack Compose que ofrece 5 menús distintos de dietas para diferentes objetivos nutricionales.

## Características

### 🔐 Autenticación
- **Inicio de sesión**: Sistema de login con email y contraseña
- **Registro**: Creación de nuevas cuentas de usuario
- **Recuperación de contraseña**: Sistema para recuperar contraseñas olvidadas

### 🍽️ Dietas Disponibles
La aplicación incluye 5 dietas diferentes:

1. **Dieta Mediterránea** (1,800 cal) - Mantenimiento
   - Desayuno, almuerzo y cena equilibrados
   - Basada en la cocina mediterránea tradicional

2. **Dieta Proteica** (2,200 cal) - Ganancia Muscular
   - Alto contenido en proteínas
   - Ideal para desarrollo muscular

3. **Dieta Vegetariana** (1,600 cal) - Vegetariana
   - Sin productos animales
   - Nutricionalmente completa

4. **Dieta Baja en Carbohidratos** (1,400 cal) - Baja Carb
   - Enfoque cetogénico
   - Para pérdida de peso

5. **Dieta de Pérdida de Peso** (1,200 cal) - Pérdida
   - Hipocalórica
   - Diseñada para reducir peso

### 📱 Funcionalidades
- **Filtrado por categoría**: Filtra dietas por objetivo
- **Detalles completos**: Información nutricional detallada
- **Interfaz minimalista**: Diseño limpio y fácil de usar
- **Navegación intuitiva**: Flujo de navegación claro

## Tecnologías Utilizadas

- **Kotlin**: Lenguaje de programación principal
- **Jetpack Compose**: UI moderna declarativa
- **Navigation Compose**: Navegación entre pantallas
- **ViewModel**: Gestión de estado de la UI
- **Material Design 3**: Sistema de diseño moderno

## Instalación y Uso

### Requisitos
- Android Studio Arctic Fox o superior
- Android SDK 24+
- Kotlin 2.0.21+

### Pasos para ejecutar:

1. **Clonar el proyecto**:
   ```bash
   git clone https://github.com/Gutska90/Kotlin-dietas-app.git
   cd Kotlin-dietas-app
   ```

2. **Abrir en Android Studio**:
   - Abrir Android Studio
   - Seleccionar "Open an existing project"
   - Navegar a la carpeta del proyecto y seleccionarla

3. **Sincronizar dependencias**:
   - Esperar a que Gradle sincronice las dependencias
   - Resolver cualquier error de dependencias si es necesario

4. **Ejecutar la aplicación**:
   - Conectar un dispositivo Android o usar un emulador
   - Presionar el botón "Run" (▶️) en Android Studio

### Credenciales de prueba

Para probar la aplicación, puedes usar estas credenciales predefinidas:

- **Email**: `admin@dietas.com` | **Contraseña**: `admin123`
- **Email**: `usuario@dietas.com` | **Contraseña**: `user123`
- **Email**: `test@dietas.com` | **Contraseña**: `test123`

O crear una nueva cuenta usando la función de registro.

## Estructura del Proyecto

```
app/src/main/java/com/example/kotlin_duoc/
├── data/
│   ├── Models.kt              # Modelos de datos
│   └── DietRepository.kt       # Repositorio de dietas
├── viewmodel/
│   ├── AuthViewModel.kt        # ViewModel para autenticación
│   └── DietViewModel.kt        # ViewModel para dietas
├── ui/screens/
│   ├── LoginScreen.kt          # Pantalla de login
│   ├── RegisterScreen.kt       # Pantalla de registro
│   ├── ForgotPasswordScreen.kt # Pantalla de recuperación
│   ├── DietListScreen.kt       # Lista de dietas
│   └── DietDetailScreen.kt     # Detalle de dieta
├── navigation/
│   └── AppNavigation.kt        # Navegación principal
└── MainActivity.kt             # Actividad principal
```

## Funcionalidades Principales

### Autenticación
- Validación de credenciales
- Gestión de sesiones
- Recuperación de contraseñas

### Gestión de Dietas
- Listado de todas las dietas disponibles
- Filtrado por categoría (Pérdida, Muscular, Mantenimiento, etc.)
- Detalles nutricionales completos
- Información de calorías y macronutrientes

### Interfaz de Usuario
- Diseño minimalista y moderno
- Navegación fluida entre pantallas
- Feedback visual para acciones del usuario
- Adaptable a diferentes tamaños de pantalla

## Contribución

Para contribuir al proyecto:

1. Fork el repositorio
2. Crear una rama para tu feature (`git checkout -b feature/nueva-funcionalidad`)
3. Commit tus cambios (`git commit -am 'Agregar nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Crear un Pull Request

## Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.

## Contacto

Para preguntas o soporte, contacta al equipo de desarrollo.

---

**Nota**: Esta aplicación es un proyecto educativo y las dietas son sugerencias generales. Para recomendaciones nutricionales específicas, consulta con un profesional de la salud.
