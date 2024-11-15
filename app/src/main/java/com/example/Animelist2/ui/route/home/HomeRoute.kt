package com.example.animelist.ui.route.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.animelist.R
import com.example.animelist.util.coloridoAnimeList
import com.example.animelist.util.comixWaveAnimeList
import com.example.animelist.util.ghibliAnimeList
import com.example.animelist.util.popularAnimeList

val homeAnimeList = listOf(
    HomeListModel(
        title = "Popular",
        animeList = popularAnimeList
    ),
    HomeListModel(
        title = "Studio Ghibli",
        animeList = ghibliAnimeList
    ),
    HomeListModel(
        title = "Comix Wave Films",
        animeList = comixWaveAnimeList
    ),
    HomeListModel(
        title = "Studio Colorido",
        animeList = coloridoAnimeList
    )
)

@Composable
fun HomeRoute() {
    Scaffold { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 128.dp)
        ) {
            item {
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = "Home",
                    style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold)
                )
            }
            item {
                Image(
                    painter = painterResource(id = R.drawable.banner),
                    contentDescription = "Banner",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                    contentScale = ContentScale.FillWidth
                )
            }
            items(items = homeAnimeList) { item ->
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = item.title,
                        style = MaterialTheme.typography.headlineSmall
                            .copy(fontWeight = FontWeight.Bold)
                    )
                    Row(
                        modifier = Modifier.horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Spacer(modifier = Modifier.size(0.dp))
                        item.animeList.forEach { anime ->
                            Image(
                                painter = painterResource(id = anime),
                                contentDescription = "Anime",
                                modifier = Modifier
                                    .size(
                                        width = 130.dp,
                                        height = 180.dp
                                    )
                                    .clip(RoundedCornerShape(16.dp)),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                }
            }
        }
    }
}