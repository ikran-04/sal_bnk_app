package com.example.sal_bank_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                   HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen(){
    val scrollState = rememberScrollState ()
    val Green = Color(0xFF0EB400)
    val Orange = Color(0xFFFF5C00)
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
                        IconBox(icon = painterResource(id = R.drawable.wallett), size = 50)
                        IconBox(icon = painterResource(id = R.drawable.transfer), size = 50)
                        IconBox(icon = painterResource(id = R.drawable.atm), size = 50)
                        IconBox(icon = painterResource(id = R.drawable.wallett), size = 50)
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


@Composable
fun IconBox(lable:String="", icon: Painter, size: Int){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(modifier = Modifier.wrapContentSize()) {
            // Create another box that covers the icon
            Box(
                modifier = Modifier
                    // Match the size of the icon
                    .size(size.toInt().dp)
                    // Clip the box to a circle shape
                    .clip(RoundedCornerShape(10.dp))

                    // Set the background color to white
                    .background(Color(0xFF011F41))
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
        Text(
            text = lable,
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.White,
            ),
            textAlign = TextAlign.Center,
            // Align the text to the bottom center of the box
            modifier = Modifier.padding(top = 8.dp)
        )
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

