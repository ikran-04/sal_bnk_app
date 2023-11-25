package com.example.sal_bank_app

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
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
                .padding(horizontal = 24.dp),
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
                .padding(top = 24.dp, start = 24.dp, end = 24.dp)
        ) {

            Text(text = "Usage Sammary")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(scrollState),
            ) {
//                AnlyticalCard()

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
                .padding(24.dp)
        ) {
            Congratualtion()
        }



            Row(
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.Bottom


            ) {
                Text(
                    text = "+525.89",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF185DAB)
                )
                Image(
                    painter = painterResource(id = R.drawable.increase),
                    contentDescription = null
                )
                Text(text = "increase")
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                val dataList = mutableListOf(30, 60, 90, 50, 70,10,20)
                val floatValue = mutableListOf<Float>()
                val datesList = mutableListOf("Sun", "Sat", "Mon", "Tue", "Wen","Thr","Fri")

                dataList.forEachIndexed { index, value ->

                    floatValue.add(index = index, element = value.toFloat() / dataList.max().toFloat())

                }

                BarGraph(
                    graphBarData = floatValue,
                    xAxisScaleData = datesList,
                    barData_ = dataList,
                    height = 200.dp,
                    roundType = BarType.TOP_CURVED,
                    barWidth = 8.dp,
                    barColor = Color(0xFF185DAB),
                    barArrangement = Arrangement.SpaceEvenly
                )
            }




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