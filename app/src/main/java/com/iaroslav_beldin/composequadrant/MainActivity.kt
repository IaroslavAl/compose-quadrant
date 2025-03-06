package com.iaroslav_beldin.composequadrant

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iaroslav_beldin.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CardList(
                        cards = cards,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CardList(cards: List<Card>, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Row(modifier = Modifier.weight(1f)) {
            cards.getOrNull(0)?.let { card ->
                CardView(
                    card = card,
                    modifier = Modifier.weight(1f)
                )
            }
            cards.getOrNull(1)?.let { card ->
                CardView(
                    card = card,
                    modifier = Modifier.weight(1f)
                )
            }
        }
        Row(modifier = Modifier.weight(1f)) {
            cards.getOrNull(2)?.let { card ->
                CardView(
                    card = card,
                    modifier = Modifier.weight(1f)
                )
            }
            cards.getOrNull(3)?.let { card ->
                CardView(
                    card = card,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun CardView(card: Card, modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(card.background)
            .padding(16.dp)
    ) {
        Text(
            text = card.title,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = card.subtitle,
            textAlign = TextAlign.Justify
        )
    }
}

data class Card(
    val title: String,
    val subtitle: String,
    val background: Color
)

var cards = listOf(
    Card(
        title = "Text composable",
        subtitle = "Displays text and follows the recommended Material Design guidelines.",
        background = Color(0xFFEADDFF)
    ),
    Card(
        title = "Image composable",
        subtitle = "Creates a composable that lays out and draws a given Painter class object.",
        background = Color(0xFFD0BCFF)
    ),
    Card(
        title = "Row composable",
        subtitle = "A layout composable that places its children in a horizontal sequence.",
        background = Color(0xFFB69DF8)
    ),
    Card(
        title = "Column composable",
        subtitle = "A layout composable that places its children in a vertical sequence.",
        background = Color(0xFFF6EDFF)
    )
)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        CardList(cards)
    }
}