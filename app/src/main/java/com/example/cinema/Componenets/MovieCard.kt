package com.example.cinema.Componenets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinema.Screen.Home
import com.example.cinema.ui.theme.CinemaTheme
import android.content.Context
import android.content.Intent
import androidx.annotation.StringRes
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.clickable
import com.example.cinema.R
import com.example.cinema.Screen.Film
import com.example.cinema.Screen.SeatsScreen
import com.example.cinema.Screen.film


data class Movie(
    val title: String,
    val genre: String,
    val rating: Float,
    val imageId: Int,
    @StringRes val sinario: Int,
    val time :String,
    val ticket:Int,
    val url : String
)

@Composable
fun MovieCard(movie: Movie ) {
    val context: Context = LocalContext.current
    Card(
        modifier = Modifier
            .clickable {
                val intent = Intent(context, film::class.java).apply {
                    putExtra("title", movie.title)
                    putExtra("genre", movie.genre)
                    putExtra("rating", movie.rating)
                    putExtra("imageId", movie.imageId)
                    putExtra("sinario", movie.sinario)
                    putExtra("dure", movie.time)
                    putExtra("ticket",movie.ticket)
                    putExtra("url",movie.url)

                }
                context.startActivity(intent)
            }
            .padding(8.dp)
            .width(100.dp)
            .clip(RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(12.dp)
    ) {

        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(movie.imageId),
                contentDescription = movie.title,
//                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )

            // التقييم (Rating)
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(4.dp)
                    .background(Color(0xCCFF9800), RoundedCornerShape(6.dp))
            ) {
                Text(
                    text = movie.rating.toString(),
                    color = Color.White,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                )
            }


            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp)
            ) {
                Text(
                    text = movie.title,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Text(
                    text = movie.genre,
                    color = Color.White.copy(alpha = 0.7f),
                    fontSize = 12.sp
                )
            }
        }
    }
}
