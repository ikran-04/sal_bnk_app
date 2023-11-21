package com.example.sal_bank_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sal_bank_app.ui.theme.Sal_bank_appTheme

class finances_screen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sal_bank_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Finances()
                }
            }
        }
    }
}
@Composable
fun Finances(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home_screen") {
        composable("FinancesCard") { FinancesCard(navController) }
        composable("Wallet") { Wallet(navController) }
        composable("LoanCalculator") { LoanCalculatorScreen(navController) }
        composable("ApprovedLoan") { ApprovedLoan(navController) }
    }
}

@Composable
fun FinancesCard(navController: NavController){

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFF185DAB)),
    ) {
        Column (
            modifier = Modifier.fillMaxWidth().padding(top= 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.character), contentDescription = null)
        }

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.5f)

                    .clip(shape = RoundedCornerShape(60.dp, 60.dp, 0.dp, 0.dp))
                    .background(Color(0xFFF8F9F9)),

            ) {

        Column (
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(30.dp, alignment = Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Manage Your \n finances work",
                fontSize = 38.sp,
                color = Color(0xFF0E3868),
                textAlign = TextAlign.Center,
                lineHeight = 1.2.em ,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "we don’t charge and fees for \n spending & don’t mark up the rate",
                fontSize = 16.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
            Box(modifier = Modifier.wrapContentSize().clickable{  navController.navigate("Savings")}) {
                // Create another box that covers the icon
                Box(
                    modifier = Modifier
                        // Match the size of the icon
                        .size(50.dp)
                        // Clip the box to a circle shape
                        .clip(RoundedCornerShape(50.dp))

                        // Set the background color to white
                        .background(Color(0xFF185DAB))
                )
                // Create an icon from a vector drawable resource
                Icon(
                    painter = painterResource(id = R.drawable.right_arrow),
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
        }



    }

}


