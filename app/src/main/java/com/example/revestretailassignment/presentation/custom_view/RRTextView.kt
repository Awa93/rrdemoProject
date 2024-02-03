package com.example.revestretailassignment.presentation.custom_view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.revestretailassignment.ui.theme.Typography

@Composable
fun RRTextView(
    modifier: Modifier = Modifier,
    text:String,
    textAlign: TextAlign = TextAlign.Start,
    style: TextStyle =  Typography.bodySmall,
    color:Color = Color.Black
){
    Text(
        modifier =  modifier,
        text = text,
        textAlign = textAlign,
        style = style,
        color = color
    )
}


@Composable
fun KeyValuePair(
    key: String,
    keyColor: Color = Color.Black,
    value: String,
    valueColor: Color = Color.Black,
    horizontalArrangement:Arrangement.Horizontal = Arrangement.spacedBy(8.dp),
) {
    Row(
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RRTextView(text = key, color = keyColor)
        RRTextView(text = value, color = valueColor)
    }
}

fun getStockColor(stock: Int): Pair<Color, String> {
    return if (stock > 20) {
        Pair(
            Color.Green,
            "In Stock"
        )
    } else if (stock <= 0) {
        Pair(Color.Red, "Out of stock")
    } else {
        Pair(
            Color.Magenta,
            "Limited stock"
        )
    }
}

@Preview
@Composable
fun RRTextViewPreview(){
    RRTextView(text = "Welcome")
}