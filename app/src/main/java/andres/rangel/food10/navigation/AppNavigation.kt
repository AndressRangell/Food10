package andres.rangel.food10.navigation

import andres.rangel.food10.presentation.BookmarksScreen
import andres.rangel.food10.presentation.HomeScreen
import andres.rangel.food10.presentation.LoginScreen
import andres.rangel.food10.presentation.MapScreen
import andres.rangel.food10.presentation.ProfileScreen
import andres.rangel.food10.presentation.RegisterScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppScreens.HomeScreen.route
    ) {
        composable(AppScreens.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(AppScreens.RegisterScreen.route) {
            RegisterScreen(navController)
        }
        composable(AppScreens.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(AppScreens.BookmarksScreen.route) {
            BookmarksScreen(navController)
        }
        composable(AppScreens.ProfileScreen.route) {
            ProfileScreen(navController)
        }
        composable(AppScreens.MapScreen.route) {
            MapScreen(navController)
        }
    }
}
