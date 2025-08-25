package com.example.makeyourganesha.feature.start

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.makeyourganesha.Routes
import com.example.makeyourganesha.core.viewmodel.SelectionViewModel
import com.example.makeyourganesha.feature.creation.CreationPreview

@Composable
fun StartScreen(navController: NavController, vm: SelectionViewModel = viewModel()) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Start Creating", style = MaterialTheme.typography.headlineMedium)
        val selection = vm.selection.collectAsState().value
        Spacer(Modifier.height(16.dp))
        CreationPreview(selection = selection, modifier = Modifier)
        Spacer(Modifier.height(16.dp))
        Button(onClick = { navController.navigate("stage") }) { Text("Make Stage") }
        Spacer(Modifier.height(8.dp))
        Button(onClick = { navController.navigate("background") }) { Text("Make Background") }
        Spacer(Modifier.height(8.dp))
        Button(onClick = { navController.navigate("artifacts") }) { Text("Artifacts") }
        Spacer(Modifier.height(8.dp))
        Button(onClick = { navController.navigate("idol") }) { Text("Make Idol") }
        Spacer(Modifier.height(8.dp))
        Button(onClick = { navController.navigate(Routes.PUJA) }) { Text("Do Puja") }
    }
}

