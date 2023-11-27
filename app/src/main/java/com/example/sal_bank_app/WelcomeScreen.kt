package com.example.sal_bank_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun GetStarted(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(40.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.getstated), contentDescription =null )
        Text(text = "Let’s get started", fontSize = 20.sp,textAlign = TextAlign.Center)
        Text(text = "Never a better time than now\n" +
                "to start all your finances with ease.", fontSize = 15.sp, color = Color.Gray, textAlign = TextAlign.Center)
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(
                color = Color(0xFF185DAB),
                thickness = 6.dp,
                modifier = Modifier.width(25.dp)
            )
            Divider(
                color = Color(0xFFE9E9E9),
                thickness = 2.dp,
                modifier = Modifier.width(25.dp)
            )
            Divider(
                color = Color(0xFFE9E9E9),
                thickness = 2.dp,
                modifier = Modifier.width(20.dp)
            )
        }
        Button(
            onClick = {

                navController.navigate("Registration")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF185DAB), // dark blue
                contentColor = Color.White // white
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth(.5f)
                .height(46.dp)
        ) {
            Text("Create Acount", fontSize = 18.sp, color = Color.White)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Regestration(navController: NavController){
    val scrollState = rememberScrollState()
    var phoneNumber by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(24.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.getstated), contentDescription =null )
        Text(text = "Registration", fontSize = 20.sp,textAlign = TextAlign.Center)
        Text(text = "Never a better time than now Enter Your Phone Number  to Verify\n" +
                " Your account", fontSize = 15.sp, color = Color.Gray, textAlign = TextAlign.Center)
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Divider(
                color = Color(0xFFE9E9E9),
                thickness = 2.dp,
                modifier = Modifier.width(25.dp)
            )
            Divider(
                color = Color(0xFF185DAB),
                thickness = 6.dp,
                modifier = Modifier.width(25.dp),
            )
            Divider(
                color = Color(0xFFE9E9E9),
                thickness = 2.dp,
                modifier = Modifier.width(20.dp)
            )
        }
        Column (
            modifier = Modifier
                .fillMaxWidth(.8f)
                .clip(shape = RoundedCornerShape(14.dp))
        ){

            Column(
                verticalArrangement = Arrangement.spacedBy(
                    40.dp,
                    alignment = Alignment.CenterVertically
                ),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFAFAFA))
                    .padding(20.dp)
            ) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.som),
                            tint = Color.Unspecified,
                            modifier = Modifier.offset(x = 8.dp),
                            contentDescription = null
                        )
                    },
                    trailingIcon = {  Icon(
                        painter = painterResource(id = R.drawable.check),
                        tint = Color.Unspecified,
                        contentDescription = null
                    )},
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it },
                    placeholder = { Text(text = "(+252) 615 444 545", fontSize = 10.sp, color = Color.Gray) },
                    singleLine = true,
                    shape = RoundedCornerShape(14.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.White,
                        focusedBorderColor = Color(0xFFF3F3F3),
                        unfocusedLabelColor = Color.Gray,
                        unfocusedBorderColor = Color(0xFFF3F3F3),
                        textColor = Color.Gray
                    ),
                )
                Button(
                    onClick = {

                        navController.navigate("otp_screen")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF185DAB), // dark blue
                        contentColor = Color.White // white
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(46.dp)
                ) {
                    Text("Continue", fontSize = 18.sp, color = Color.White)
                }
            }
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Otp(navController: NavController){
    val scrollState = rememberScrollState()

    var otpValue by remember {
        mutableStateOf("")
    }
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(24.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.getstated), contentDescription =null )
        Text(text = "Registration", fontSize = 20.sp,textAlign = TextAlign.Center)
        Text(text = "Enter The 4 digit code sent to \n" +
                "your mobile number", fontSize = 15.sp, color = Color.Gray, textAlign = TextAlign.Center)
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Divider(
                color = Color(0xFFE9E9E9),
                thickness = 2.dp,
                modifier = Modifier.width(25.dp)
            )

            Divider(
                color = Color(0xFFE9E9E9),
                thickness = 2.dp,
                modifier = Modifier.width(20.dp)
            )
            Divider(
                color = Color(0xFF185DAB),
                thickness = 6.dp,
                modifier = Modifier.width(25.dp),
            )
        }
        Column (
            modifier = Modifier
                .fillMaxWidth(.8f)
                .clip(shape = RoundedCornerShape(14.dp))
        ){

            Column(
                verticalArrangement = Arrangement.spacedBy(
                    40.dp,
                    alignment = Alignment.CenterVertically
                ),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFAFAFA))
                    .padding(20.dp)
            ) {
                OtpTextField(
                    otpText = otpValue,
                    onOtpTextChange = { value, otpInputFilled ->
                        otpValue = value
                    }
                )
                Button(
                    onClick = {

                        navController.navigate("main_screen")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF185DAB), // dark blue
                        contentColor = Color.White // white
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(46.dp)
                ) {
                    Text("Continue", fontSize = 18.sp, color = Color.White)
                }
            }
        }
    }
}


@Composable
fun OtpTextField(
    modifier: Modifier = Modifier,
    otpText: String,
    otpCount: Int = 4,
    onOtpTextChange: (String, Boolean) -> Unit
) {
    LaunchedEffect(Unit) {
        if (otpText.length > otpCount) {
            throw IllegalArgumentException("Otp text value must not have more than otpCount: $otpCount characters")
        }
    }

    BasicTextField(
        modifier = modifier,
        value = TextFieldValue(otpText, selection = TextRange(otpText.length)),
        onValueChange = {
            if (it.text.length <= otpCount) {
                onOtpTextChange.invoke(it.text, it.text.length == otpCount)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        decorationBox = {
            Row(horizontalArrangement = Arrangement.Center) {
                repeat(otpCount) { index ->
                    CharView(
                        index = index,
                        text = otpText
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    )
}

@Composable
private fun CharView(
    index: Int,
    text: String
) {
    val isFocused = text.length == index
    val char = when {
        index == text.length -> ""
        index > text.length -> ""
        else -> text[index].toString()
    }
    Column (
        modifier = Modifier
            .width(40.dp)
            .height(50.dp)
            .border(
                .5.dp, when {
                    isFocused -> Color(0xFF185DAB)
                    else -> Color.Gray
                }, RoundedCornerShape(5.dp)
            )
            .padding(2.dp),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = char,
            //        style = MaterialTheme.typography.h4,
            color = if (isFocused) {
                Color(0xFF185DAB)
            } else {
                Color.Gray
            },
            textAlign = TextAlign.Center
        )
    }
}