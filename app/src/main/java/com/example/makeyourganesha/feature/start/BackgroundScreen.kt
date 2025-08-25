package com.example.makeyourganesha.feature.start

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.makeyourganesha.core.viewmodel.SelectionViewModel

@Composable
fun BackgroundScreen(navController: NavController, vm: SelectionViewModel = viewModel()) {
    Column(Modifier.fillMaxSize().padding(24.dp)) {
        Text("Choose Background")
        Button(onClick = { vm.updateBackground("Sunrise"); navController.popBackStack() }) { Text("Sunrise") }
        Button(onClick = { vm.updateBackground("Festive Red"); navController.popBackStack() }) { Text("Festive Red") }
        Button(onClick = { vm.updateBackground("Saffron"); navController.popBackStack() }) { Text("Saffron") }
    }
}

