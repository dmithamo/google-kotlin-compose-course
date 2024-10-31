package com.example.quadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quadrant.ui.theme.QuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuadrantGrid(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun QuadrantGrid(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Row(horizontalArrangement = Arrangement.Start, modifier = modifier) {
            QuadrantCard(
                title = stringResource(R.string.text_title),
                description = stringResource(R.string.text_description),
                color = Color(0xFFEADDFF),
                modifier = modifier
            )
            QuadrantCard(
                title = stringResource(R.string.image_title),
                description = stringResource(R.string.image_description),
                color = Color(0xFFD0BCFF),
                modifier = modifier
            )
        }
        Row(horizontalArrangement = Arrangement.Start, modifier = modifier) {
            QuadrantCard(
                title = stringResource(R.string.row_title),
                description = stringResource(R.string.row_description),
                color = Color(0xFFB69DF8),
                modifier = modifier
            )
            QuadrantCard(
                title = stringResource(R.string.column_title),
                description = stringResource(R.string.column_description),
                color = Color(0xFFF6EDFF),
                modifier = modifier
            )
        }
    }
}

@Composable
fun QuadrantCard(title: String, description: String, color: Color, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(color = color)
    ) {
        Text(
            text = title,
            modifier = modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(text = description, modifier = modifier)
    }
}

@Composable
@Preview(showBackground = true)
fun QuadrantCardPreview() {
    QuadrantTheme {
        QuadrantCard(
            title = "Text composable",
            description = "Displays text and follows the recommended Material Design guidelines.",
            color = Color(0xFFEADDFF)
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
