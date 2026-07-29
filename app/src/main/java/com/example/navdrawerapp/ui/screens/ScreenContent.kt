package com.example.navdrawerapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navdrawerapp.ui.theme.*

/**
 * File ScreenContent.kt
 * =====================
 * Composable generik yang dipakai oleh semua Screen.
 * MODIFIKASI: Menghapus Scaffold internal karena sudah menggunakan Scaffold global di MainActivity.
 */

@Composable
fun ScreenContent(
    bodyTitle: String,           // Judul di tengah layar (Bold)
    description: String,         // Deskripsi di bawah judul
    toastMessage: String         // Pesan Toast saat button diklik
) {
    val context = LocalContext.current

    // === AREA KONTEN ===
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 1. Judul (Bold)
        Text(
            text = bodyTitle,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = TextPrimary,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 2. Deskripsi
        Text(
            text = description,
            color = ContentText,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 3. Button
        Button(
            onClick = {
                Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Primary
            )
        ) {
            Text(text = "Buka Fitur")
        }
    }
}
