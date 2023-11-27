package com.example.sal_bank_app

import android.content.Context
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.example.sal_bank_app.ui.theme.Sal_bank_appTheme
import com.google.common.util.concurrent.ListenableFuture
import java.util.concurrent.Executor

class Scan : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sal_bank_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QrScreen()
                }
            }
        }
    }
}


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun QrScreen() {

   Column {
       Row(
           modifier = Modifier
               .fillMaxWidth()
               .padding(24.dp),
           verticalAlignment = Alignment.CenterVertically
       ) {
           Image(painter = painterResource(id = R.drawable.left_arrow), contentDescription = null)
           Text(
               text = "Pay", fontSize = 24.sp,
               color = Color.Black,
               textAlign = TextAlign.Center,
               fontWeight = FontWeight.Bold,
               modifier = Modifier.fillMaxWidth()
           )

       }
       Column(
           modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(vertical = 50.dp, horizontal = 24.dp),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.SpaceBetween

       ) {

           Image(painter = painterResource(id = R.drawable.qrcode), contentDescription = null)
           Button(

               onClick = {},
               colors = ButtonDefaults.buttonColors(
                   containerColor = Color(0xFF185DAB), // dark blue
                   contentColor = Color.White // white
               ),
               shape = RoundedCornerShape(10.dp),
               modifier = Modifier
                   .fillMaxWidth(.6f)
                   .height(45.dp)
           ) {

                   Text("View qr code", fontSize = 12.sp)


           }
       }
   }
}

