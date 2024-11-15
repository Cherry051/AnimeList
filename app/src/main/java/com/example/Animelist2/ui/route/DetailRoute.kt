import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animelist.R
import com.example.animelist.ui.theme.Black
import com.example.animelist.ui.theme.Coral
import com.example.animelist.ui.theme.Tosca
import com.example.animelist.ui.theme.White

@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
) {
    val backDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    val posterfilmImage = painterResource(R.drawable.poster_spirited_away_content_1)
    val logoIMBD = painterResource(R.drawable.logo_imbd)
    val iconFav = painterResource(R.drawable.movie_favorit_outline)

    Column(
        modifier = Modifier
            .background(White)
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .background(Tosca)
                .height(81.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize()
            ) {
                IconButton(
                    onClick = { backDispatcher?.onBackPressed() },
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Black,
                        modifier = Modifier.size(25.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(0.5f))
                Text(
                    text = "Studio Ghibli",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Black,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.weight(1f))
            }
        }

        Image(
            painter = posterfilmImage,
            contentDescription = "Poster Film",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Spirited Away",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Fantasi, Petualangan | 2001",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Black
            )
            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(3.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = logoIMBD,
                        contentDescription = "Logo IMBD",
                        modifier = Modifier
                            .width(50.dp)
                            .height(25.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "8,6/10",
                        color = Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Kisah Chihiro, seorang gadis muda yang terjebak di dunia roh setelah orang tuanya berubah menjadi babi. Dalam upaya untuk menyelamatkan mereka, Chihiro bekerja di sebuah pemandian milik penyihir Yubaba. Selama tinggal di sana, Chihiro bertemu dengan berbagai makhluk ajaib dan roh, serta belajar tentang keberanian, persahabatan, dan pentingnya menjaga identitas diri.",
                    color = Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.height(100.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center, // Menempatkan Box dan elemen-elemen di dalamnya di tengah
                    modifier = Modifier.fillMaxWidth()
                ){
                    Box(
                        modifier = Modifier
                            .background(Coral, RoundedCornerShape(24.dp))
                            .width(200.dp)
                            .height(49.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ){
                            Icon(
                                painter = iconFav,
                                contentDescription = "Icon Film Ku",
                                modifier = Modifier
                                    .width(30.dp)
                                    .height(30.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Simpan", color = Black, fontSize = 22.sp, fontWeight = FontWeight.Bold)

                        }
                    }
                }
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    DetailsScreen()

}
