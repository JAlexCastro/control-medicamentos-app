package com.josecontreras.controldemedicamentosapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.josecontreras.controldemedicamentosapp.data.AppDatabase
import com.josecontreras.controldemedicamentosapp.data.Medicamento
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MedicamentoViewModel(application: Application) : AndroidViewModel(application) {
    // Se obtiene una instancia del DAO (Data Access Object) de la base de datos Room
    private val dao = AppDatabase.getDatabase(application).medicamentoDao()

    // Flujo de datos reactivo que contiene la lista de medicamentos desde la base de datos
    val medicamentos: StateFlow<List<Medicamento>> =
        dao.obtenerTodos().stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    // Función para insertar un nuevo medicamento en la base de datos usando una corrutina
    fun insertarMedicamento(medicamento: Medicamento) {
        viewModelScope.launch {
            dao.insertar(medicamento)
        }
    }

}
