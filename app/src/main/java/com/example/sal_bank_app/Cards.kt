package com.example.sal_bank_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sal_bank_app.ui.theme.Sal_bank_appTheme
import kotlinx.coroutines.delay



class Cards : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Sal_bank_appTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                            CardsScreen()
                }
            }
        }
    }
}

@Composable
fun CardsScreen(){
    CardsSecoundscreen()

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CardsSecoundscreen(){
    val scrollState = rememberScrollState ()
    val cards = listOf(
        R.drawable.card_one,
        R.drawable.card_two,
        R.drawable.card_four,
    )

    Column {

        // header
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = "Cards", fontSize = 20.sp ,fontWeight = FontWeight.Bold )
                Text(text = "2 pyhsical, 1 virtual" ,fontSize = 12.sp , fontWeight = FontWeight.Light)
            }

            Icon(painter = painterResource(id = R.drawable.add_card), contentDescription =null )
        }

        //cards
        Column (modifier = Modifier.padding(horizontal = 24.dp)) {
            val pagerState = rememberPagerState(initialPage = 0)
            Column(
//                      modifier = Modifier.fillMaxSize()
            )

            {
                Text( modifier = Modifier.padding(bottom = 10.dp),text = "Pyhysical Card", fontSize = 18.sp ,fontWeight = FontWeight.Bold )

                HorizontalPager(
                    pageCount = cards.size,
                    state = pagerState,
                    key = { cards[it] },
                    pageSpacing = 20.dp

                )

                {index ->

                    Column(
                    ) {
                        Image(
                            painter = painterResource(id = cards[index]),
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth ,
                            modifier = Modifier
//                                      .fillMaxSize()
//                                .padding(end = 20.dp)

                        )
                    }


                }
                    Text( modifier = Modifier
                        .padding(vertical = 10.dp)
                        .fillMaxWidth(),text = "your physical card is active", textAlign = TextAlign.Center, fontSize = 12.sp)
            }
        }

        //setings
        Column (
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .padding(24.dp)
                .verticalScroll(scrollState)
        ) {

            Column (
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),

                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Text(text = "reset pin code", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                    Icon(
                        painter = painterResource(id = R.drawable.right),
                        contentDescription = null
                    )
                }
            CardSetting("Freeze Card")
            Divider(color = Color(0xFFE9E9E9), thickness = .5.dp)
            CardSetting("Contactless Payment")
            CardSetting("Online Payment")
            CardSetting("ATM Withdraws")
            }


        }
    }
}

@Composable
fun CardSetting(text:String){
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ){

        Row (
        ){


            Column {
                Text(text = text, fontSize = 16.sp, fontWeight = FontWeight.Medium)
            }
        }

        var checked by remember { mutableStateOf(true) }
        Switch(

            checked = checked,
            onCheckedChange = { checked = it },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                uncheckedThumbColor = Color.Gray,
                checkedTrackColor = Color( 0xFF185DAB),
                uncheckedTrackColor = Color.Black
            )

        )
    }
}






