package com.josecontreras.controldemedicamentosapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.josecontreras.controldemedicamentosapp.components.MedicamentoItem
import com.josecontreras.controldemedicamentosapp.viewmodel.MedicamentoViewModel



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
// Función composable que muestra la pantalla de listado de medicamentos registrados
@Composable
fun MedicamentoListScreen(
    navController: NavController,
    viewModel: MedicamentoViewModel
) {
    // Obtiene la lista de medicamentos desde el ViewModel como un flujo de estado
    val lista by viewModel.medicamentos.collectAsState()

    Scaffold(
        floatingActionButton = {
            // Botón que navega a la pantalla del formulario al hacer clic
            FloatingActionButton(onClick = {
                navController.navigate("formulario")
            }) {
                Text("+")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Listado de Medicamentos",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            // Si no hay medicamentos, muestra un mensaje
            if (lista.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No hay medicamentos registrados")
                }
            } else {
                // Muestra la lista de medicamentos en una LazyColumn
                LazyColumn {
                    items(lista) { medicamento ->
                        MedicamentoItem(medicamento)
                        Divider()
                    }
                }
            }
        }
    }
}
