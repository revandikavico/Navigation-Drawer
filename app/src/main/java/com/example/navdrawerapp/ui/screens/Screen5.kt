package com.example.navdrawerapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.navdrawerapp.ui.theme.NavDrawerAppTheme

/**
 * File Screen5.kt
 * ===============
 * Halaman Screen 5 (Tentang Aplikasi).
 */

@Composable
fun Screen5() {
    ScreenContent(
        bodyTitle = "Tentang Aplikasi",
        description = "Informasi mengenai aplikasi dan pengembang.",
        toastMessage = "Kamu berada di Tentang Aplikasi"
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Screen5Preview() {
    NavDrawerAppTheme {
        Screen5()
    }
}
