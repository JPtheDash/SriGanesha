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
fun IdolScreen(navController: NavController, vm: SelectionViewModel = viewModel()) {
    Column(Modifier.fillMaxSize().padding(24.dp)) {
        Text("Choose Head")
        Button(onClick = { vm.updateHead("Crown") }) { Text("Crown Head") }
        Button(onClick = { vm.updateHead("Modern") }) { Text("Modern Head") }

        Text("Choose Body")
        Button(onClick = { vm.updateBody("Traditional") }) { Text("Traditional") }
        Button(onClick = { vm.updateBody("Modern") }) { Text("Modern") }

        Text("Choose Vahana")
        Button(onClick = { vm.updateVahana("Mouse") }) { Text("Mouse") }
        Button(onClick = { vm.updateVahana("Peacock") }) { Text("Peacock") }
        Button(onClick = { vm.updateVahana("Swan") }) { Text("Swan") }

        Button(onClick = { navController.popBackStack() }) { Text("Done") }
    }
}

