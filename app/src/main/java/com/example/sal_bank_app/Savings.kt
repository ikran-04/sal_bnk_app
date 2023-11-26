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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sal_bank_app.ui.theme.Sal_bank_appTheme

class Savings : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sal_bank_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SavingsScreen()
                }
            }
        }
    }
}

@Composable
fun SavingsScreen(){
    Column {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color(0xFF001B3A))
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.saving_bg),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.spacedBy(8.dp , alignment = Alignment.CenterVertically),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Total Balance", fontSize = 14.sp, color = Color.White)
                    Text(
                        text = "\$120.00",
                        fontSize = 24.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }

            }

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ){
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()

                        .clip(shape = RoundedCornerShape(50.dp, 50.dp, 0.dp, 0.dp))
                        .background(Color(0xFFF8F9F9)),
                ) {
            Column (
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 35.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {

//                Button(
//
//                    onClick = {},
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = Color(0xFF185DAB), // dark blue
//                        contentColor = Color.White // white
//                    ),
//                    shape = RoundedCornerShape(10.dp),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(54.dp)
//                ) {
//                    Row (
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement =Arrangement.spacedBy(20.dp, Alignment.CenterHorizontally),
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Icon(painter = painterResource(id = R.drawable.add_rounded), contentDescription =null )
//                        Text("Saving Plant", fontSize = 16.sp)
//                    }
//
//
//                }

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(text = "Savings", fontSize = 20.sp ,fontWeight = FontWeight.Bold )
                        Text(text = "4 saving plans" ,fontSize = 12.sp , fontWeight = FontWeight.Light)
                    }

                    Icon(painter = painterResource(id = R.drawable.add_card), contentDescription =null )
                }

                MianPocket(icon = painterResource(id = R.drawable.shopify))
                ProgressBar(icon = painterResource(id = R.drawable.shopify))
                ProgressBar(icon = painterResource(id = R.drawable.shopify))
                ProgressBar(icon = painterResource(id = R.drawable.shopify))
                ProgressBar(icon = painterResource(id = R.drawable.shopify))

            }

                }


            }
        }
    }
}




@Composable
fun MianPocket(icon: Painter){
    Column (
        modifier = Modifier
            .clip(shape = RoundedCornerShape(8.dp)).background(Color(0xFFECECEC))
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth().height(60.dp).padding(10.dp)

        ) {

            Row(

                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {

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
                Column(
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {

                    Text(text = "dream house", fontSize = 14.sp, fontWeight = FontWeight.Medium)
                    Text(text = "Main pocket of your wallet", fontSize = 10.sp, color = Color.Gray)
                }
            }


            Text(text = "\$200\\\$200", fontSize = 10.sp, fontWeight = FontWeight.Medium)


        }
    }
}

@Composable
fun ProgressBar(icon: Painter){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth().padding(10.dp)

        ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {

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
                Column(
                    verticalArrangement = Arrangement.spacedBy(2.dp),
                    modifier = Modifier.fillMaxWidth(.8f)
                ) {

                    Text(text = "dream house", fontSize = 14.sp, fontWeight = FontWeight.Medium)
                    MyProgressBar(progress = 0.7f)
                }
            }


            Text(text = "\$200\\\$200", fontSize = 8.sp, fontWeight = FontWeight.Medium)


        }

}


@Composable
fun MyProgressBar(progress: Float) {
    LinearProgressIndicator(
        progress = progress,
        modifier = Modifier
            .fillMaxWidth()
            .height(8.dp)
            .clip(RoundedCornerShape(4.dp)) // This will round the corners of the progress bar
    )
}
