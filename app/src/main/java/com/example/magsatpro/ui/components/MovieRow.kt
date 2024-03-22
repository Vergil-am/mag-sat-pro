package com.example.magsatpro.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.magsatpro.data.remote.model.Category
import com.example.magsatpro.util.Constants.LOGO_BASE_URL


@Composable
fun MovieRow(
    type: String,
    data: List<Category>
) {
    Column (
    ) {
    Text(text = type,
        style = MaterialTheme.typography.headlineMedium)
    LazyRow(
        modifier = Modifier
    ) {
        data.forEach {
            item {
                Column (
                    modifier = Modifier.width(200.dp)
                ) {
                Card(
                    modifier = Modifier
                        .width(200.dp)
                        .height(200.dp)
                        .padding(10.dp)
                    ,
                    shape = CircleShape

                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = rememberAsyncImagePainter(model = "$LOGO_BASE_URL/cat/${it.id}"),
                        contentScale = ContentScale.Crop,
                        contentDescription = it.nm
                    )
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = it.nm
                )

                }
            }


        }

    }

    }

}