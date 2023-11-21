package com.example.sal_bank_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sal_bank_app.ui.theme.Sal_bank_appTheme
import kotlinx.coroutines.delay


data class BottomNavigationItem(
    val title: String,
    val selectedIcon: Painter,
    val unselectedIcon: Painter,
)
@OptIn(ExperimentalMaterial3Api::class)

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Sal_bank_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                        Navigation()
                    }
                    }

                }
            }
        }

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun Navigation(){

    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = "splash_screen" ){
        composable("splash_screen"){
            SplashScreen(navController=navController)
        }
        composable("cards_screen"){
            PopUpScreen(navController=navController)
        }


        composable("main_screen"){
           MainScreen()
        }

    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    val navController = rememberNavController()

    val items = listOf(
        BottomNavigationItem(
            title = "Home",

            selectedIcon = painterResource(id = R.drawable.home),
            unselectedIcon = painterResource(id = R.drawable.home),
        ),
        BottomNavigationItem(
            title = "Cards",

            selectedIcon = painterResource(id = R.drawable.cards),
            unselectedIcon = painterResource(id = R.drawable.cards),
//                        badgeCount = 4
        ),
        BottomNavigationItem(
            title = "Savings",

            selectedIcon = painterResource(id = R.drawable.savings,),
            unselectedIcon = painterResource(id = R.drawable.savings),
        ),
        BottomNavigationItem(
            title = "Loans",

            selectedIcon = painterResource(id = R.drawable.wallett),
            unselectedIcon = painterResource(id = R.drawable.wallett),
        ),
        BottomNavigationItem(
            title = "Setings",

            selectedIcon = painterResource(id = R.drawable.settinggs),
            unselectedIcon = painterResource(id = R.drawable.settinggs),
        )
    )
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    Scaffold(
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route


            if (currentRoute !=  Screens.Loans.route && currentRoute != Screens.cards_screen.route ) {
                NavigationBar(
                    containerColor = Color.White,
                ) {

                    items.forEachIndexed { index, item ->
                        NavigationBarItem(

                            selected = selectedItemIndex == index,
                            onClick = {
                                selectedItemIndex = index
                                navController.navigate(item.title)
                            },
                            colors = NavigationBarItemDefaults.colors(
                                indicatorColor = Color.White,
                                selectedIconColor = Color(0xFF185DAB),
                            ),
                            icon = {
                                if (index == 2) {

                                    Box(
                                        modifier = Modifier
                                            .size(50.dp)
                                            .clip(CircleShape)
                                            .background(Color(0xFF185DAB)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            tint = Color.White,
                                            painter = items[2].selectedIcon,
                                            contentDescription = "Home icon",

                                            modifier = Modifier
                                                .size(28.dp)
//                                                                .tint(Color.White)
                                        )
                                    }
                                } else {
                                    Icon(
                                        painter = if (index == selectedItemIndex) {
                                            item.selectedIcon


                                        } else item.unselectedIcon,
                                        contentDescription = item.title,
                                        modifier = Modifier
                                            .size(20.dp)
                                    )
                                }
                            }

                        )
                    }
                }
            }

        }

    )
    {
        NavHost(
            navController = navController,
            startDestination = Screens.Home.route
        ) {

            composable(Screens.Home.route) { HomeScreee() }
            composable(Screens.Cards.route) { CardsScreen() }
            composable(Screens.Loans.route) { LoansScreen() }

        }
    }
}


@Composable
fun SplashScreen(navController: NavController){
    val scale = remember{
        Animatable(0f)
    }
    LaunchedEffect(key1 = true, ){
        scale.animateTo(targetValue = 0.7f, animationSpec = tween(
            durationMillis = 500,
            easing = {
                OvershootInterpolator(2f).getInterpolation(it)
            }
        )
        )
        delay(100L)
        navController.navigate("main_screen")
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()

    ){
        Image(painter = painterResource(id = R.drawable.background), contentScale = ContentScale.FillBounds, contentDescription = null)
        Image(painter = painterResource(id = R.drawable.foreground), contentDescription = "logo", modifier = Modifier.scale(scale.value))

    }
}


