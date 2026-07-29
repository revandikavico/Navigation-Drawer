package com.example.navdrawerapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.navdrawerapp.ui.theme.NavDrawerAppTheme

/**
 * File Screen1.kt
 * ===============
 * Halaman Screen 1 (Dashboard).
 */

@Composable
fun Screen1() {
    ScreenContent(
        bodyTitle = "Dashboard",
        description = "Halaman utama aplikasi yang menampilkan informasi umum.",
        toastMessage = "Kamu berada di Dashboard"
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Screen1Preview() {
    NavDrawerAppTheme {
        Screen1()
    }
}
