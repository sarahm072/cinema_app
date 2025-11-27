package com.example.cinema.Componenets

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinema.ui.theme.CinemaTheme
import kotlinx.coroutines.delay
import kotlin.random.Random
import com.example.cinema.R


// افترض أن لديك كائن Slide مخصص يحتوي على imageId و title
data class Slide(val imageId: Int, val title: String)

val sampleSlides = listOf(
    Slide(imageId = R.drawable.image01, title = "Movie 3"),
    Slide(imageId = R.drawable.image02, title = "Movie 3"),
    Slide(imageId = R.drawable.image03, title = "Movie 3"),
    Slide(imageId = R.drawable.image04, title = "Movie 3"),
    Slide(imageId = R.drawable.image05, title = "Movie 3"),
    Slide(imageId = R.drawable.image06, title = "Movie 3"),
    Slide(imageId = R.drawable.image07, title = "Movie 3")

)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Carousel(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {

    val slides = sampleSlides
    val pagerState = rememberPagerState(
        initialPage = Random.nextInt(0, slides.size)
    ) {
        slides.size
    }

    LaunchedEffect(Unit) {
        while (true) {
            delay(5000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % slides.size,
                animationSpec = tween()
            )
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp),
            pageSize = PageSize.Fill,
            contentPadding = PaddingValues(0.dp),
            pageSpacing = 0.dp,
            verticalAlignment = Alignment.CenterVertically
        ) { page ->
            val slide = slides[page]
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .align(Alignment.Center),
                    painter = painterResource(slide.imageId),
                    contentDescription = slide.title,
                    contentScale = ContentScale.Crop
                )
            }
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
        ) {
            repeat(slides.size) { page ->
                Box(
                    Modifier
                        .size(6.dp)
                        .padding(if (pagerState.currentPage == page) 0.dp else 1.dp)
                        .background(
                            color = if (pagerState.currentPage == page) Color.White else Color.Gray,
                            shape = CircleShape
                        )
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CarouselPreview() {
    CinemaTheme {
        Carousel(
            onClick = {}
        )
    }
}
