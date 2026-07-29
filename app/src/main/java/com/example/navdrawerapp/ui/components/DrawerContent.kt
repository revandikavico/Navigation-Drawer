package com.example.navdrawerapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navdrawerapp.ui.navigation.Screen
import com.example.navdrawerapp.ui.theme.*

/**
 * File DrawerContent.kt
 * =====================
 * Komponen ini menampilkan isi dari Navigation Drawer.
 * 
 * MODIFIKASI:
 * 1. Menambahkan item menu untuk Home.
 * 2. Mengupdate daftar menu agar sinkron dengan navigasi global.
 */

// Data class untuk menyimpan informasi setiap item menu drawer
data class DrawerItemModel(
    val screen: Screen,                          // Route tujuan
    val icon: @Composable () -> Unit,            // Ikon menu
    val label: String,                           // Teks label menu
)

/**
 * Composable terpisah untuk Header Drawer.
 * Berisi Foto Profil (Avatar), Nama, dan NIM.
 */
@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(HeaderGradient) // Menggunakan Gradient (Indigo ke Purple)
            .padding(top = 48.dp, start = 24.dp, end = 24.dp, bottom = 24.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        Column {
            // 1. Foto Profil (Avatar) - Dibuat lebih modern dengan Shadow/Elevation simulasi
            Surface(
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape),
                color = Color.White.copy(alpha = 0.2f),
                border = androidx.compose.foundation.BorderStroke(2.dp, Color.White)
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Foto Profil",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 2. Nama Pengguna
            Text(
                text = "Revandika Vico Irdantama",
                color = DrawerHeaderText,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 0.5.sp
            )

            // 3. NIM
            Text(
                text = "NIM: 23083000135",
                color = DrawerHeaderText.copy(alpha = 0.85f),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }
        Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color.White.copy(alpha = 0.1f)).align(Alignment.BottomCenter))
    }
}

/**
 * Composable terpisah untuk item menu Drawer.
 * Menampilkan ikon, label, dan badge jika sedang aktif.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerMenuItem(
    item: DrawerItemModel,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    NavigationDrawerItem(
        icon = item.icon,
        label = {
            Text(
                text = item.label,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
            )
        },
        selected = isSelected,
        onClick = onClick,
        badge = {
            if (isSelected) {
                Badge(
                    containerColor = Primary,
                    contentColor = TextOnPrimary
                ) {
                    Text("Active")
                }
            }
        },
        colors = NavigationDrawerItemDefaults.colors(
            selectedContainerColor = DrawerItemSelected,
            selectedTextColor = DrawerItemSelectedText,
            selectedIconColor = IconActive,
            unselectedTextColor = DrawerItemUnselectedText,
            unselectedIconColor = IconInactive
        ),
        modifier = Modifier.padding(horizontal = 12.dp)
    )
}

@Composable
fun DrawerContent(
    currentRoute: String?,                       // Route halaman yang sedang aktif
    onMenuClick: (Screen) -> Unit,               // Callback ketika menu diklik
    modifier: Modifier = Modifier
) {
    // Daftar semua menu yang ditampilkan di drawer
    val menuItems = listOf(
        DrawerItemModel(
            screen = Screen.Home,
            icon = { Icon(Icons.Default.Dashboard, contentDescription = "Dashboard", modifier = Modifier.size(24.dp)) },
            label = "Beranda"
        ),
        DrawerItemModel(
            screen = Screen.Screen1,
            icon = { Icon(Icons.Default.ShowChart, contentDescription = "Statistik", modifier = Modifier.size(24.dp)) },
            label = "Statistik"
        ),
        DrawerItemModel(
            screen = Screen.Screen2,
            icon = { Icon(Icons.Default.Person, contentDescription = "Profil", modifier = Modifier.size(24.dp)) },
            label = "Profil Saya"
        ),
        DrawerItemModel(
            screen = Screen.Screen3,
            icon = { Icon(Icons.Default.Settings, contentDescription = "Pengaturan", modifier = Modifier.size(24.dp)) },
            label = "Pengaturan"
        ),
        DrawerItemModel(
            screen = Screen.Screen4,
            icon = { Icon(Icons.Default.Collections, contentDescription = "Galeri", modifier = Modifier.size(24.dp)) },
            label = "Galeri Foto"
        ),
        DrawerItemModel(
            screen = Screen.Screen5,
            icon = { Icon(Icons.Default.Help, contentDescription = "Bantuan", modifier = Modifier.size(24.dp)) },
            label = "Bantuan"
        )
    )

    // Layout utama drawer
    ModalDrawerSheet(
        modifier = modifier,
        drawerContainerColor = BackgroundDrawer
    ) {
        // === HEADER DRAWER ===
        DrawerHeader()

        Spacer(modifier = Modifier.height(8.dp))

        // === DAFTAR MENU ===
        menuItems.forEach { menuItem ->
            val isSelected = currentRoute == menuItem.screen.route
            
            DrawerMenuItem(
                item = menuItem,
                isSelected = isSelected,
                onClick = { onMenuClick(menuItem.screen) }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Garis pembatas (divider) di bawah menu
        Divider(
            modifier = Modifier.padding(horizontal = 16.dp),
            color = DrawerDivider
        )
    }
}
