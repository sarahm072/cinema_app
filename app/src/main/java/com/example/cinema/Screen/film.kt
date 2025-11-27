package com.example.cinema.Screen

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.compose.ui.res.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cinema.R
import com.example.cinema.ui.theme.CinemaTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import android.content.Intent
import androidx.activity.compose.setContent
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.clickable
import android.net.Uri

class film : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
            val title = intent.getStringExtra("title") ?: "Unknown Title"
            val genre = intent.getStringExtra("genre") ?: "Unknown Genre"
            val rating = intent.getFloatExtra("rating", 0f)
            val imageId = intent.getIntExtra("imageId", R.drawable.the_cat)
            val sinario = intent.getIntExtra("sinario" ,R.string.The_Cat_in_the_Hat)
            val time = intent.getStringExtra("time") ?:"2 Hour"
           val ticket= intent.getIntExtra("ticket", R.drawable.the_fox_ticket);
            val url = intent.getStringExtra("url") ?: "Unknown url"

        setContent {
            CinemaTheme {
                FilmScreen(modifier=Modifier ,title, genre, rating, imageId,sinario,time, ticket,url )
            }
        }

        }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
 fun FilmScreen(modifier: Modifier,
           title: String,
           genre: String,
           rating: Float,
           imageId: Int,
            sinario: Int,
            time:String,
            ticket :Int,
            url: String
 ){
    val context: Context = LocalContext.current
    val scrollState = rememberScrollState()
     Scaffold(topBar = { Row(modifier= Modifier
         .fillMaxWidth()
         .padding(20.dp),
         verticalAlignment = Alignment.CenterVertically,
         horizontalArrangement = Arrangement.Center) {
         Text(text = "Film Detail", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 20.sp)
     }}){
         Box {
             Image(
                 painter = painterResource(id = R.drawable.background),
                 contentDescription = "background",
                 contentScale = ContentScale.Crop,
                 modifier = Modifier.fillMaxSize()
             )
         }
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp)
            .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally){
            Row(modifier = Modifier
                .fillMaxSize()
                .padding(top=20.dp,bottom=20.dp,start=40.dp)
                , horizontalArrangement = Arrangement.SpaceEvenly){
                Card(
                    modifier = Modifier.size(200.dp,250.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, Color.White)){
            Image(painter = painterResource(id = imageId), contentDescription = "",
                    modifier = Modifier.size(250.dp).clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        context.startActivity(intent)
                    })
        }
                Column (modifier = Modifier
                    .fillMaxSize()
                    .padding(top=15.dp,start=20.dp)
                ){
                    Card(colors =  CardDefaults.cardColors(
                        containerColor = colorResource(id = R.color.purple),
                        contentColor = Color.White
                    ),
                        modifier = Modifier.size(60.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, Color.White)){
                        Column (modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center){
                            Image(painter = painterResource(id = R.drawable.play) , contentDescription = "",
                                modifier = Modifier.size(40.dp)
                            )
                            Text(text = genre, fontSize = 12.sp)
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Card(colors =  CardDefaults.cardColors(
                        containerColor = colorResource(id = R.color.purple),
                        contentColor = Color.White
                    ),
                        modifier = Modifier.size(60.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, Color.White)) {
                        Column (modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center){
                            Image(painter = painterResource(id = R.drawable.clock) , contentDescription = "",
                                modifier = Modifier.size(30.dp))
                            Text(text =time , fontSize = 12.sp)

                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Card (colors =  CardDefaults.cardColors(
                        containerColor = colorResource(id = R.color.purple),
                        contentColor = Color.White
                    ),
                        modifier = Modifier.size(60.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, Color.White)) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = Icons.Default.Star, contentDescription = "",
                                modifier = Modifier.size(40.dp)
                            )
                            Text(text ="$rating" , fontSize = 10.sp)

                        }
                    }
                    }
                }

//            Spacer(modifier = Modifier.height(20.dp))
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement =Arrangement.Center ){
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement =Arrangement.Start ){
                Text(text = "       Scenario", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = stringResource(id =sinario), color = Color.White, fontSize = 18.sp, textAlign = TextAlign.Justify, modifier = Modifier.padding(20.dp, 5.dp))
            Column (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
                Button(
                    onClick = {
                        val intent = Intent(context, SeatsScreen::class.java).apply {
                            putExtra("ticket", ticket)
                            putExtra("title", title)
                        }
                        context.startActivity(intent)
                    },
                    modifier = Modifier
                        //                        .wrapContentSize()
                        .fillMaxWidth(0.6f)
                        .padding(top = 16.dp, bottom = 50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.pink))
                ) {
                    Text(
                        text = "GET TICKET",
                        fontSize = TextUnit(16f, TextUnitType.Sp),
                        color = Color.White
                    )
                }
            }
        }
     }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Film() {
    CinemaTheme {
        FilmScreen(modifier = Modifier,"The Cat", "Animation", 4.5f, R.drawable.the_cat, R.string.The_Cat_in_the_Hat,"2 Hour",R.drawable.the_cat_ticket,"")
    }
}