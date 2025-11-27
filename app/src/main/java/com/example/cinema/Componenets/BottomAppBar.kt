package com.example.cinema.Componenets

import android.content.Context
import android.content.Intent
import android.text.Layout.Alignment
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.*
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.*
import com.example.cinema.Screen.profil
import com.example.cinema.Screen.Register_ticket
import com.example.cinema.Screen.home
import com.example.cinema.Screen.register_ticket

@Composable
fun CustomBottomBar(currentRoute: String, context: Context) {
    val items = listOf(
        BottomNavItem("Home", Icons.Default.Home,"Home"),
        BottomNavItem("Ticket", Icons.Default.ConfirmationNumber,"Ticket"),
        BottomNavItem("Profil", Icons.Default.Person,"Profil")
    )

    Box(
        modifier = Modifier.clip(RoundedCornerShape(24.dp))
    ) {
        BottomAppBar(
            containerColor = Color.Black,
            contentColor = Color.White,
            tonalElevation = 8.dp
        ) {
            items.forEach { item ->
                NavigationBarItem(
                    selected = currentRoute == item.route,
                    onClick = {
                        when (item.route) {
                            "Home" -> {
                                val intent = Intent(context, home::class.java)
                                context.startActivity(intent)
                            }
                            "Ticket" -> {
                                val intent = Intent(context, register_ticket::class.java)
                                context.startActivity(intent)
                            }
                            "Profil" -> {
                                val intent = Intent(context, profil::class.java)
                                context.startActivity(intent)
                            }
                        }
                    },
                    icon = {
                        Column (
                            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
                        ){
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.route,
                                tint = if (currentRoute == item.route) Color.White else Color.Gray
                            )
                            Text(text = item.Titre, color = if (currentRoute == item.route) Color.White else Color.Gray , fontSize = 12.sp)
                        }
                    },
                    alwaysShowLabel = false,
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.White.copy(alpha = 0.1f)
                    )
                )
            }
        }
    }
}

data class BottomNavItem(val route: String, val icon: ImageVector, val Titre: String)
