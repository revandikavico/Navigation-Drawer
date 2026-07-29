package com.example.navdrawerapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.navdrawerapp.ui.theme.NavDrawerAppTheme

/**
 * File Screen4.kt
 * ===============
 * Halaman Screen 4 (Galeri).
 */

@Composable
fun Screen4() {
    ScreenContent(
        bodyTitle = "Galeri",
        description = "Menampilkan koleksi gambar atau media.",
        toastMessage = "Kamu berada di Galeri"
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Screen4Preview() {
    NavDrawerAppTheme {
        Screen4()
    }
}
