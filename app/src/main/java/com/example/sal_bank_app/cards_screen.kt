package com.example.sal_bank_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sal_bank_app.ui.theme.Sal_bank_appTheme
import com.google.android.material.tabs.TabItem
import kotlinx.coroutines.delay

data class TabItem(
    val title:String,


    )
class cards_screen : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Sal_bank_appTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()


                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "Home_screen") {
                        composable("Cards_Screen") { CardsPopupScreen(navController) }
                        composable("Wallet") { Wallet(navController) }
                        composable("LoanCalculator") { LoanCalculatorScreen(navController) }
                        composable("ApprovedLoan") { ApprovedLoan(navController) }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CardsPopupScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFF185DAB))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(40.dp , alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(painter = painterResource(id = R.drawable.cards_img), contentDescription = "Logo")
        Text(  modifier = Modifier

            .padding(20.dp),text = "Track And Manage Your Portfolio", fontSize = 35.sp, textAlign = TextAlign.Center, color = Color.White, fontWeight = FontWeight.Black , lineHeight = 1.5.em)
        Box(modifier = Modifier.wrapContentSize().clickable{  navController.navigate("Cards")}) {
            // Create another box that covers the icon
            Box(
                modifier = Modifier
                    // Match the size of the icon
                    .size(50.dp)
                    // Clip the box to a circle shape
                    .clip(RoundedCornerShape(50.dp))

                    // Set the background color to white
                    .background(Color.White)
            )
            // Create an icon from a vector drawable resource
            Icon(
                painter = painterResource(id = R.drawable.right),
                contentDescription = "icon",
                // Set the tint color of the icon
                tint = Color.Unspecified,
                // Set the size of the icon
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.Center)
            )
        }
    }

}



