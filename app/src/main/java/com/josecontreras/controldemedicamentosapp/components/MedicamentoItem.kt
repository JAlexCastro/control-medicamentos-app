package com.josecontreras.controldemedicamentosapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.josecontreras.controldemedicamentosapp.data.Medicamento
import com.josecontreras.controldemedicamentosapp.R


@Composable
fun MedicamentoItem(medicamento: Medicamento) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(12.dp)
        ) {
            // Imagen según el tipo
            val imageRes = when (medicamento.tipo.lowercase()) {
                "oral" -> R.drawable.oral
                "tópico" -> R.drawable.topico
                "inhalado" -> R.drawable.inhalado
                else -> R.drawable.oral
            }

            Image(
                painter = painterResource(id = imageRes),
                contentDescription = medicamento.tipo,
                modifier = Modifier
                    .size(60.dp)
                    .padding(end = 12.dp)
            )

            // Texto con los detalles
            Column {
                Text("Medicamento: ${medicamento.nombre}", style = MaterialTheme.typography.titleMedium)
                Text("Tipo: ${medicamento.tipo}")
                Text("Dosis: ${medicamento.dosis}")
                Text("Horario: ${medicamento.horario}")
            }
        }
    }
}
