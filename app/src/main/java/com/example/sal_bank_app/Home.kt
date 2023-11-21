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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sal_bank_app.ui.theme.Sal_bank_appTheme

class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sal_bank_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   HomeScreee()
                }
            }
        }
    }
}

@Composable
fun HomeScreee(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home_screen") {
        composable("Home_screen") { HomeScreen(navController) }
        composable("Wallet") { Wallet(navController) }
        composable("LoanCalculator") { LoanCalculatorScreen(navController) }
        composable("ApprovedLoan") { ApprovedLoan(navController) }
    }
}
@Composable
fun HomeScreen(navController: NavController){
    val scrollState = rememberScrollState ()
    Column {

        // header
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = "Welcome back!", fontSize = 12.sp , fontWeight = FontWeight.Light)
                Text(text = "John Doe!" ,fontWeight = FontWeight.Bold)
            }

            Icon(Icons.Outlined.Notifications, contentDescription =null )
        }




        Box(
            modifier = Modifier.height(200.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.blance_bg),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Column(
//                modifier = Modifier.fillMaxSize()
            ) {
                Column (

                    modifier = Modifier
                        .padding(24.dp)
                        .fillMaxHeight()
                    ,
                    horizontalAlignment= Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                ) {


                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(text = "Balance!", fontSize = 12.sp , fontWeight = FontWeight.Light,color = Color.White)
                            Text(text = "$120.00" , fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        }
                        Row (
                            horizontalArrangement = Arrangement.spacedBy(5.dp)
                        ) {
                            Icon(painter = painterResource(id = R.drawable.noto_coin), contentDescription = null, tint = Color.Unspecified)
                            Text(text = "9.500" ,  style = TextStyle(
                                fontSize = 15.sp,
                                color = Color.White,
                            ),)
                        }
                    }
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                            IconBox(icon = painterResource(id = R.drawable.wallett), size = 50, route = "Wallet", navController = navController)

                        IconBox(icon = painterResource(id = R.drawable.transfer), size = 50, route = "",navController = navController)
                        IconBox(icon = painterResource(id = R.drawable.atm), size = 50 ,route = "",navController = navController)
                        IconBox(icon = painterResource(id = R.drawable.wallett), size = 50,route = "",navController = navController)
                    }
                }
            }
        }


        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Statement"  ,fontSize = 16.sp , fontWeight = FontWeight.Bold)
            Box(modifier = Modifier
                .wrapContentSize()
                .clip(RoundedCornerShape(20.dp))) {
                Text(
                    text = "view all",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color.White,
                    ),
                    modifier = Modifier
                        .background(Color(0xFF185DAB))
                        .padding(horizontal = 20.dp, vertical = 6.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .clip(RoundedCornerShape(30.dp))
                        .padding(10.dp)
                )
            }
        }

        // today
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

                Text(text = "Today", fontSize = 12.sp, color = Color.Gray)
                Text(text = "\$350.00", fontSize = 12.sp, color = Color.Gray)
            }
            Column (
                modifier = Modifier
                    .verticalScroll(scrollState)

            ){
                Transaction(icon = painterResource(id = R.drawable.shopify))
                Transaction(icon = painterResource(id = R.drawable.shopify))

            }
        }
        // yester day
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

                Text(text = "Yesterday", fontSize = 12.sp, color = Color.Gray)
                Text(text = "\$350.00", fontSize = 12.sp, color = Color.Gray)
            }
            Column (
                modifier = Modifier
                    .verticalScroll(scrollState)

            ){
                Transaction( icon = painterResource(id = R.drawable.shopify))
                Transaction(icon = painterResource(id = R.drawable.shopify))
                Transaction(icon = painterResource(id = R.drawable.shopify))
                Transaction(icon = painterResource(id = R.drawable.shopify))
                Transaction(icon = painterResource(id = R.drawable.shopify))
                Transaction(icon = painterResource(id = R.drawable.shopify))

            }
        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Wallet(navController: NavController){
    Column {
        Box(
            modifier = Modifier.height(200.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.blance_bg),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Column(
//                modifier = Modifier.fillMaxSize()
            ) {
                Column (

                    modifier = Modifier
                        .padding(24.dp)
                        .fillMaxHeight()
                    ,
                    verticalArrangement = Arrangement.SpaceBetween,
                ) {


                    Text(text = "Balance!", fontSize = 24.sp , fontWeight = FontWeight.Medium,color = Color.White)
                    Column (
                        modifier = Modifier

                            .clip(shape = RoundedCornerShape(8.dp)),

                    ){
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .background(Color.White),
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconBox(
                                icon = painterResource(id = R.drawable.wallett),
                                size = 40,
                                route = "Wallet",
                                lable = "wallet",
                                bgClr = Color(0xFF185DAB),
                                navController = navController
                            )

                            IconBox(
                                icon = painterResource(id = R.drawable.transfer),
                                size = 40,
                                route = "",
                                lable = "Marchant",
                                bgClr = Color(0xFF185DAB),
                                navController = navController
                            )
                            IconBox(
                                icon = painterResource(id = R.drawable.atm),
                                size = 40,
                                route = "",
                                lable = "Express",
                                bgClr = Color(0xFF185DAB),
                                navController = navController
                            )
                            IconBox(
                                icon = painterResource(id = R.drawable.wallett),
                                size = 40,
                                route = "",
                                lable = "Bank",
                                bgClr = Color(0xFF185DAB),
                                navController = navController
                            )

                            IconBox(
                                icon = painterResource(id = R.drawable.transfer),
                                size = 40,
                                route = "",
                                lable = "Taaj",
                                bgClr = Color(0xFF185DAB),
                                navController = navController
                            )
                        }
                    }
                }
            }
        }

        //Wallet
        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 10.dp)
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .imePadding()
                .padding(10.dp),

            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(text = "Wallet" , fontSize = 20.sp, )
            Text(text = "send money to family & friends" , fontSize = 12.sp)
            Person()
            CustomTextField(vlue ="$0", icon = Icons.Outlined.Person)
            CustomTextField(vlue = "$0.0")
            CustomTextField(vlue ="description")

            Button(
                onClick = {

                    navController.navigate("ApprovedLoan")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF185DAB), // dark blue
                    contentColor = Color.White // white
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text("Send", fontSize = 18.sp)
            }

        }
    }
}

