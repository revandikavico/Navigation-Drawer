package com.example.navdrawerapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.navdrawerapp.ui.theme.NavDrawerAppTheme

/**
 * File Screen3.kt
 * ===============
 * Halaman Screen 3 (Pengaturan).
 */

@Composable
fun Screen3() {
    ScreenContent(
        bodyTitle = "Pengaturan",
        description = "Atur preferensi aplikasi sesuai kebutuhan.",
        toastMessage = "Kamu berada di Pengaturan"
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Screen3Preview() {
    NavDrawerAppTheme {
        Screen3()
    }
}
