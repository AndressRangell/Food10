package andres.rangel.food10.navigation

sealed class AppScreens(val route: String) {
    object LoginScreen: AppScreens("login_screen")
    object RegisterScreen: AppScreens("register_screen")
    object HomeScreen: AppScreens("home_screen")
    object ProfileScreen: AppScreens("profile_screen")
    object BookmarksScreen: AppScreens("bookmarks_screen")
    object MapScreen: AppScreens("map_screen")
}