@Composable
fun IconBox(lable:String="", icon: Painter,bgClr:Color=Color(0xFF011F41), size: Int,route:String,navController: NavController){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp)


    ){
        Box(modifier = Modifier.wrapContentSize().clickable {    navController.navigate(route) }) {
            // Create another box that covers the icon
            Box(
                modifier = Modifier
                    // Match the size of the icon
                    .size(size.toInt().dp)
                    // Clip the box to a circle shape
                    .clip(RoundedCornerShape(10.dp))

                    // Set the background color to white
                    .background(bgClr)
            )
            // Create an icon from a vector drawable resource
            Icon(
                painter = icon,
                contentDescription = "icon",
                // Set the tint color of the icon
                tint = Color.White,
                // Set the size of the icon
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.Center)
            )
        }

            Text(text = lable , fontSize = 10.sp, color = Color.Gray)



    }


}

@Composable
fun Transaction(icon: Painter){
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


            Text(text = "$200.00", fontSize = 12.sp, fontWeight = FontWeight.Medium ,)


    }
}

@Composable
fun Person(){
    Column (
        modifier = Modifier
            .clip(shape = RoundedCornerShape(8.dp))
    ){

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp))
                .background(Color.White)
                .padding(10.dp)


        ) {

            Row(

                horizontalArrangement = Arrangement.spacedBy(15.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(5.dp)

            ) {

                Box(modifier = Modifier.wrapContentSize()) {
                    // Create another box that covers the icon
                    Box(
                        modifier = Modifier
                            // Match the size of the icon
                            .size(35.dp)
                            // Clip the box to a circle shape
                            .clip(RoundedCornerShape(50.dp))

                            // Set the background color to white
                            .background(Color(0xFFECECEC))
                    )

                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {

                    Text(text = "John", fontSize = 10.sp, fontWeight = FontWeight.Light,color = Color.Gray)
                    Text(text = "252615525252", fontSize = 12.sp )
                }
            }

            Icon(
                painter = painterResource(id = R.drawable.right),
                contentDescription = null
            )


        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(vlue:String, icon: ImageVector? = null ){
    TextField(value = vlue,
        placeholder = { Text(text = "$ Amount", fontSize = 14.sp , color = Color.Gray)},
        onValueChange = {},
        singleLine = true,
        trailingIcon ={
            if (icon != null) {
                Icon(icon,contentDescription = null)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        colors = TextFieldDefaults.textFieldColors(containerColor = Color.Unspecified, unfocusedIndicatorColor = Color.Gray),
        textStyle = LocalTextStyle.current.copy(
            color = Color.Gray,
            fontSize = 10.sp
        ),

        modifier = Modifier.fillMaxWidth()
    )
}
