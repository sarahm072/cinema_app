package com.example.cinema.Componenets

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.cinema.R
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlin.random.Random
import androidx.compose.runtime.MutableState

@SuppressLint("Range")
@Composable
fun ChairGrid(
    seats: List<List<Seat>>,
    onSeatSelected: (Int, Int) -> Unit){
    val rows = 7
    val cols = 6

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (i in 1..2) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "$i", color = Color.White)
                for (j in 0 until cols) {
                    val seat = seats[i - 1][j]
                    ChairButton(
                        onClick = {
                            if (!seat.isTaken) {
                                onSeatSelected(i-1, j)
                            }
                        },
                        color = when {
                            seat.isTaken -> colorResource(id = R.color.pink)
                            seat.isSelected.value -> Color.DarkGray
                            else -> colorResource(id = R.color.gold)
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
        for (i in 3..rows) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "$i", color = Color.White)
                for (j in 0 until cols) {
                    val seat = seats[i - 1][j]
                    ChairButton(
                        onClick = {
                            if (!seat.isTaken) {
                                onSeatSelected(i-1, j)
                            }
                        },
                        color = when {
                            seat.isTaken -> colorResource(
                                id = R.color.pink
                            )
                            seat.isSelected.value -> Color.DarkGray
                            else -> Color.LightGray
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}


data class Seat(
    val isTaken: Boolean,
    var isSelected: MutableState<Boolean> = mutableStateOf(false)
)

fun generateRandomSeats(rows: Int, cols: Int): List<List<Seat>> {
    return List(rows) {
        List(cols) {
            Seat(
                isTaken = Random.nextBoolean()
            )
        }
    }
}

fun calculatePrice(seats: List<List<Seat>>): Int {
    return seats.flatten().count { it.isSelected.value } * 100
}

@Composable
fun ChairButton(onClick: () -> Unit, color: Color) {
    Button(
        onClick = onClick,
        modifier = Modifier.size(40.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ) {

    }
}