package com.josecontreras.controldemedicamentosapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.josecontreras.controldemedicamentosapp.ui.screens.MedicamentoListScreen
import com.josecontreras.controldemedicamentosapp.viewmodel.MedicamentoViewModel

// Función composable que define la navegación entre pantallas usando Navigation Compose
@Composable
fun AppNavigation(viewModel: MedicamentoViewModel) {
    // Controlador de navegación que gestiona las rutas dentro de la app
    val navController = rememberNavController()

    // Contenedor de navegación que define las rutas disponibles
    NavHost(navController, startDestination = "listado") {
        // Ruta de la pantalla de listado de medicamentos
        composable("listado") {
            MedicamentoListScreen(navController, viewModel)
        }
        // Ruta de la pantallaa de formulario de registro
        composable("formulario") {
            MedicamentoFormScreen(navController, viewModel)
        }
    }
}
