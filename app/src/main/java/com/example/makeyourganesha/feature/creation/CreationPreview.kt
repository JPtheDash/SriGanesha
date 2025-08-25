package com.example.makeyourganesha.feature.creation

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.platform.LocalContext
import android.view.View
import androidx.core.content.FileProvider
import androidx.core.view.drawToBitmap
import com.example.makeyourganesha.core.data.CreationSelection
import java.io.File
import java.io.FileOutputStream

@Composable
fun CreationPreview(selection: CreationSelection, modifier: Modifier = Modifier) {
    val bgColor = when (selection.background) {
        "Sunrise" -> Color(0xFFFFF59D)
        "Festive Red" -> Color(0xFFFFCDD2)
        "Saffron" -> Color(0xFFFFE0B2)
        else -> MaterialTheme.colorScheme.background
    }
    Box(modifier = modifier.background(bgColor)) {
        Canvas(modifier = Modifier.fillMaxWidth().aspectRatio(1f)) {
            // Stage base
            drawRect(
                color = Color(0xFFFF8F00),
                topLeft = Offset(size.width * 0.1f, size.height * 0.75f),
                size = androidx.compose.ui.geometry.Size(size.width * 0.8f, size.height * 0.08f)
            )

            // Idol body
            val bodyColor = Color(0xFFFFF3E0)
            drawCircle(bodyColor, radius = size.minDimension * 0.18f, center = Offset(size.width * 0.5f, size.height * 0.55f))

            // Idol head variants
            val headCenter = Offset(size.width * 0.5f, size.height * 0.38f)
            when (selection.head) {
                "Crown" -> {
                    drawCircle(Color(0xFFFFE082), radius = size.minDimension * 0.12f, center = headCenter)
                    drawRect(Color(0xFFFFC107), topLeft = Offset(headCenter.x - 40, headCenter.y - 120), size = androidx.compose.ui.geometry.Size(80f, 40f))
                }
                "Modern" -> {
                    drawRect(Color(0xFFE1BEE7), topLeft = Offset(headCenter.x - 60, headCenter.y - 60), size = androidx.compose.ui.geometry.Size(120f, 120f))
                }
                else -> {
                    drawCircle(Color(0xFFFFE0B2), radius = size.minDimension * 0.12f, center = headCenter)
                }
            }

            // Vahana simple symbol
            when (selection.vahana) {
                "Peacock" -> drawCircle(Color(0xFF80DEEA), radius = 20f, center = Offset(size.width * 0.8f, size.height * 0.85f))
                "Swan" -> drawCircle(Color(0xFFB3E5FC), radius = 20f, center = Offset(size.width * 0.8f, size.height * 0.85f))
                else -> drawCircle(Color(0xFFBDBDBD), radius = 20f, center = Offset(size.width * 0.8f, size.height * 0.85f)) // Mouse default
            }
        }
    }
}

fun captureViewToCache(context: Context, view: View, filename: String = "creation.png"): Uri? {
    return try {
        val bitmap: Bitmap = view.drawToBitmap()
        val cacheDir = File(context.cacheDir, "images").apply { mkdirs() }
        val file = File(cacheDir, filename)
        FileOutputStream(file).use { out ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
        }
        FileProvider.getUriForFile(context, context.packageName + ".fileprovider", file)
    } catch (e: Exception) {
        null
    }
}

