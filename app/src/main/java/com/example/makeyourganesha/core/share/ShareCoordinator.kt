package com.example.makeyourganesha.core.share

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

fun interface ShareProvider {
    fun provideUri(context: Context): android.net.Uri?
}

val LocalShareProvider = staticCompositionLocalOf<ShareProvider> {
    ShareProvider { null }
}

@Composable
fun ProvideShareProvider(provider: ShareProvider, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalShareProvider provides provider) {
        content()
    }
}

