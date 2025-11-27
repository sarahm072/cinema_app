package com.example.cinema

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.*
import androidx.compose.ui.unit.dp
import com.example.cinema.ui.theme.CinemaTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.example.cinema.Componenets.DayButton
import androidx.compose.foundation.horizontalScroll
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.cinema.Componenets.ChairGrid
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import com.example.cinema.Componenets.NextButton
import com.example.cinema.Screen.home
import com.example.cinema.Screen.signup
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CinemaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Start(
                    modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Start(modifier: Modifier){
   Scaffold {
       Surface {
           val context: Context = LocalContext.current
           Box {
               Image(painter = painterResource(id = R.drawable.background2), contentDescription = "start",
                   modifier=Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
               Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(id = R.drawable.photo), contentDescription ="photo", modifier = Modifier.size(200.dp))
                    Spacer(modifier = Modifier.height(8.dp))
                   Text(text = stringResource(id = R.string.start),
                       fontFamily = FontFamily.Default,
                       color = Color.White,
                       fontWeight = FontWeight.SemiBold,
                       textAlign = TextAlign.Center,
                       fontSize = 20.sp,
                       modifier = Modifier.padding(25.dp))
                   Button(
                       onClick = {
                           val intent =Intent(context, signup::class.java)
                           context.startActivity(intent)
                       },
                       modifier = Modifier
                           .fillMaxWidth(0.6f)
                           .padding(top = 16.dp),
                       colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.pink))
                   ) {
                       Text(text = "Get Started",
                           fontSize = TextUnit(16f,
                               TextUnitType.Sp), color = Color.White)
                   }


               }
           }
       }
   }

}
    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun GreetingPreview() {
        CinemaTheme {
            Start(modifier = Modifier)
        }
    }
