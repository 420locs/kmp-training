package org.example.test1.feature

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.example.test1.feature.home.HomeNavigation
import org.example.test1.feature.home.HomeScreen
import org.example.test1.feature.search.SearchNavigation
import org.example.test1.feature.search.SearchScreen

@Composable
internal fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HomeNavigation) {
        composable<HomeNavigation> {
            HomeScreen(navController = navController)
        }
        composable<SearchNavigation> { backStackEntry ->
            val argument = backStackEntry.toRoute<SearchNavigation>()
            SearchScreen(
                navController = navController,
                keyword = argument.keyword
            )
        }
    }
}

