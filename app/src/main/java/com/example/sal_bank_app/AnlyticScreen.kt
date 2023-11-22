package com.example.sal_bank_app

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AnlyticsScreen(){
    val scrollState = rememberScrollState ()
    val anlyticCards = listOf(
        R.drawable.anlytic_card,
        R.drawable.anlytic_card,
        R.drawable.anlytic_card,
        R.drawable.anlytic_card,
        R.drawable.anlytic_card,
        R.drawable.anlytic_card,
    )
    Column {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Activity", fontSize = 18.sp, fontWeight = FontWeight.Medium)
            Image(painter = painterResource(id = R.drawable.gird), contentDescription =null )
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ){
            Row (
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically

            ){
                Image(painter = painterResource(id = R.drawable.income_icon), contentDescription =null)
                Column {
                    Text(text = "Income" , fontSize = 10.sp,color = Color.Gray)
                    Text(text = "\$654,500.5", fontSize = 14.sp , )
                }
            }
            Row (
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically

            ){
                Image(painter = painterResource(id = R.drawable.expenses_icon), contentDescription =null)
                Column {
                    Text(text = "Expenses" , fontSize = 10.sp, color = Color.Gray)
                    Text(text = "\$4,500", fontSize = 14.sp , )
                }
            }
        }


        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {

            Text(text = "Usage Sammary")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(scrollState),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.anlytic_card),
                    contentDescription = null
                )
                Image(
                    painter = painterResource(id = R.drawable.anlytic_card),
                    contentDescription = null
                )
                Image(
                    painter = painterResource(id = R.drawable.anlytic_card),
                    contentDescription = null
                )
                Image(
                    painter = painterResource(id = R.drawable.anlytic_card),
                    contentDescription = null
                )
            }
        }


        Column (
            modifier = Modifier
                .padding(horizontal = 24.dp)
        ) {
            Congratualtion()
        }

        Chart(
            data = mapOf(

                Pair(0.5f,"Sun"),
                Pair(0.6f,"Mon"),
                Pair(0.2f,"Tue"),
                Pair(0.7f,"Wed"),
                Pair(0.4f,"Thu"),
                Pair(0.6f,"Fri"),
                Pair(0.2f,"Sat"),

                ), max_value = 100
        )
      
    }

}


@Composable
fun AnlyticalCard(){
        
}

@Composable
fun Congratualtion(){
    Column (
        modifier = Modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .background(Color(0xFFFAFAFA))
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(10.dp)

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
                            .background(Color.White)
                    )
                    // Create an icon from a vector drawable resource
                    Icon(
                        painter = painterResource(id = R.drawable.shopify),
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




        }
    }
}