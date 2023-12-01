package andres.rangel.food10

import andres.rangel.food10.navigation.AppNavigation
import andres.rangel.food10.navigation.AppScreens
import andres.rangel.food10.navigation.BottomNavigationBar
import andres.rangel.food10.ui.theme.Food10Theme
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Food10Theme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                Scaffold(
                    bottomBar = {
                        if (currentRoute != "login_screen" && currentRoute != "register_screen" && currentRoute != "map_screen") {
                            BottomNavigationBar(
                                navController,
                                listOf(
                                    AppScreens.HomeScreen,
                                    AppScreens.BookmarksScreen,
                                    AppScreens.ProfileScreen
                                )
                            )
                        }
                    }
                ) {
                    AppNavigation(navController)
                }
            }
        }
    }
}