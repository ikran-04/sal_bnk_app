package com.example.sal_bank_app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sal_bank_app.ui.theme.Sal_bank_appTheme
import kotlin.math.roundToInt

class Loans : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sal_bank_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoansScreen()
                }
            }
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoansScreen(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "ApllyLoan") {
        composable("ApllyLoan") { ApllyLoan(navController) }
        composable("LoanCalculator") { LoanCalculatorScreen(navController) }
    }


}


@Composable
fun ApllyLoan(navController: NavController){
    val scrollState = rememberScrollState ()

    Column {

        Box(
            modifier = Modifier
                .height(500.dp)
                .fillMaxWidth()
        ) {
            Image(painter = painterResource(id = R.drawable.loan_bg),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            Column (

                modifier = Modifier
                    .padding(24.dp)
                    .matchParentSize()
                ,
                horizontalAlignment= Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {


                Column  (
                    verticalArrangement = Arrangement.spacedBy(40.dp)
                ){

                    Column {
                        Text(
                            text = "un paid Loans!",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Light,
                            color = Color.White
                        )
                        Text(
                            text = "$120.00",
                            fontSize = 38.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )


                    }
                    Column (
                        modifier =  Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(40.dp)
                    ){
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround,
                        ) {
                            IconBox(icon = painterResource(id = R.drawable.wallett), size = 70)
                            IconBox(icon = painterResource(id = R.drawable.transfer), size = 70)
                            IconBox(icon = painterResource(id = R.drawable.atm), size = 70)
                        }
                        Button(
                            onClick = {

                                navController.navigate("LoanCalculator")
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF011F41), // dark blue
                                contentColor = Color.White // white
                            ),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .fillMaxWidth(.9f)
                                .height(60.dp)
                        ) {
                            Text("Apply For Loan", fontSize = 18.sp)
                        }
                    }

                }

            }

        }
        // History
        Column (  modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp)) {
            Column(
                modifier = Modifier
//                .fillMaxWidth()
                    .padding(horizontal = 24.dp , vertical = 10.dp),
            ) {

                Text(text = "History", fontSize = 16.sp,)
            }
            Column (
                modifier = Modifier
                    .verticalScroll(scrollState)

            ){
                loan(icon = painterResource(id = R.drawable.shopify))
                loan(icon = painterResource(id = R.drawable.shopify))
                loan(icon = painterResource(id = R.drawable.shopify))


            }
        }
    }

}

@Composable
fun loan(icon: Painter){
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp, horizontal = 24.dp)
    ){

        Row (
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically

        ){

            Box(modifier = Modifier.wrapContentSize()) {
                // Create another box that covers the icon
                Box(
                    modifier = Modifier
                        // Match the size of the icon
                        .size(50.dp)
                        // Clip the box to a circle shape
                        .clip(RoundedCornerShape(50.dp))

                        // Set the background color to white
                        .background(Color(0xFFECECEC))
                )
                // Create an icon from a vector drawable resource
                Icon(
                    painter = icon,
                    contentDescription = "icon",
                    // Set the tint color of the icon
                    tint = Color.Unspecified,
                    // Set the size of the icon
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.Center)
                )
            }
            Column (
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ){

                Text(text = "paypal", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                Text(text = "6:25 pm", fontSize = 10.sp, color = Color.Gray)
            }
        }


       Column (
           horizontalAlignment = Alignment.End
       ) {
           Text(text = "$200.00", fontSize = 12.sp, fontWeight = FontWeight.Medium ,)
           Text(text = "paid", fontSize = 10.sp, fontWeight = FontWeight.Medium , color = Color.Gray ,)

       }


    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoanCalculatorScreen(navController: NavController){
    Column {
        Row (
            modifier = Modifier
                .padding(24.dp),
            horizontalArrangement = Arrangement.spacedBy(40.dp, alignment = Alignment.CenterHorizontally)
        ){
           Button(onClick = { navController.navigate("ApllyLoan") },
                   colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
           ) {

               Image(painter = painterResource(id = R.drawable.left_arrow), contentDescription = null )
           }
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "Loan Calculator",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "How much do you want",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Gray

                )
            }
        }

        Row (
            modifier = Modifier
                .padding(24.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ){
            var text by remember { mutableStateOf("\$3500.00") }

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(.5f),
                value = text,
                onValueChange = {
                    text = it
                },
                label = {
                    Text("Amount")
                }
            )
            OutlinedTextField(

                value = "36 Months",
                onValueChange = {
                    text = it
                },
                label = {
                    Text("Duration")
                }
            )

        }


        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            NumberList()
            Divider(color = Color.Gray, modifier = Modifier.width(.5.dp).fillMaxHeight())
            MonthsList()
        }



    }
}

@Composable
fun NumberList() {
    Column (
        modifier = Modifier
            .fillMaxHeight()
            .padding(bottom = 50.dp),
        verticalArrangement = Arrangement.Center
    ){
        LazyColumn {
            items(10) { index ->
                var number = 10_000 - index * 1_000
                Row(
                    modifier = Modifier.padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Divider(
                        color = Color(0xFFE9E9E9),
                        thickness = 2.dp,
                        modifier = Modifier.width(24.dp)
                    )
                    Text(
                        text = "${number / 1000}k",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(8.dp)
                    )

                }
                Divider(
                    color = Color(0xFFE9E9E9),
                    thickness = 2.dp,
                    modifier = Modifier.width(14.dp)
                )


            }
        }
    }
}


@Composable
fun MonthsList() {
    Column (
        modifier = Modifier
            .fillMaxHeight()
            .padding(bottom = 50.dp),
        verticalArrangement = Arrangement.Center,
    ){
        LazyColumn (
            horizontalAlignment = Alignment.End
        ) {
            items(5) { index ->
                var month = 12 + index * 6
                Row(
                    modifier = Modifier.padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {


                    Text(
                        text = "${month } Months",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(8.dp)
                    )
                    Divider(
                        color = Color(0xFFE9E9E9),
                        thickness = 2.dp,
                        modifier = Modifier.width(24.dp)
                    )

                }
                Divider(
                    color = Color(0xFFE9E9E9),
                    thickness = 2.dp,
                    modifier = Modifier.width(14.dp)
                )


            }
        }
    }
}