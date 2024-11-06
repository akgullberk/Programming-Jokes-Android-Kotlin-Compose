package com.example.programmingjokes.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.programmingjokes.model.Joke

@Composable
fun JokeList(jokeList : List<Joke>){
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colorScheme.primaryContainer)

    ) {
        items(jokeList){
            JokeRow(joke = it)
        }
    }
}

@Composable
fun JokeRow(joke: Joke) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .border(BorderStroke(2.dp, Color.Black)) // Adding a border here

        .background(color = MaterialTheme.colorScheme.primaryContainer)
        .padding(10.dp)
    ) {
        if (joke.type == "twopart") {
            Column {
                Text(text= ("Setup: " + joke.setup) ?: "",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(2.dp),
                    fontWeight = FontWeight.Normal
                )
                Text(text= ("Delivery: " + joke.delivery) ?: "",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(2.dp),
                    fontWeight = FontWeight.Normal
                )
            }

        } else {
            Text(text=joke.joke ?: "",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(2.dp),
                fontWeight = FontWeight.Normal
            )
        }

    }
}