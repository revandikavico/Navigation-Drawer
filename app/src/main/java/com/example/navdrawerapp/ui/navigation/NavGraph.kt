package com.example.navdrawerapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.navdrawerapp.ui.screens.*

/**
 * File NavGraph.kt
 * ================
 * Navigation Graph diperbarui untuk hanya menangani routing konten.
 * Scaffold dan Drawer dikelola secara global di MainActivity.
 */

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        // === HALAMAN HOME ===
        composable(route = Screen.Home.route) {
            HomeScreen()
        }

        // === HALAMAN SCREEN 1 ===
        composable(route = Screen.Screen1.route) {
            Screen1()
        }

        // === HALAMAN SCREEN 2 ===
        composable(route = Screen.Screen2.route) {
            Screen2()
        }

        // === HALAMAN SCREEN 3 ===
        composable(route = Screen.Screen3.route) {
            Screen3()
        }

        // === HALAMAN SCREEN 4 ===
        composable(route = Screen.Screen4.route) {
            Screen4()
        }

        // === HALAMAN SCREEN 5 ===
        composable(route = Screen.Screen5.route) {
            Screen5()
        }
    }
}
