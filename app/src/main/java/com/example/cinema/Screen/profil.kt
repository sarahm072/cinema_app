package com.example.cinema.Screen


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.compose.ui.res.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Logout
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
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.draw.clip
import com.example.cinema.Componenets.CustomBottomBar
import androidx.compose.material3.HorizontalDivider
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import android.content.SharedPreferences
import androidx.compose.runtime.LaunchedEffect

class profil : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CinemaTheme {
                val context = LocalContext.current
                // استرجاع معرف المستخدم أو البريد الإلكتروني من SharedPreferences
                val sharedPreferences = context.getSharedPreferences("user_info", Context.MODE_PRIVATE)
                val userId = sharedPreferences.getInt("user_id", -1) // أو val userEmail = sharedPreferences.getString("email", "")

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Profil_Screen(modifier = Modifier.padding(innerPadding),userId)
                }
            }
        }
    }
}
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun Profil_Screen(modifier: Modifier,userId: Int){
        val context: Context = LocalContext.current
        val scrollState = rememberScrollState()
        var fullName by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        // استدعاء دالة لجلب معلومات المستخدم
//        LaunchedEffect(key1 = userId) {
//            if (userId != -1) {
//                fetchUserProfile(context, userId, onProfileFetched = { fetchedName, fetchedEmail ->
//                    fullName = fetchedName
//                    email = fetchedEmail
//                })
//            }
//        }

        Scaffold(
            topBar = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(60.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "My Profil",
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp
                    )
                }
            },
            bottomBar = { CustomBottomBar("Profil", context) })
            {
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.background),
                        contentDescription = "background",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp), verticalArrangement = Arrangement.Center) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(painter = painterResource(id = R.drawable.dark), contentDescription ="", modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(100.dp))
                )
            Column (modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),){
                Text(text ="Sara Meraouche"/*fullName*/, color = Color.White)
                Text(text ="sarame2207@gmail.com" /*email*/,color = Color.White)
            }
            }
            Row(modifier = Modifier.fillMaxWidth()
                .padding(vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Column (modifier = Modifier
                    .weight(1f)
                    .padding(start = 20.dp)){
                    Text(text = "My Orders", color = Color.White, fontWeight = FontWeight.SemiBold)
                    Text(text = "Already have 12 orders",color = Color.White)
                }
                Icon(imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription ="" ,
                    tint= Color.White,
                    modifier = Modifier.padding(end = 20.dp)
                )
             }
            HorizontalDivider(color = Color.Gray, thickness = 1.dp)
            Row(modifier = Modifier.fillMaxWidth()
                .padding(vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Column (modifier = Modifier
                    .weight(1f)
                    .padding(start = 20.dp)){
                    Text(text = "Payment methods", color = Color.White, fontWeight = FontWeight.SemiBold)
                    Text(text = "visa **34",color = Color.White)
                }
                Icon(imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription ="" ,
                    tint= Color.White,
                    modifier = Modifier.padding(end = 20.dp)
                )
            }
            HorizontalDivider(color = Color.Gray, thickness = 1.dp)
            Row(modifier = Modifier.fillMaxWidth()
                .padding(vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Column (modifier = Modifier
                    .weight(1f)
                    .padding(start = 20.dp)){
                    Text(text = "My reviews", color = Color.White, fontWeight = FontWeight.SemiBold)
                    Text(text = " ",color = Color.White)
                }
                Icon(imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription ="" ,
                    tint= Color.White,
                    modifier = Modifier.padding(end = 20.dp)
                )
            }
            HorizontalDivider(color = Color.Gray, thickness = 1.dp)
            Row(modifier = Modifier.fillMaxWidth()
                .padding(vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Column (modifier = Modifier
                    .weight(1f)
                    .padding(start = 20.dp)){
                    Text(text = "Settings", color = Color.White, fontWeight = FontWeight.SemiBold)
                    Text(text = "Notifications, password",color = Color.White)
                }
                Icon(imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription ="" ,
                    tint= Color.White,
                    modifier = Modifier.padding(end = 20.dp)
                )
            }
            HorizontalDivider(color = Color.Gray, thickness = 1.dp)
            Row(modifier = Modifier.fillMaxWidth()
                .padding(vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column (modifier = Modifier
                    .weight(1f)
                    .padding(20.dp),){
                    Text(text = "Log Out", color = Color.White, fontWeight = FontWeight.SemiBold)
                }
                Icon(imageVector = Icons.Default.Logout, contentDescription ="" ,
                    tint= Color.White,
                    modifier = Modifier.padding(end = 20.dp)
                    )
            }
        }
        }
    }
    }
    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun Profil() {
        CinemaTheme {
        Profil_Screen(modifier = Modifier,-2)
        }
    }



fun fetchUserProfile(context: Context, userId: Int, onProfileFetched: (String, String) -> Unit) {
    val url = "http://192.168.175.32/cinema_BDD/get_user_profile.php?user_id=$userId" // أو يمكنك استخدام POST مع إرسال المعرف في body
// استبدل هذا الجزء حسب المكان اللي تتحصل فيه على user_id الحقيقي
    val userId = 1 // أو القيمة اللي ترجع من قاعدة البيانات مثلاً

// تخزين user_id في SharedPreferences
    val sharedPreferences = context.getSharedPreferences("user_info", Context.MODE_PRIVATE)
    with(sharedPreferences.edit()) {
        putInt("user_id", userId)
        apply()
    }

    val requestQueue = Volley.newRequestQueue(context)

    val stringRequest = StringRequest(
        Request.Method.GET, url,
        { response ->
            try {
                val jsonResponse = JSONObject(response)
                if (jsonResponse.getBoolean("success")) {
                    val fullName = jsonResponse.getString("full_name")
                    val email = jsonResponse.getString("email")
                    onProfileFetched(fullName, email)
                } else {
                    Toast.makeText(context, "فشل في جلب معلومات الملف الشخصي: ${jsonResponse.getString("message")}", Toast.LENGTH_SHORT).show()
                    Log.e("ProfileError", "Error fetching profile: ${jsonResponse.getString("message")}")
                }
            } catch (e: Exception) {
                Toast.makeText(context, "خطأ في قراءة رد الملف الشخصي: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
                Log.e("JsonError", "Error parsing profile JSON response", e)
            }
        },
        { error ->
            Toast.makeText(context, "خطأ في اتصال جلب الملف الشخصي: ${error.message ?: "Unknown error"}", Toast.LENGTH_SHORT).show()
            Log.e("VolleyError", "Profile fetch error: $error")
        }
    )

    stringRequest.retryPolicy = DefaultRetryPolicy(
        10000,
        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
    )

    requestQueue.add(stringRequest)
}
