package com.example.navdrawerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.navdrawerapp.ui.components.DrawerContent
import com.example.navdrawerapp.ui.navigation.NavGraph
import com.example.navdrawerapp.ui.navigation.Screen
import com.example.navdrawerapp.ui.theme.*
import kotlinx.coroutines.launch

/**
 * File MainActivity.kt
 * ====================
 * Activity utama aplikasi dengan implementasi Navigation Drawer yang global.
 * Navigation Drawer, Scaffold, dan TopAppBar sekarang berada di level teratas
 * sehingga dapat diakses dari semua halaman.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            NavDrawerAppTheme {
                MainApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp() {
    // 1. SATU NavController untuk seluruh aplikasi
    val navController = rememberNavController()
    
    // 2. SATU DrawerState untuk mengontrol buka/tutup drawer
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    
    // CoroutineScope untuk operasi suspend (buka/tutup drawer)
    val scope = rememberCoroutineScope()

    // Mendapatkan route saat ini untuk highlight menu di drawer
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // 3. SATU ModalNavigationDrawer sebagai pembungkus utama
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            // Isi Navigation Drawer
            DrawerContent(
                currentRoute = currentRoute,
                onMenuClick = { screen ->
                    // 8. Drawer otomatis ditutup saat pindah screen
                    scope.launch {
                        drawerState.close()
                    }
                    // Navigasi ke screen yang dipilih
                    navController.navigate(screen.route) {
                        // Hindari penumpukan stack jika navigasi ke halaman yang sama
                        popUpTo(Screen.Home.route) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) {
        // 4. SATU Scaffold yang digunakan bersama oleh seluruh screen
        Scaffold(
            // 5. TopAppBar muncul di semua screen
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Portal Mahasiswa",
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        )
                    },
                    // 6. Tombol hamburger selalu membuka Navigation Drawer
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Buka Menu"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = TopBarBackground,
                        titleContentColor = TopBarContent,
                        navigationIconContentColor = TopBarContent
                    )
                )
            },
            containerColor = BackgroundScreen
        ) { paddingValues ->
            // 7. NavHost diletakkan di dalam content Scaffold
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                NavGraph(navController = navController)
            }
        }
    }
}
