package com.example.animelist.ui.route

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.animelist.R
import com.example.animelist.ui.theme.Blue
import com.example.animelist.ui.theme.Coral
import com.example.animelist.ui.theme.Pink
import com.example.animelist.ui.theme.Purple
import com.example.animelist.ui.theme.White

@Composable
fun AboutRoute() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .zIndex(-1f)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "About",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Image(
                painter = painterResource(id = R.drawable.foto_porfile_new),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(230.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Cherry Elysia Putri",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "cherryely04@gmail.com",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(24.dp))

            InformationRow("Universitas Negeri Surabaya", R.drawable.school_solid)  // Ikon universitas
            InformationRow("Desain Komunikasi Visual", R.drawable.education_filled) // Ikon jurusan

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun InformationRow(text: String, iconId: Int) {
    Row(
        modifier = Modifier
            .width(300.dp)
            .padding(vertical = 8.dp)
            .background(Pink, RoundedCornerShape(8.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}



@Preview(showBackground = true)
@Composable
fun AboutRoutePreview() {
    AboutRoute()

}
