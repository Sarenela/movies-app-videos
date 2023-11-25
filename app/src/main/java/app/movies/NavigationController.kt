package app.movies

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import app.movies.views.MovieView

@Composable
fun NavigationController(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "MainView"){
        composable("MainView"){
            MainView(navController)
        }
        composable(
            "MovieView/{title}",
            arguments = listOf(navArgument("title") { type = NavType.StringType })
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            MovieView(navController, title = title)
        }
    }
}