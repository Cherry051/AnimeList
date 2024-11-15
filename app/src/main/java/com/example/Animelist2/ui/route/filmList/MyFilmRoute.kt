package com.example.animelist.ui.route.myfilm

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animelist.R

data class MyFilm(val title: String, val posterId: Int)

val filmList = listOf(
    MyFilm("Spirited Away", R.drawable.spirited_away),
    MyFilm("Howl's Moving Castle", R.drawable.howl_moving_castle),
    MyFilm("Look Back", R.drawable.look_back_poster),
    MyFilm("Suzume", R.drawable.suzume),
    MyFilm("Your Name", R.drawable.your_name),
    MyFilm("A Silent Voice", R.drawable.a_silent_voice),
    MyFilm("Drifting Home", R.drawable.drifiting_home),
    MyFilm("The Garden of Words", R.drawable.the_garden_of_words),
    MyFilm("My Neighbor Totoro", R.drawable.my_neighbor_totoro),
    MyFilm("Grave of The Fireflies", R.drawable.grave_of_the_fireflies),
    MyFilm("Princess Mononoke", R.drawable.princess_mononoke),
    MyFilm("A Whisker Away", R.drawable.a_whisker_away)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyFilmRoute() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "My Film",
                        style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold)
                    )
                }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(0.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(filmList) { film ->
                        FilmItem(film = film)
                    }
                }
            }
        }
    )
}

@Composable
fun FilmItem(film: MyFilm) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = film.posterId),
            contentDescription = film.title,
            modifier = Modifier
                .size(
                    width = 130.dp,
                    height = 180.dp
                )
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = film.title,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyFilmRoutePreview() {
    MyFilmRoute()

}