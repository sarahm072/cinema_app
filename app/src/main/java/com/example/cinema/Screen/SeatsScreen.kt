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
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.cinema.ui.theme.CinemaTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import com.example.cinema.Componenets.DayButton
import androidx.compose.foundation.horizontalScroll
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.cinema.Componenets.ChairGrid
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.example.cinema.Componenets.calculatePrice
import com.example.cinema.Componenets.generateRandomSeats
import kotlin.random.Random
import com.example.cinema.R

class SeatsScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val ticketId= intent.getIntExtra("ticket",R.drawable.the_cat_ticket)
        val Title = intent.getStringExtra("title")?:"Unknown Title"
        setContent {
            CinemaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ScheduleInterface(
                        modifier = Modifier.padding(innerPadding), ticketId,Title
                    )
                }
            }
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScheduleInterface(modifier: Modifier,ticketId:Int,Title : String) {
    Scaffold {
        Surface(color = Color.White) {
            val context: Context = LocalContext.current
            val scrollState = rememberScrollState()
            var prix by remember{
                mutableStateOf(0)
            }
            var seats = remember { mutableStateOf(generateRandomSeats(7, 7)) }
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.background),
                    contentDescription = "Background",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize(),
                    alpha = 1f
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Select Seats",
                        fontSize = TextUnit(24f, TextUnitType.Sp),
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Screen",
                        fontSize = TextUnit(16f, TextUnitType.Sp),
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Row(
//                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(scrollState),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        DayButton(day = "Sun", date = "22 Juil")
                        DayButton(day = "Mon", date = "23 Juil")
                        DayButton(day = "Tus", date = "24 Juil")
                        DayButton(day = "Wen", date = "25 Juil")
                        DayButton(day = "Thu", date = "26 Juil")
                        DayButton(day = "Fri", date = "27 Juil")
                        DayButton(day = "Sat", date = "28 Juil")
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        var buttonColor13 by remember { mutableStateOf(Color.Gray) } // اللون الافتراضي
                        Button(onClick = { buttonColor13=Color.DarkGray },
                            colors = ButtonDefaults.buttonColors(containerColor = buttonColor13)) {
                            Text(
                                text = "13:00",
                                fontSize = TextUnit(16f, TextUnitType.Sp),
                                color = Color.White
                            )
                        }
                        var buttonColor15 by remember { mutableStateOf(Color.Gray) } // اللون الافتراضي
                        Button(onClick = { buttonColor15=Color.DarkGray },
                            colors = ButtonDefaults.buttonColors(containerColor = buttonColor15)) {
                            Text(
                                text = "15:00",
                                fontSize = TextUnit(16f, TextUnitType.Sp),
                                color = Color.White
                            )
                        }

                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    ChairGrid(seats = seats.value) { row, col ->
                        seats.value[row][col].isSelected.value = !seats.value[row][col].isSelected.value
                        prix = calculatePrice(seats.value)
                    }


                    Row {
                        Row(modifier = Modifier.padding(10.dp)) {
                            Button(
                                onClick = {},
                                modifier = Modifier.size(20.dp),
                                shape = RoundedCornerShape(5.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = colorResource(
                                        id = R.color.pink
                                    )
                                )
                            ) {

                            }
                            Text(text = " Taken", color = Color.White)
                        }
                        Row (modifier = Modifier.padding(10.dp)){
                            Button(
                                onClick = {},
                                modifier = Modifier.size(20.dp),
                                shape = RoundedCornerShape(5.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
                            ) {

                            }
                            Text(text = " Avaible", color = Color.White)
                        }
                        Row(modifier = Modifier.padding(10.dp)) {
                            Button(
                                onClick = {},
                                modifier = Modifier.size(20.dp),
                                shape = RoundedCornerShape(5.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.DarkGray
                                )
                            ) {

                            }
                            Text(text = " Selected", color = Color.White)
                        }
                    }
                    Row {
                        Button(
                            onClick = {},
                            modifier = Modifier.size(20.dp),
                            shape = RoundedCornerShape(5.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(
                                    id = R.color.gold
                                )
                            )
                        ) {

                        }
                        Text(text = " VIP", color = Color.White)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Price: $prix DA", color=Color.White, fontWeight = FontWeight.Bold)
                    Button(
                        onClick = {
                            val intent = Intent(context, ticket::class.java).apply {
                                putExtra("ticket", ticketId)
                                putExtra("title", Title)
                            }
                            context.startActivity(intent)  },
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                            .padding(top = 16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.pink))
                    ) {
                        Text(text = "Order Now", fontSize = TextUnit(16f, TextUnitType.Sp), color = Color.White)
                    }
                }
            }

        }
    }
}







@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SeatScreen() {
    CinemaTheme {
        ScheduleInterface(modifier = Modifier,R.drawable.the_cat_ticket,"The cat")
    }
}