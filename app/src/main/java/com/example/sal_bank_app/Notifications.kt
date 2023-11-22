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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sal_bank_app.ui.theme.Sal_bank_appTheme

class Notifications : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sal_bank_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NotificationsScreen()
                }
            }
        }
    }
}

@Composable
fun NotificationsScreen(){
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
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(painter = painterResource(id = R.drawable.left_arr_white), contentDescription = null)
                    Text(
                        text = "Notifications", fontSize = 18.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

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
                        verticalArrangement = Arrangement.spacedBy(25.dp)
                    ) {

                        Text(text = "Today", fontSize = 16.sp , color = Color.Gray)
                        MianPocket(icon = painterResource(id = R.drawable.shopify))
                        MianPocket(icon = painterResource(id = R.drawable.shopify))

                        Text(text = "YesterDay", fontSize = 16.sp , color = Color.Gray)
                        MianPocket(icon = painterResource(id = R.drawable.shopify))
                        MianPocket(icon = painterResource(id = R.drawable.shopify))
                        MianPocket(icon = painterResource(id = R.drawable.shopify))




                    }

                }


            }
        }
    }
}