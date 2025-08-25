package com.example.makeyourganesha.core.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val Orange = Color(0xFFFF6F00)
private val Yellow = Color(0xFFFFC107)
private val Red = Color(0xFFD32F2F)
private val Cream = Color(0xFFFFF3E0)

private val LightColors = lightColorScheme(
    primary = Orange,
    onPrimary = Color.White,
    primaryContainer = Yellow,
    onPrimaryContainer = Color.Black,
    secondary = Red,
    onSecondary = Color.White,
    background = Cream,
    onBackground = Color(0xFF442200),
    surface = Color.White,
    onSurface = Color(0xFF331100)
)

private val DarkColors = darkColorScheme(
    primary = Yellow,
    onPrimary = Color.Black,
    primaryContainer = Orange,
    onPrimaryContainer = Color.White,
    secondary = Red,
    onSecondary = Color.White,
    background = Color(0xFF1C1210),
    onBackground = Color(0xFFFFE0B2),
    surface = Color(0xFF221410),
    onSurface = Color(0xFFFFE0B2)
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors
    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}

