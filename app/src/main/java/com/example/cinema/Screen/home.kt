

package com.example.cinema.Screen

import MovieGrid
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.*
import com.example.cinema.ui.theme.CinemaTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import com.example.cinema.Componenets.Carousel
import com.example.cinema.R
import com.example.cinema.Componenets.CustomBottomBar
import com.example.cinema.Componenets.Movie


open class home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CinemaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Home(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home(modifier: Modifier) {
    val scrollState = rememberScrollState()
    val movies = listOf(
        Movie("Lilo & Stitch", "Comedy", 8.2f, R.drawable.lilo_stitch,  R.string.lilo_stitch,"1.5Hour",R.drawable.lilo_ticket,"https://m.imdb.com/video/vi493340953/?playlistId=tt11655566&ref_=ext_shr_lnk"),
        Movie("Alone", "Horror", 8.1f, R.drawable.alone, R.string.Alone,"2Hour",R.drawable.alone_ticket,"https://youtu.be/NoP2mJiCzWQ?si=gKkMFDjxtUZUf1Dt"),
        Movie("L'Histoire de souleymane", "Drame", 7.1f, R.drawable.histoire,  R.string.histoire,"2Hour",R.drawable.histoire_ticket,"https://youtu.be/CCMvdrBkb6w?si=N3n7XNzWHcEV7WHU"),
        Movie("Alice In WonderLnad", "Funny", 8.2f, R.drawable.alice, R.string.Alice_In_WonderLnad,"2Hour",R.drawable.alice__ticket," https://youtu.be/9POCgSRVvf0?si=GWYN_NumJTXTadBT"),
        Movie("The nun", "Horror", 7.9f, R.drawable.the_nun,R.string.The_nun,"2.5Hour",R.drawable.the_nun_ticket,"https://youtu.be/QF-oyCwaArU?si=0TQjI58IGkP-lwcO"),
        Movie("The Fall Guy", "Action", 7.1f, R.drawable.the_fall_guy,  R.string.the_fall_guy,"2Hour",R.drawable.fall_ticket,"https://youtu.be/j7jPnwVGdZ8?si=tOO5ODwBqT8Ve6J3"),
        Movie("Paddington", "Funny", 7.1f, R.drawable.paddington,R.string.Paddington,"2Hour",R.drawable.paddington_ticket,"https://youtu.be/W5tUEw4Nq4E?si=LoIeDicVRYDdMnhx"),
        Movie("Night House", "Horror", 5.6f, R.drawable.night_house,R.string.night_house,"2Hour",R.drawable.the_night_ticket,"https://youtu.be/2Tshycci2ZA?si=MF-ZJalODVzZwfyU"),
        Movie("Le Mal n'exist pas", "Drame", 7.1f, R.drawable.le_mal,R.string.le_mal,"2Hour",R.drawable.le_mal_ticket,"https://youtu.be/ypT0nnnnXxM?si=Cc-Mb9Xlmem32Cf5"),
        Movie("The Fox And The Hound", "Funny", 5.6f, R.drawable.the_fox,R.string.The_Fox_And_The_Hound,"2Hour",R.drawable.the_fox_ticket,"https://youtu.be/TpnWMd8IMnk?si=M2EIYNaG9H56jKvr"),
        Movie("John Wick", "Crime", 7.4f, R.drawable.john_wick,R.string.john_wick,"2Hour",R.drawable.john_ticket,"https://m.imdb.com/video/vi3203841305/?playlistId=tt6146586&ref_=ext_shr_lnk"),
        Movie("it", "Horror", 7.1f, R.drawable.it,R.string.it,"2Hour",R.drawable.it_ticket,"https://m.imdb.com/video/vi1396095257/?playlistId=tt1396484&ref_=ext_shr_lnk"),
        Movie("The Cat in The Hat", "Funny", 6.6f, R.drawable.the_cat,R.string.The_Cat_in_the_Hat,"2Hour",R.drawable.the_cat_ticket,"https://youtu.be/oIPq9Kp-9A0?si=jukQLg7-8kZ4eHH0"),
        Movie("Le comte de Montecristo", "Aventure", 5.6f, R.drawable.le_comte,R.string.le_comte,"2Hour",R.drawable.comet_ticket,"https://youtu.be/u0YnbsyvGS0?si=KVvCwWod70G4xIwT"),
        Movie("The Last Voyage", "Horror", 7.1f, R.drawable.the_last_voyage,R.string.The_Last_Voyage,"2Hour",R.drawable.last__ticket,"https://youtu.be/eQUBghzpgzA?si=xbBecIr53CuJWvru"),
        Movie("The adventures of Tintin", "Funny", 5.6f, R.drawable.the_adventures_of_tintin,R.string.The_adventures_of_tintin,"2Hour",R.drawable.tintin_ticket,"https://youtu.be/LTnCE_SaU38?si=CNYnd2ityi1MIJlg"),
        Movie("Unfortunate Events", "Funny", 7.1f, R.drawable.unfortunate_events,  R.string.Unfortunate_Events,"2Hour",R.drawable.unfortunate_ticket,"https://youtu.be/Tup-5yOcJuM?si=V4tE_jQv1dGOLhoc"),

    )
    val context: Context = LocalContext.current
    var search by remember { mutableStateOf(TextFieldValue()) }

    Scaffold(
        bottomBar = { CustomBottomBar("Home",context) }
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = "background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Column(
            modifier = Modifier
//                .verticalScroll(scrollState)
                .padding(10.dp)
        ) {
            Carousel(modifier = Modifier, onClick = {})

            OutlinedTextField(
                label = { Text(text = "Search", color = Color.White, fontSize = 16.sp) },
                singleLine = true,
                value = search,
                leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "", tint = Color.White) },
                onValueChange = {search=it},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),  // حواف فوق وتحت
                shape = RoundedCornerShape(100.dp)
            )

            // جزء الأفلام
            Column(modifier = Modifier.padding(top = 8.dp, bottom =100.dp)
                ) {


                Row {
                    MovieGrid(movies = movies)
                }

            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    CinemaTheme {
        Home(modifier = Modifier)
    }
}