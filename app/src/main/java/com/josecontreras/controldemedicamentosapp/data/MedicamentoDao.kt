package com.josecontreras.controldemedicamentosapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicamentoDao {
    @Insert
    suspend fun insertar(medicamento: Medicamento)

    @Query("SELECT * FROM medicamentos")
    fun obtenerTodos(): Flow<List<Medicamento>>
}
