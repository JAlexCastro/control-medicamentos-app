package com.josecontreras.controldemedicamentosapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "medicamentos")
data class Medicamento(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String,
    val tipo: String,      // tópico, oral, inhalado
    val dosis: String,     // mg, pastillas, ml Ej: "500 mg"
    val horario: String    // Ej: "08:00 / c/8hrs"
)
