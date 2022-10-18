package com.android.composeapp

//import androidx.navigation.compose.composable
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.android.composeapp.bottomNavigation.CustomBottomNavigation
import com.android.composeapp.bottomNavigation.NavigationItem
import com.android.composeapp.bottomNavigation.Screen
import com.android.composeapp.searchImage.components.MainComponent
import com.android.composeapp.searchImage.components.MainContentItem
import com.android.composeapp.ui.theme.ComposeAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState", "UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    color = MaterialTheme.colors.background
                ) {
                    Navigation()
                }

            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeAppTheme {
//            CenterItem()
            UserProfileScreens()
        }
    }

    @Composable
    fun CenterItem() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Top
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.home_top_image),
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Card(
                    modifier = Modifier.fillMaxSize(),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.street_view1),
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

        }
    }


}

@Composable
fun NavigationController(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {

        composable(NavigationItem.Home.route) {
            HomeScreens()
        }

        composable(NavigationItem.Notifications.route) {
            UserProfileScreens()
        }

        composable(NavigationItem.Settings.route) {
            WallpaperScreens()
        }

        composable(NavigationItem.Account.route) {
            UserProfileScreens()
        }
    }

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Navigation() {

    val navController = rememberNavController()

    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Settings,
        NavigationItem.Notifications,
        NavigationItem.Account
    )


    Scaffold(topBar = { TopAppBar(title = { Text(text = "Bottom Navigation VIew") }) },
        bottomBar = {
            BottomNavigation(backgroundColor = MaterialTheme.colors.background) {

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                items.forEach {
                    BottomNavigationItem(selected = currentRoute == it.route,
                        label = {
                            Text(
                                text = it.label,
                                color = if (currentRoute == it.route) Color.DarkGray else Color.LightGray
                            )
                        },
                        icon = {
                            Icon(
                                imageVector = it.icons, contentDescription = null,
                                tint = if (currentRoute == it.route) Color.DarkGray else Color.LightGray
                            )
                        },

                        onClick = {
                            if (currentRoute != it.route) {
                                navController.graph.startDestinationRoute?.let {
                                    navController.popBackStack(it, true)
                                }
                                navController.navigate(it.route) {
                                    launchSingleTop = true
                                }
                            }
                        })
                }
            }
        }) {

        NavigationController(navController = navController)
    }

}

@Composable
fun HomeScreens() {
    Column(modifier = Modifier
        .fillMaxSize()
        ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "HomeScreens")
        }

    }

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnrememberedMutableState")
@Composable
fun UserProfileScreens() {
    Column(modifier = Modifier.fillMaxSize()) {
        val currentScreen = mutableStateOf<Screen>(Screen.Home)
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "UserProfileScreens")
            Scaffold(bottomBar = {
                CustomBottomNavigation(currentScreenId = currentScreen.value.id) { it ->

                    currentScreen.value = it
                }
            }, modifier = Modifier.requiredHeight(600.dp)
            ) {

            }
        }
    }
}@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnrememberedMutableState")
@Composable
fun WallpaperScreens() {
    Column(modifier = Modifier.fillMaxSize()) {
        val currentScreen = mutableStateOf<Screen>(Screen.Home)
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MyApp {
                MainComponent()
            }
        }
    }
}


@Composable
fun MyApp(content:@Composable ()->Unit) {
    content()
}



