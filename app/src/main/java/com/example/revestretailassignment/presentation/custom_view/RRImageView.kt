package com.example.revestretailassignment.presentation.custom_view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.revestretailassignment.R

@Composable
fun RRImageView(
    aspectRatio: Float = 1.5F,
    url: String,
    contentDescription: String,
    contentScale: ContentScale = ContentScale.FillBounds
) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current).data(url).crossfade(enable = true)
            .placeholder(R.drawable.img_place_holder).error(R.drawable.img_place_holder)
            .allowHardware(false).build(), contentScale = contentScale
    )

    Image(
        modifier = Modifier
            .fillMaxWidth().aspectRatio(aspectRatio).background(Color.White) ,
        painter = painter,
        contentDescription = contentDescription
    )
}

@Preview
@Composable
fun RRImageViewPreview(){
    RRImageView(url="", contentDescription = "")
}