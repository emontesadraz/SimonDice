package com.example.simondice

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simondice.ui.theme.SimonDiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimonDiceTheme {
                SimonGameScreen()
            }
        }
    }
}

@Composable
fun SimonGameScreen() {
    var currentColor by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Botones { color ->
            currentColor = color
            Log.d("SimonGameScreen", "Boton $color clicked")
        }
        Text(
            text = "Esto es una beta",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "Color actual: $currentColor",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun BotonVerde(onClick: (String) -> Unit) {
    Button(
        onClick = { onClick(SimonColor.GREEN.name) },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
    ) {}
}

@Composable
fun BotonRojo(onClick: (String) -> Unit) {
    Button(
        onClick = { onClick(SimonColor.RED.name) },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
    ) {}
}

@Composable
fun BotonAzul(onClick: (String) -> Unit) {
    Button(
        onClick = { onClick(SimonColor.BLUE.name) },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
    ) {}
}

@Composable
fun BotonAmarillo(onClick: (String) -> Unit) {
    Button(
        onClick = { onClick(SimonColor.YELLOW.name) },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
    ) {}
}

@Composable
fun Botones(onClick: (String) -> Unit) {
    Column {
        Row {
            BotonVerde(onClick)
            BotonRojo(onClick)
        }
        Row {
            BotonAzul(onClick)
            BotonAmarillo(onClick)
        }
    }
}

@Preview
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewSimonGameScreen() {
    SimonGameScreen()
}