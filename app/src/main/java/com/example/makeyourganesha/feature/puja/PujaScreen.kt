package com.example.makeyourganesha.feature.puja

import android.media.MediaPlayer
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PujaScreen(navController: NavController) {
    val infinite = rememberInfiniteTransition(label = "diya")
    val glow by infinite.animateFloat(
        initialValue = 0.7f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(800),
            repeatMode = RepeatMode.Reverse
        ), label = "glow"
    )

    Column(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background).padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Puja", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(24.dp))
        Box(modifier = Modifier.height(220.dp), contentAlignment = Alignment.Center) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                // simple flame glow
                drawCircle(Color(0xFFFFA000).copy(alpha = 0.3f * glow), radius = size.minDimension / 3)
                drawCircle(Color(0xFFFFC107).copy(alpha = 0.4f * glow), radius = size.minDimension / 4)
                drawCircle(Color(0xFFFFD54F).copy(alpha = 0.6f * glow), radius = size.minDimension / 6)
            }
        }
        Spacer(Modifier.height(16.dp))
        Text("Ding! Ring the bell for blessings.")
        val playing = remember { mutableStateOf(false) }
        Button(onClick = { playing.value = true }) { Text("Ring Bell") }

        val context = androidx.compose.ui.platform.LocalContext.current
        DisposableEffect(playing.value) {
            var player: MediaPlayer? = null
            if (playing.value) {
                player = MediaPlayer.create(context, android.provider.Settings.System.DEFAULT_NOTIFICATION_URI)
                player?.setOnCompletionListener { playing.value = false }
                player?.start()
            }
            onDispose {
                player?.release()
            }
        }
    }
}

