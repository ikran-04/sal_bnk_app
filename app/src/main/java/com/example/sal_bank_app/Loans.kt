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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sal_bank_app.ui.theme.Sal_bank_appTheme

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

@Composable
fun LoansScreen(){
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
                            onClick = { /* do something */ },
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


@Composable
fun LoanCalculatorScreen(){

}
