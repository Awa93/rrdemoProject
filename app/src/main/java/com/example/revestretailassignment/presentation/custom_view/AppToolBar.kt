package com.example.revestretailassignment.presentation.custom_view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.revestretailassignment.R
import com.example.revestretailassignment.ui.theme.Typography
import com.example.revestretailassignment.ui.theme.primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolBar(
    modifier: Modifier = Modifier,
    title: String,
    showNavigationIcon: Boolean = true,
    icon: Int = R.drawable.ic_back_arrow_icon,
    onBackIconClick: () -> Unit = {}

) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(primary),
        title = {
            RRTextView(text = title, style = Typography.bodyLarge, color = Color.White)
        },
        navigationIcon = {
            if (showNavigationIcon) {
                Box(
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                        .clickable {
                            onBackIconClick()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .width(30.dp)
                            ,
                        painter = painterResource(id = icon),
                        contentDescription = "Back Arrow",
                        tint = Color.White
                    )
                }

            }
        }
    )
}


@Preview
@Composable
fun AppToolBarPreview() {
    AppToolBar(title = "Products")
}