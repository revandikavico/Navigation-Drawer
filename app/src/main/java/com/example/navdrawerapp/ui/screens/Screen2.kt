package com.example.navdrawerapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.navdrawerapp.ui.theme.NavDrawerAppTheme

/**
 * File Screen2.kt
 * ===============
 * Halaman Screen 2 (Profil).
 */

@Composable
fun Screen2() {
    ScreenContent(
        bodyTitle = "Profil",
        description = "Halaman untuk melihat dan mengelola data pengguna.",
        toastMessage = "Kamu berada di Profil"
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Screen2Preview() {
    NavDrawerAppTheme {
        Screen2()
    }
}
