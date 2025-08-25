package com.example.makeyourganesha.feature.share

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.FileProvider
import androidx.navigation.NavController
import com.example.makeyourganesha.feature.creation.captureViewToCache
import androidx.compose.ui.platform.LocalView
import java.io.File
import java.io.FileOutputStream

@Composable
fun ShareFab(navController: NavController) {
    val context = LocalContext.current
    val activityView = LocalView.current
    ExtendedFloatingActionButton(
        onClick = {
            val uri = captureViewToCache(context, activityView)
            if (uri != null) {
                shareChooser(context, uri)
            }
        },
        icon = { Icon(Icons.Default.Share, contentDescription = "Share") },
        text = { Text("Share") }
    )
}

private fun ensureSampleShareableImage(context: Context): Uri? {
    val cacheDir = File(context.cacheDir, "images").apply { mkdirs() }
    val file = File(cacheDir, "creation.png")
    if (!file.exists()) {
        val bitmap = Bitmap.createBitmap(600, 400, Bitmap.Config.ARGB_8888)
        val fos = FileOutputStream(file)
        bitmap.eraseColor(0xFFFFC107.toInt())
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos)
        fos.flush()
        fos.close()
    }
    return try {
        FileProvider.getUriForFile(context, context.packageName + ".fileprovider", file)
    } catch (e: Exception) {
        null
    }
}

private fun shareChooser(context: Context, uri: Uri) {
    val chooser = Intent.createChooser(Intent().apply {
        action = Intent.ACTION_SEND
        type = "image/*"
        putExtra(Intent.EXTRA_STREAM, uri)
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    }, "Share your Ganesha")

    // Prefer WhatsApp and Facebook if installed by setting initial intents
    val initialIntents = mutableListOf<Intent>()
    val pm = context.packageManager
    fun intentFor(pkg: String): Intent? = try {
        pm.getPackageInfo(pkg, 0)
        Intent(Intent.ACTION_SEND).apply {
            setPackage(pkg)
            type = "image/*"
            putExtra(Intent.EXTRA_STREAM, uri)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
    } catch (_: Exception) { null }

    intentFor("com.whatsapp")?.let { initialIntents.add(it) }
    intentFor("com.facebook.katana")?.let { initialIntents.add(it) }

    if (initialIntents.isNotEmpty()) {
        chooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, initialIntents.toTypedArray())
    }
    context.startActivity(chooser)
}

