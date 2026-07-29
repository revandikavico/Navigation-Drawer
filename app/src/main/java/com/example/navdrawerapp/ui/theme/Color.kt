package com.example.navdrawerapp.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

/**
 * File Color.kt
 * ============
 * Skema warna baru: Indigo & Deep Purple untuk tampilan modern.
 */

// === Warna Utama (Primary) - Indigo ===
val Primary = Color(0xFF3F51B5)          
val PrimaryDark = Color(0xFF303F9F)      
val PrimaryLight = Color(0xFFC5CAE9)     

// === Warna Sekunder (Secondary) - Deep Purple ===
val Secondary = Color(0xFF673AB7)        
val SecondaryDark = Color(0xFF512DA8)    
val SecondaryLight = Color(0xFFD1C4E9)

// === Warna Background ===
val BackgroundMain = Color(0xFFF0F2F5)   // Abu-abu sangat terang (kebiruan)
val BackgroundDrawer = Color(0xFFFFFFFF) // Putih
val BackgroundScreen = Color(0xFFF8F9FA) // Putih bersih

// === Warna Teks ===
val TextPrimary = Color(0xFF1A237E)      // Indigo sangat gelap
val TextSecondary = Color(0xFF5C6BC0)    // Indigo medium
val TextOnPrimary = Color(0xFFFFFFFF)    // Putih

// === Warna Top App Bar ===
val TopBarBackground = Color(0xFF3F51B5) 
val TopBarContent = Color(0xFFFFFFFF)    

// === Warna Drawer ===
val DrawerHeaderBackground = Color(0xFF303F9F)
val DrawerHeaderText = Color(0xFFFFFFFF)       
val DrawerItemSelected = Color(0xFFE8EAF6)     
val DrawerItemSelectedText = Color(0xFF3F51B5) 
val DrawerItemUnselectedText = Color(0xFF444444)
val DrawerDivider = Color(0xFFE0E0E0)          

// === Gradient untuk Header ===
val HeaderGradient = Brush.verticalGradient(
    colors = listOf(Color(0xFF3F51B5), Color(0xFF673AB7))
)

// === Warna Konten ===
val ContentText = Color(0xFF2C3E50)                
val ContentCardBackground = Color(0xFFFFFFFF)      
val ContentCardBorder = Color(0xFFECEFF1)          

// === Warna Icon ===
val IconActive = Color(0xFF3F51B5)       
val IconInactive = Color(0xFF9FA8DA)     
