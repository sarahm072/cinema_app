package com.example.cinema.Componenets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp


@Composable
fun DayButton(day:String,date:String) {
    var colorButton=Color.Gray
     Button(onClick = { colorButton = Color.Black },
         colors = ButtonDefaults.buttonColors(containerColor = colorButton)) {
         Column(
             modifier = Modifier,
             horizontalAlignment = Alignment.CenterHorizontally,
             verticalArrangement = Arrangement.Center
         ) {
             Text(
                 text = day,
                 fontSize = TextUnit(16f, TextUnitType.Sp),
                 color = Color.White
             )
             Text(
                 text = date,
                 fontSize = TextUnit(16f, TextUnitType.Sp),
                 color = Color.White
             )
         }

     }
 }