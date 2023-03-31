package com.raion.incareer.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.foundation.layout.*
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.raion.incareer.data.OnBoardingItems
import com.chenzfall.incareer.R

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen() {

    val pages = listOf(
        OnBoardingItems.FirstPage,
        OnBoardingItems.SecondPage,
        OnBoardingItems.ThirdPage
    )
    val scope = rememberCoroutineScope()
    val pageState = rememberPagerState()

    Column (modifier = Modifier.fillMaxSize()) {

        HorizontalPager(
            count = pages.size,
            state = pageState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            OnBoardingItem(pages, page)
        }
        BottomSection()
    }
}

@Composable
fun OnBoardingItem(items: List<OnBoardingItems>, currentPage: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = items[currentPage].image),
            contentDescription = "Pager Image",
            modifier = Modifier.padding(horizontal = 50.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = items[currentPage].title,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontSize = 15.sp,
            fontFamily = FontFamily(Font(R.font.poppins_extrabold)),
            modifier = Modifier.padding(horizontal = 50.dp)
        )

        Text(
            text = items[currentPage].description,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontSize = 13.sp,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            modifier = Modifier.padding(horizontal = 50.dp)
        )
    }
}

@Composable
fun BottomSection(onSkipClick: () -> Unit = {}, onNextClick:() -> Unit = {}) {

}


@Preview(showBackground = true)
@Composable
fun OnBoardingScreenPreview() {
    OnBoardingScreen()
}