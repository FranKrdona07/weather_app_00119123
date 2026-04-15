package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherScreen1()
        }
    }
}

@Composable
fun WeatherScreen1() {
    // Gradiente azul especificado en el PDF
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF72EAFF),
            Color(0xFF72C2FF),
            Color(0xFF003888)
        )
    )

    // Box principal con el gradiente ocupando todo el fondo
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Ubicacion y Temperatura [cite: 2, 13]
            Text(
                text = "El Salvador",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "25°C",
                color = Color.White,
                fontSize = 80.sp,
                fontWeight = FontWeight.Light
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Icono central
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Tarjeta de informacion con opacidad 0.2 [cite: 66, 70]
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White.copy(alpha = 0.2f))
                    .padding(vertical = 20.dp, horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                InfoItem("HUM", "65%") // [cite: 21, 22]
                InfoItem("VIENTO", "12 km/h") // [cite: 23]
                InfoItem("LLUVIA", "10%") // [cite: 24, 113]
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Boton de actualizar [cite: 26, 118]
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.width(200.dp)
            ) {
                Text(
                    text = "ACTUALIZAR",
                    color = Color(0xFF003888),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun InfoItem(title: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = title,
            color = Color.White.copy(alpha = 0.7f),
            fontSize = 12.sp
        )
        Text(
            text = value,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewScreen1() {
    WeatherScreen1()
}