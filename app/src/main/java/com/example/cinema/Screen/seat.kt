//package com.example.cinema.Screen
//
//
//import android.annotation.SuppressLint
//import android.content.Context
//import android.content.Intent
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.horizontalScroll
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.colorResource
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.TextUnit
//import androidx.compose.ui.unit.TextUnitType
//import androidx.compose.ui.unit.dp
//import com.example.cinema.Componenets.*
//import com.example.cinema.R
//import com.example.cinema.ui.theme.CinemaTheme
//import androidx.compose.ui.tooling.preview.Preview
//
//class SeatsScren : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        val Ticket = intent.getIntExtra("tickte", R.drawable.the_cat_ticket)
//        val Title = intent.getStringExtra("title") ?: "Unknown Title"
//        setContent {
//            CinemaTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Schedulenterface(
//                        modifier = Modifier.padding(innerPadding), Ticket, Title
//                    )
//                }
//            }
//        }
//    }
//}
//
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@Composable
//fun Schedulenterface(modifier: Modifier, Ticket: Int, Title: String) {
//    Scaffold {
//        Surface(color = Color.White) {
//            val context: Context = LocalContext.current
//            val scrollState = rememberScrollState()
//            var prix by remember { mutableStateOf(0) }
//            val seats by remember { mutableStateOf(generateRandomSeats(7, 6)) }
//
//            Box(modifier = Modifier.fillMaxSize()) {
//                Image(
//                    painter = painterResource(id = R.drawable.background),
//                    contentDescription = "Background",
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier.fillMaxSize(),
//                    alpha = 1f
//                )
//
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(20.dp),
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Text(
//                        text = "Select Seats",
//                        fontSize = TextUnit(24f, TextUnitType.Sp),
//                        fontWeight = FontWeight.Bold,
//                        color = Color.White
//                    )
//
//                    Spacer(modifier = Modifier.height(8.dp))
//                    Text(
//                        text = "Screen",
//                        fontSize = TextUnit(16f, TextUnitType.Sp),
//                        color = Color.White
//                    )
//
//                    Spacer(modifier = Modifier.height(15.dp))
//
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .horizontalScroll(scrollState),
//                        horizontalArrangement = Arrangement.spacedBy(10.dp)
//                    ) {
//                        DayButton(day = "Sun", date = "22 Juil")
//                        DayButton(day = "Mon", date = "23 Juil")
//                        DayButton(day = "Tus", date = "24 Juil")
//                        DayButton(day = "Wen", date = "25 Juil")
//                        DayButton(day = "Thu", date = "26 Juil")
//                        DayButton(day = "Fri", date = "27 Juil")
//                        DayButton(day = "Sat", date = "28 Juil")
//                    }
//
//                    Spacer(modifier = Modifier.height(15.dp))
//
//                    Row(
//                        horizontalArrangement = Arrangement.SpaceEvenly,
//                        modifier = Modifier.fillMaxWidth()
//                    ) {
//                        listOf("13:00", "15:00").forEach { time ->
//                            Button(
//                                onClick = {   },
//                                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
//                            ) {
//                                Text(
//                                    text = time,
//                                    fontSize = TextUnit(16f, TextUnitType.Sp),
//                                    color = Color.White
//                                )
//                            }
//                        }
//                    }
//
//                    Spacer(modifier = Modifier.height(15.dp))
//
//                    ChairGrid(seats = seats) { row, col ->
//                        seats[row][col].isSelected.value = !seats[row][col].isSelected.value
//                        prix = calculatePrice(seats)
//                    }
//
//                    Legend()
//
//                    Spacer(modifier = Modifier.height(10.dp))
//
//                    Text(
//                        text = "Price: $prix DA",
//                        color = Color.White,
//                        fontWeight = FontWeight.Bold
//                    )
//
//                    Button(
//                        onClick = {
//                            val intent = Intent(context, ticket::class.java).apply {
//                                putExtra("title", Title)
//                                putExtra("ticket", Ticket)
//                            }
//                            context.startActivity(intent)
//                        },
//                        modifier = Modifier
//                            .fillMaxWidth(0.6f)
//                            .padding(top = 16.dp),
//                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.pink))
//                    ) {
//                        Text(text = "Order Now", fontSize = TextUnit(16f, TextUnitType.Sp), color = Color.White)
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun Legend() {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(top = 16.dp),
//        horizontalAlignment = Alignment.Start
//    ) {
//        Row {
//            LegendItem(color = colorResource(id = R.color.pink), label = "Taken")
//            LegendItem(color = Color.LightGray, label = "Available")
//            LegendItem(color = Color.DarkGray, label = "Selected")
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        LegendItem(color = colorResource(id = R.color.gold), label = "VIP")
//    }
//}
//
//
//
//@Composable
//fun LegendItem(color: Color, label: String) {
//    Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
//        Button(
//            onClick = {},
//            modifier = Modifier.size(20.dp),
//            shape = RoundedCornerShape(5.dp),
//            colors = ButtonDefaults.buttonColors(containerColor = color)
//        ) {}
//        Text(text = " $label", color = Color.White)
//    }
//}
//
//
//
//
//xample.cinema.Componenets
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.colorResource
//import androidx.compose.ui.unit.dp
//import com.example.cinema.R
//import kotlin.random.Random
//import androidx.compose.foundation.shape.RoundedCornerShape
//
//data class Seat(
//    val isTaken: Boolean,
//    val isSelected: MutableState<Boolean> = mutableStateOf(false)
//)
//
//fun generateRandomSeats(rows: Int, cols: Int): List<List<Seat>> {
//    return List(rows) {
//        List(cols) {
//            Seat(isTaken = Random.nextBoolean())
//        }
//    }
//}
//
//fun calculatePrice(seats: List<List<Seat>>): Int {
//    return seats.flatten().count { it.isSelected.value } * 100
//}
//
//@Composable
//fun ChairButton(onClick: () -> Unit, color: Color) {
//    Button(
//        onClick = onClick,
//        modifier = Modifier.size(40.dp),
//        shape = RoundedCornerShape(10.dp),
//        colors = ButtonDefaults.buttonColors(containerColor = color)
//    ) {}
//}
//
//@Composable
//fun ChairGrid(
//    seats: List<List<Seat>>,
//    onSeatSelected: (Int, Int) -> Unit
//) {
//    val rows = seats.size
//    val cols = seats[0].size
//
//    Column(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        for (i in 1..2) {
//            Row(
//                horizontalArrangement = Arrangement.SpaceEvenly,
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                Text(text = "$i", color = Color.White)
//                for (j in 0 until cols) {
//                    val seat = seats[i][j]
//                    ChairButton(
//                        onClick = {
//                            if (!seat.isTaken) {
//                                onSeatSelected(i, j)
//                            }
//                        },
//                        color = when {
//                            seat.isTaken -> colorResource(id = R.color.gold)
//                            seat.isSelected.value -> Color.Yellow
//                            else -> Color.LightGray
//                        }
//                    )
//                }
//            }
//            Spacer(modifier = Modifier.height(8.dp))
//        }
//        for (i in 3..rows) {
//            Row(
//                horizontalArrangement = Arrangement.SpaceEvenly,
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                Text(text = "$i", color = Color.White)
//                for (j in 0 until cols) {
//                    val seat = seats[i][j]
//                    ChairButton(
//                        onClick = {
//                            if (!seat.isTaken) {
//                                onSeatSelected(i, j)
//                            }
//                        },
//                        color = when {
//                            seat.isTaken -> Color.Gray
//                            seat.isSelected.value -> Color.Yellow
//                            else -> Color.LightGray
//                        }
//                    )
//                }
//            }
//            Spacer(modifier = Modifier.height(8.dp))
//        }
//    }