package com.example.animelist.model

import androidx.annotation.DrawableRes
import com.example.animelist.R

data class BottomNavigationItem(
    val route: String,
    @DrawableRes
    val icon: Int
) {
    companion object {
        val items = listOf(
            BottomNavigationItem("home", R.drawable.home),
            BottomNavigationItem("myFilm", R.drawable.myfilm),
            BottomNavigationItem("about", R.drawable.profile),
        )
    }
}