package com.example.cinema.Screen

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.border
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
import androidx.compose.ui.unit.*
import com.example.cinema.ui.theme.CinemaTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.colorResource
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import com.example.cinema.R
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import com.android.volley.DefaultRetryPolicy
import java.lang.reflect.Method
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

open class signup : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CinemaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SignupScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignupScreen(modifier: Modifier) {
    val context: Context = LocalContext.current
    var name by remember { mutableStateOf(TextFieldValue()) }
    var email by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    Surface {
        Scaffold(containerColor = Color.White, contentColor = Color.Black) {innerPadding ->
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = "Sign Up", fontSize = 30.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(40.dp))

                OutlinedTextField(value = name,
                    onValueChange = { name = it },
                    label = { Text(text = "Name") },
                    colors =  OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Black,
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        focusedTextColor= Color.Black,
                        unfocusedTextColor= Color.Black
                        )
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(value = email,
                    onValueChange = { email = it },
                    label = { Text(text = "Email") },
                    colors =  OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Black,
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        focusedTextColor= Color.Black,
                        unfocusedTextColor= Color.Black
                        )
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(value = password,
                    onValueChange = { password = it },
                    visualTransformation = PasswordVisualTransformation(),
                    label = { Text(text = "Password") },
                    colors =  OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Black,
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        focusedTextColor= Color.Black,
                        unfocusedTextColor= Color.Black
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "Already have an account?",
                        modifier = Modifier.clickable {
                            val intent = Intent(context, login::class.java)
                            context.startActivity(intent)
                        },
                        textAlign = TextAlign.End,
                        fontWeight = FontWeight.SemiBold
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "",
                        tint = colorResource(
                            id = R.color.pink
                        )
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = {
                        Toast.makeText(context, "تم التسجيل بنجاح!", Toast.LENGTH_SHORT).show()
                        val intent = Intent(context, home::class.java)
                        context.startActivity(intent)
//                        registerUser(context, name.text, email.text, password.text)
                    },
                    modifier = Modifier
//                        .wrapContentSize()
                        .fillMaxWidth(0.6f)
                        .padding(top = 16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.pink))
                ) {
                    Text(
                        text = "SIGN UP",
                        fontSize = TextUnit(16f, TextUnitType.Sp),
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Or Sign Up with social account")
                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    SocialButton(iconRes = R.drawable.group,"https://accounts.google.com/o/oauth2/v2/auth?as=OBvc-kBx-7ShAX1kVPZ9qw&client_id=705648808057-3chuddbr6oahbebib1uh693k02sgfl30.apps.googleusercontent.com&scope=openid%20email%20profile&response_type=id_token&gsiwebsdk=gis_attributes&redirect_uri=https%3A%2F%2Fwww.freepik.com&response_mode=form_post&origin=https%3A%2F%2Fwww.freepik.com&display=popup&prompt=select_account&gis_params=ChdodHRwczovL3d3dy5mcmVlcGlrLmNvbRIXaHR0cHM6Ly93d3cuZnJlZXBpay5jb20YByoWT0J2Yy1rQngtN1NoQVgxa1ZQWjlxdzJINzA1NjQ4ODA4MDU3LTNjaHVkZGJyNm9haGJlYmliMXVoNjkzazAyc2dmbDMwLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tOAFCQDIzOWM5N2IwY2QwZDcwOWE2MmQ5MjkyNzdjZjdhYjUxZTc2NmI5ODQwMzVjMzdiMTIyOTM2OWI0ODY5ZDJjMzI")
                    SocialButton(iconRes = R.drawable.facebook,"https://www.facebook.com/")

                }

            }
        }
    }
}
@Composable
fun SocialButton(iconRes: Int,url:String) {
    val context: Context = LocalContext.current
    Button(
        onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent) },
        modifier = Modifier.size(80.dp,70.dp)
            .border(1.dp, color = Color.Black, shape = RoundedCornerShape(40.dp)),
        colors = ButtonDefaults.buttonColors(Color.White),
        shape = RoundedCornerShape(50.dp),

    ) {
        Image(painter = painterResource(id = iconRes), contentDescription = "Social Login",
            modifier = Modifier.size(50.dp)
            )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SingUpScreen() {
    CinemaTheme {
        SignupScreen(modifier = Modifier)
    }
}
fun registerUser(context: Context, name: String, email: String, password: String) {
    val url = "http://172.20.10.3/cinema_BDD/signup.php"

    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (connectivityManager.activeNetworkInfo?.isConnected != true) {
        Toast.makeText(context, "No internet connection", Toast.LENGTH_SHORT).show()
        return
    }

    val requestQueue = Volley.newRequestQueue(context)

    val stringRequest = object : StringRequest(
        Request.Method.POST, url,
        { response ->
            try {
                if (response.contains("Success")) {
                    Toast.makeText(context, "تم التسجيل بنجاح!", Toast.LENGTH_SHORT).show()
                    context.startActivity(Intent(context, home::class.java))
                } else {
                    Toast.makeText(context, "خطأ: $response", Toast.LENGTH_LONG).show() // عرض الخطأ كاملاً
                }
            } catch (e: Exception) {
                Toast.makeText(context, "خطأ في قراءة الرد: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
                Log.e("JsonError", "Error parsing JSON response", e)
            }
        },
        { error ->
            Toast.makeText(context, "خطأ اتصال: ${error.message ?: "Unknown error"}", Toast.LENGTH_LONG).show() // عرض تفاصيل الخطأ
            Log.e("VolleyError", error.toString())
        }
    ) {
        override fun getParams(): Map<String, String> {
            return mapOf(
                "name" to name,
                "email" to email,
                "password" to password
            )
        }

        override fun getHeaders(): Map<String, String> {
            return mapOf(
                "Content-Type" to "application/x-www-form-urlencoded",
                "Accept" to "application/json"
            )
        }
    }

    stringRequest.retryPolicy = DefaultRetryPolicy(
        10000,
        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
    )

    requestQueue.add(stringRequest)
}