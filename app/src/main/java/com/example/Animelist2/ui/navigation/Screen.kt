package com.example.animelist.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object MyFilm : Screen("myFilm")
    object About : Screen("about")
}