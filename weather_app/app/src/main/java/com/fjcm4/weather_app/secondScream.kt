package com.example.weatherapp

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class secondScream : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherScreen2()
        }
    }
}

@Composable
fun WeatherScreen2() {
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFA0B5EB),
            Color(0xFFEA52F8),
            Color(0xFF0066FF)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text("El Salvador", color = Color.White, fontSize = 32.sp, fontWeight = FontWeight.Bold)
            Text("25°C", color = Color.White, fontSize = 80.sp, fontWeight = FontWeight.Medium)
            Text("Soleado", color = Color.White, fontSize = 20.sp)

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                "PRONOSTICO POR HORAS",
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HourItem("Ahora", "25°", Icons.Default.Star)
                HourItem("14:00", "26°", Icons.Default.LocationOn)
                HourItem("16:00", "24°", Icons.Default.ThumbUp)
                HourItem("18:00", "22°", Icons.Default.Star)
                HourItem("20:00", "20°", Icons.Default.LocationOn)
            }

            Spacer(modifier = Modifier.height(25.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White.copy(alpha = 0.2f))
                    .padding(16.dp)
            ) {
                Column {
                    Text("DETALLES", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        DetailItem("Humedad", "65%")
                        DetailItem("Viento", "12 km/h")
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        DetailItem("Presion", "1012 hPa")
                        DetailItem("UV", "5")
                    }
                }
            }

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                "PRONOSTICO SEMANAL",
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White.copy(alpha = 0.2f))
                    .padding(10.dp)
            ) {
                Column {
                    WeeklyItem("Lun", "28° / 22°", Icons.Default.Star)
                    WeeklyItem("Mar", "27° / 21°", Icons.Default.LocationOn)
                    WeeklyItem("Mie", "26° / 20°", Icons.Default.ThumbUp)
                    WeeklyItem("Jue", "25° / 19°", Icons.Default.Star)
                    WeeklyItem("Vie", "24° / 18°", Icons.Default.LocationOn)
                }
            }
        }
    }
}

@Composable
fun HourItem(hour: String, temp: String, icon: ImageVector) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(hour, color = Color.White, fontSize = 12.sp)
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(30.dp).padding(vertical = 4.dp),
            tint = Color.White
        )
        Text(temp, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}

@Composable
fun DetailItem(label: String, value: String) {
    Column {
        Text(label, color = Color.White.copy(alpha = 0.7f), fontSize = 12.sp)
        Text(value, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}

@Composable
fun WeeklyItem(day: String, temp: String, icon: ImageVector) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(day, color = Color.White, fontSize = 16.sp, modifier = Modifier.weight(1f))
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color.White
        )
        Text(
            temp,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier.weight(1f),
            textAlign = androidx.compose.ui.text.style.TextAlign.End
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewScreen2() {
    WeatherScreen2()
}