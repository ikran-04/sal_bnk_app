package com.example.sal_bank_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController){
    Box {
        Image(painter = painterResource(id = R.drawable.login_img), contentDescription = null)
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
            ){
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(25.dp, alignment = Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Column (

                    verticalArrangement = Arrangement.spacedBy(15.dp, alignment = Alignment.CenterVertically),
                ) {
                    Text(text = "Hello Again",
                        modifier = Modifier.fillMaxWidth(), fontSize = 32.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center , color = Color(0xFF585858))
                    Text(text = "Welcome Back You’ve\n" +
                            "Been Missed", Modifier.fillMaxWidth(),fontSize = 20.sp, color = Color.Gray, textAlign = TextAlign.Center
                    )
                }
                Column ( modifier = Modifier
                    .fillMaxWidth(),
                      ) {
                    UserNameAndPassword()

                }
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
                        .height(52.dp)
                ) {

                    Text("Send", fontSize = 18.sp)
                }
            }

        }

//        Image(painter = painterResource(id = R.drawable.login_img2), contentDescription = null)

    }

}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        singleLine = true,
        shape = RoundedCornerShape(14.dp),
        visualTransformation = PasswordVisualTransformation(),
        colors =
        TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.White,
            focusedBorderColor =Color(0xFFF3F3F3),
            unfocusedBorderColor =Color(0xFFF3F3F3),
            unfocusedLabelColor = Color.Gray,

            textColor = Color.Gray
        ),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserNameAndPassword() {
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column (
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(5.dp, alignment = Alignment.CenterVertically),
    ){
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = userName,
            onValueChange = { userName = it },
            label = { Text("Pin") },
            singleLine = true,
            shape = RoundedCornerShape(14.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = Color.White, focusedBorderColor =Color(0xFFF3F3F3) ,unfocusedLabelColor = Color.Gray, unfocusedBorderColor =Color(0xFFF3F3F3), textColor = Color.Gray ),
        )
        PasswordTextField(
            value = password,
            onValueChange = { password = it },
            label = "OTP Code"
        )
    }
}

