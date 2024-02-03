package com.example.revestretailassignment.presentation.custom_view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.revestretailassignment.ui.theme.primary
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun RRViewPager(
    modifier: Modifier = Modifier,
    aspectRatio: Float = 1.5F,
    images: List<String> = emptyList(),
    active: Color = primary,
    inActive: Color = Color.Gray,
    onCardClick: (index: Int) -> Unit = {}
) {
    val pagerState = rememberPagerState(initialPage = 0)
    LaunchedEffect(true) {
        yield()
        delay(3000)
        pagerState.animateScrollToPage(
            page = (pagerState.currentPage + 1) % (images.size)
        )
    }

    Box {
        HorizontalPager(
            modifier = modifier.fillMaxWidth(),
            count = images.size,
            state = pagerState,
            itemSpacing = 12.dp
        ) {
            Card(
                modifier = Modifier.clickable { onCardClick(it) },
                shape = RoundedCornerShape(0.dp)
            ) {
                RRImageView(
                    url = images[it],
                    contentDescription = "Banner",
                    aspectRatio = aspectRatio
                )
            }
        }
        if (images.size > 1) {
            HorizontalPagerIndicator(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(12.dp),
                pagerState = pagerState,
                activeColor = active,
                inactiveColor = inActive
            )
        }
    }
}