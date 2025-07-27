package com.josecontreras.controldemedicamentosapp.ui

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.josecontreras.controldemedicamentosapp.R
import com.josecontreras.controldemedicamentosapp.components.DropdownSelector
import com.josecontreras.controldemedicamentosapp.data.Medicamento
import com.josecontreras.controldemedicamentosapp.viewmodel.MedicamentoViewModel

// Función composable que representa la pantalla del formulario para registrar un medicamento
@Composable
fun MedicamentoFormScreen(
    navController: NavController,
    viewModel: MedicamentoViewModel
) {
    val context = LocalContext.current

    // Estados para cada campo del formulario
    var nombre by remember { mutableStateOf("") }
    var tipo by remember { mutableStateOf("Oral") }
    var dosis by remember { mutableStateOf("") }
    var tipoDosis by remember { mutableStateOf("mg") }
    var horario by remember { mutableStateOf("") }
    var frecuencia by remember { mutableStateOf("c/8hrs") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Registro medicamentos", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        // 1. Medicamento (texto)
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Medicamento") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // 2. Tipo (selector con radio buttons)
        Text("Tipo:")
        Row {
            listOf("Tópico", "Oral", "Inhalado").forEach {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    RadioButton(
                        selected = tipo == it,
                        onClick = { tipo = it }
                    )
                    Text(text = it)
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // 3. Dosis (texto)
        OutlinedTextField(
            value = dosis,
            onValueChange = { dosis = it },
            label = { Text("Dosis") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // 4. Tipo de dosis (selector con radio buttons)
        Text("Tipo de dosis:")
        Row {
            listOf("mg", "pastillas", "ml").forEach {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    RadioButton(
                        selected = tipoDosis == it,
                        onClick = { tipoDosis = it }
                    )
                    Text(text = it)
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // 5. Horario (texto)
        OutlinedTextField(
            value = horario,
            onValueChange = { horario = it },
            label = { Text("Horario") },
            placeholder = { Text("Ej: 08:00") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // 6. Frecuencia (selector con radio buttons)
        Text("Frecuencia:")
        Row {
            listOf("c/8hrs", "c/12hrs", "c/24hrs").forEach {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    RadioButton(
                        selected = frecuencia == it,
                        onClick = { frecuencia = it }
                    )
                    Text(text = it)
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Botón Guardar
        Button(
            onClick = {
                if (nombre.isBlank() || dosis.isBlank() || horario.isBlank()) {
                    Toast.makeText(context, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                    return@Button
                }

                val medicamento = Medicamento(
                    nombre = nombre,
                    tipo = tipo,
                    dosis = "$dosis $tipoDosis",
                    horario = "$horario / $frecuencia"
                )

                viewModel.insertarMedicamento(medicamento)
                Toast.makeText(context, "Guardado correctamente", Toast.LENGTH_SHORT).show()
                navController.navigateUp()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar")
        }
    }
}
