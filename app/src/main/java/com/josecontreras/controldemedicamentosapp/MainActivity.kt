package com.josecontreras.controldemedicamentosapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.josecontreras.controldemedicamentosapp.ui.AppNavigation
import com.josecontreras.controldemedicamentosapp.ui.theme.ControlDeMedicamentosAppTheme
import com.josecontreras.controldemedicamentosapp.viewmodel.MedicamentoViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: MedicamentoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation(viewModel)
        }
    }
}
