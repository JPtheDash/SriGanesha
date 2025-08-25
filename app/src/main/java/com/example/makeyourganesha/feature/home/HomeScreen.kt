package com.example.makeyourganesha.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.makeyourganesha.R
import com.example.makeyourganesha.Routes

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Make Your Ganesha",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(24.dp))

        Button(onClick = { navController.navigate(Routes.START) }, contentPadding = PaddingValues(16.dp)) {
            Icon(Icons.Default.PlayArrow, contentDescription = null)
            Spacer(Modifier.height(0.dp))
            Text("Start")
        }
        Spacer(Modifier.height(12.dp))
        Button(onClick = { navController.navigate(Routes.SETTINGS) }) {
            Icon(Icons.Default.Settings, contentDescription = null)
            Text("Settings")
        }
        Spacer(Modifier.height(12.dp))
        Button(onClick = { navController.navigate(Routes.PROFILE) }) {
            Icon(Icons.Default.AccountCircle, contentDescription = null)
            Text("Profile")
        }
        Spacer(Modifier.height(12.dp))
        Button(onClick = { navController.navigate(Routes.CONNECT) }) {
            Icon(Icons.Default.Wifi, contentDescription = null)
            Text("Connect")
        }
    }
}

