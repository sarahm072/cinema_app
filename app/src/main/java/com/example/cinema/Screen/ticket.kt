package com.example.cinema.Screen

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.*
import com.example.cinema.ui.theme.CinemaTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import com.example.cinema.R

class ticket : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val ticket= intent.getIntExtra("ticket",R.drawable.the_fox_ticket)
        val title= intent.getStringExtra("title")?:"Unknown Title"
        setContent {
            CinemaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Ticket_Detail(
                        modifier = Modifier.padding(innerPadding),ticket,title
                    )
                }
            }
        }
    }
}

 @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
 @Composable
fun Ticket_Detail(modifier: Modifier, ticket:Int, title:String){
     Scaffold (topBar = { Row(modifier= Modifier
         .fillMaxSize()
         .padding(top = 30.dp), horizontalArrangement = Arrangement.Center) {
         Text(text = "Ticket Detail", fontWeight = FontWeight.Bold, color = Color.White, fontSize = 22.sp)
     }
         }){
         Surface(color = Color.White) {
            Box{
                Image(painter = painterResource(id = R.drawable.background),
                    contentDescription = "background",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                    )
                val context: Context = LocalContext.current
                Image(painter = painterResource(id=ticket),
                    contentDescription = "ticket",
                    modifier = modifier.fillMaxSize().padding(start=20.dp,end=20.dp)
                )
                Column(modifier=Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom) {

                    Text(
                        text = title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Sun, June 20     Time: 3:30 pm",
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Row: D     Seats: 1,2,3",
                        fontSize = 16.sp,
                        color = Color.Black
                    )

                    Image(painter = painterResource(id = R.drawable.code),
                        contentDescription ="Code",
                        modifier=Modifier.fillMaxWidth(1f) )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = { val intent = Intent(context, payment::class.java)
                            context.startActivity(intent) },
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                            .padding(top = 16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.pink))
                    ) {
                        Text(text = "Buy Ticket", fontSize = TextUnit(16f, TextUnitType.Sp), color = Color.White)
                    }
                    Spacer(modifier = Modifier.height(50.dp))

                }
            }
         }
     }
}

  @Preview(showBackground = true, showSystemUi = true)
  @Composable
   fun Ticket(){
    CinemaTheme {
        Ticket_Detail(modifier = Modifier,R.drawable.tintin_ticket,"The cat")
    }
}