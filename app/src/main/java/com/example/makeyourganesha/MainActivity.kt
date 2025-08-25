package com.example.makeyourganesha

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.makeyourganesha.core.ui.AppTheme
import com.example.makeyourganesha.feature.home.HomeScreen
import com.example.makeyourganesha.feature.puja.PujaScreen
import com.example.makeyourganesha.feature.start.StartScreen
import com.example.makeyourganesha.feature.start.StageScreen
import com.example.makeyourganesha.feature.start.BackgroundScreen
import com.example.makeyourganesha.feature.start.ArtifactsScreen
import com.example.makeyourganesha.feature.start.IdolScreen
import com.example.makeyourganesha.feature.share.ShareFab
import com.example.makeyourganesha.feature.settings.SettingsScreen
import com.example.makeyourganesha.feature.profile.ProfileScreen
import com.example.makeyourganesha.feature.connect.ConnectScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                AppRoot()
            }
        }
    }
}

object Routes {
    const val HOME = "home"
    const val START = "start"
    const val STAGE = "stage"
    const val BACKGROUND = "background"
    const val ARTIFACTS = "artifacts"
    const val IDOL = "idol"
    const val PUJA = "puja"
    const val SETTINGS = "settings"
    const val PROFILE = "profile"
    const val CONNECT = "connect"
}

@Composable
private fun AppRoot() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        floatingActionButton = {
            ShareFab(navController = navController)
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = Routes.HOME,
            modifier = Modifier.fillMaxSize()
        ) {
            composable(Routes.HOME) { HomeScreen(navController) }
            composable(Routes.START) { StartScreen(navController) }
            composable(Routes.STAGE) { StageScreen(navController) }
            composable(Routes.BACKGROUND) { BackgroundScreen(navController) }
            composable(Routes.ARTIFACTS) { ArtifactsScreen(navController) }
            composable(Routes.IDOL) { IdolScreen(navController) }
            composable(Routes.PUJA) { PujaScreen(navController) }
            composable(Routes.SETTINGS) { SettingsScreen(navController) }
            composable(Routes.PROFILE) { ProfileScreen(navController) }
            composable(Routes.CONNECT) { ConnectScreen(navController) }
        }
    }
}

