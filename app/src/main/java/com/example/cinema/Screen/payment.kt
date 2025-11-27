package com.example.cinema.Screen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinema.R
import com.example.cinema.ui.theme.CinemaTheme
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions

class payment : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CinemaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Payment_Screen(
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Payment_Screen(modifier: Modifier) {
    var card_number by remember { mutableStateOf(TextFieldValue("")) }
    var date by remember { mutableStateOf(TextFieldValue("")) }
    var cvv2 by remember { mutableStateOf(TextFieldValue("")) }
    var phone_num by remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(topBar = {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp), horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Payment Detail",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 22.sp
            )
        }
    }) {
        Surface(color = Color.White) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.background),
                    contentDescription = "background",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Column (modifier=Modifier.fillMaxSize(),
//                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(painter = painterResource(id = R.drawable.carte),
                        contentDescription ="",
                        modifier=Modifier.size(350.dp) )
                    Text("Enter card details", color = Color.White, fontSize = 20.sp)

                    OutlinedTextField(
                        value = card_number,
                        onValueChange = {  card_number = it },
                        label = { Text("Card number") },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.LightGray,
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.Gray
                        ),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = date,
                        onValueChange = { date = it },
                        label = { Text("Expiry date (MM/YY)") },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.LightGray,
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.Gray
                        ),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number)

                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = cvv2,
                        onValueChange = { cvv2 = it },
                        label = { Text("CVV") },
                        visualTransformation = PasswordVisualTransformation(),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.LightGray,
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.Gray
                        ),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number)

                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = phone_num,
                        onValueChange = { phone_num = it },
                        label = { Text("Phone number") },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.LightGray,
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.Gray
                        ),
                        keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Phone)
                    )
                    Button(
                        onClick = {  },
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                            .padding(top = 16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.pink))
                    ) {
                        Text(text = "Payment", fontSize = TextUnit(16f, TextUnitType.Sp), color = Color.White)
                    }
                    Spacer(modifier = Modifier.height(50.dp))

                }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Payment(){
    CinemaTheme {
        Payment_Screen(modifier = Modifier)
    }
}