package com.example.animelist.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.animelist.model.BottomNavigationItem
import com.example.animelist.ui.route.AboutRoute
import com.example.animelist.ui.route.home.HomeRoute
import com.example.animelist.ui.route.myfilm.MyFilmRoute
import com.example.animelist.ui.theme.Blue
import com.example.animelist.ui.theme.DarkBlue
import com.example.animelist.ui.theme.Tosca

@Composable
fun RootNavGraph(
    navController: NavHostController = rememberNavController()
) {
    Box(
        contentAlignment = Alignment.BottomCenter,
    ) {
        NavHost(
            modifier = Modifier,
            navController = navController,
            startDestination = Screen.Home.route
        ) {
            composable(Screen.Home.route) {
                HomeRoute()
            }
            composable(Screen.MyFilm.route) {
                MyFilmRoute()
            }
            composable(Screen.About.route) {
                AboutRoute()
            }
        }
        NavigationBar(
            modifier = Modifier.clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
            containerColor = Tosca,
            contentColor = MaterialTheme.colorScheme.tertiary,
            tonalElevation = 0.dp
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            BottomNavigationItem.items.forEach { item ->
                NavigationBarItem(
                    colors = NavigationBarItemColors(
                        selectedIndicatorColor = Color.Transparent,
                        selectedTextColor = MaterialTheme.colorScheme.tertiary,
                        selectedIconColor = MaterialTheme.colorScheme.tertiary,
                        unselectedIconColor = Color.Black,
                        unselectedTextColor = Color.Black,
                        disabledIconColor = Color.Black,
                        disabledTextColor = Color.Black
                    ),
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            tint = when (currentDestination?.hierarchy?.any { it.route == item.route } == true) {
                                true -> DarkBlue
                                false -> Blue
                            },
                            contentDescription = null
                        )
                    },
                    selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                    onClick = {
                        navController.navigate(item.route) {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            // on the back stack as users select items
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}