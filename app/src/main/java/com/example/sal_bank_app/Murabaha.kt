package com.example.sal_bank_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MurabahScreen(){
    Column {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ){
            Text(text = "Credit", fontSize = 18.sp,)
            Text(text = "we don’t charge and fees for spending & don’t mark up the rate", fontSize = 18.sp, color = Color.Gray)
            Image(painter = painterResource(id = R.drawable.mrbha), contentDescription = null, contentScale = ContentScale.Fit)
            Text(text = "All Loan Plans" , textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth())

            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxWidth(.5f)
                        .padding(10.dp)
                        .background(Color(0xFFFAFAFA)),
                ){

                Row(
                    modifier = Modifier.fillMaxWidth().padding( 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.education),
                        contentDescription = null
                    )
                    Column {
                        Text(text = "Home Loan")
                        Text(text = "up to 30,000", fontSize = 8.sp, color = Color.Gray)
                        Text(text = "Application", fontSize = 8.sp, color = Color.Gray)
                    }
                }
            }

                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .background(Color(0xFFFAFAFA)),
                ){
                Row(
                    modifier = Modifier.fillMaxWidth().padding( 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.home_loan),
                        contentDescription = null
                    )
                    Column {
                        Text(text = "Home Loan")
                        Text(text = "up to 30,000", fontSize = 8.sp, color = Color.Gray)
                        Text(text = "Application", fontSize = 8.sp, color = Color.Gray)
                    }
                }
            }
            }
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxWidth(.5f)
                        .padding(10.dp)
                        .background(Color(0xFFFAFAFA))
                        .clip( RoundedCornerShape(10.dp)),
                ){
                Row(
                    modifier = Modifier.fillMaxWidth().padding( 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.business),
                        contentDescription = null
                    )
                    Column {
                        Text(text = "Home Loan")
                        Text(text = "up to 30,000", fontSize = 8.sp, color = Color.Gray)
                        Text(text = "Application", fontSize = 8.sp, color = Color.Gray)
                    }
                }
            }

                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .background(Color(0xFFFAFAFA)),
                ){
                    Row(

                        modifier = Modifier.fillMaxWidth().padding( 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.special),
                            contentDescription = null
                        )
                        Column {
                            Text(text = "Home Loan")
                            Text(text = "up to 30,000", fontSize = 8.sp, color = Color.Gray)
                            Text(text = "Application", fontSize = 8.sp, color = Color.Gray)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun LoanType(){

    Row (
        modifier = Modifier
            .fillMaxWidth(.5f)
            .padding(10.dp)
            .background(Color.Red),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ){
        Image(painter = painterResource(id = R.drawable.education), contentDescription = null)
        Column {
            Text(text = "Home Loan")
            Text(text = "up to 30,000")
            Text(text = "Application")
        }
    }

}
