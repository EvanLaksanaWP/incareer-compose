package com.raion.incareer.presentation.ui.screens

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.raion.incareer.data.OnBoardingItems
import com.chenzfall.incareer.R
import com.raion.incareer.presentation.ui.navigation.Screen
import com.raion.incareer.presentation.viewmodels.OnBoardingViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel


const val LAST_PAGE = 2

@OptIn(ExperimentalPagerApi::class)
@Composable

fun OnBoardingScreen(
    navController: NavController,
    viewModel:OnBoardingViewModel = getViewModel()
) {

    val pages = listOf(
        OnBoardingItems.FirstPage,
        OnBoardingItems.SecondPage,
        OnBoardingItems.ThirdPage
    )
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState()
    
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            modifier = Modifier.weight(1f),
            count = pages.size,
            state = pagerState,
        ) { page ->
            OnBoardingItem(pages, page)
        }

        BottomSection(
            page = pagerState.currentPage,
            startOnClickListener = {
                scope.launch {
                    navController.popBackStack()
                    viewModel.saveOnBoardingState(true)
                    navController.navigate(Screen.Login.route)
                }
            },
            nextOnClickListener = {
                if (pagerState.currentPage + 1 < pages.size) scope.launch {
                    pagerState.scrollToPage(pagerState.currentPage + 1)
                }
            },
            skipOnClickListener = {
                if (pagerState.currentPage + 1 < pages.size) scope.launch {
                    pagerState.scrollToPage(LAST_PAGE)
                }
            },
            backOnClickListener = {
                if (pagerState.currentPage + 1 > 1) scope.launch {
                    pagerState.scrollToPage(0)
                }
            }
        )
    }



}

@Composable
fun OnBoardingItem(items: List<OnBoardingItems>, currentPage: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
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
fun BottomSection(page: Int,
                  startOnClickListener: () -> Unit = {},
                  nextOnClickListener: () -> Unit =  {},
                  skipOnClickListener: () -> Unit = {},
                  backOnClickListener: () -> Unit = {}
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Indicators(size = 3, page)
        Row(){
            NextButton(page, startOnClickListener,nextOnClickListener )
            PreviousButton(page, backOnClickListener, skipOnClickListener)
        }

    }
}
@Composable
fun NextButton(page: Int, startOnClickListener: () -> Unit, nextOnClickListener: () -> Unit){

    if(page == LAST_PAGE){
        TextButton(startOnClickListener) {
            Text(text = "Mulai")
        }
    } else{
        TextButton(nextOnClickListener) {
            Text(text = "Lanjut")
        }
    }
}

@Composable
fun PreviousButton(page: Int, backOnClickListener: () -> Unit, skipOnClickListener: () -> Unit){

    if(page == LAST_PAGE){
        TextButton(backOnClickListener) {
            Text(text = "Kembali")
        }
    } else{
        TextButton(skipOnClickListener) {
            Text(text = "Lewati")
        }
    }
}




@Composable
fun RowScope.Indicators(size: Int, index: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        repeat(size) {
            Indicator(isSelected = it == index)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(
        targetValue = if (isSelected) 25.dp else 10.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
    )

    Box(
        modifier = Modifier
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                color = if (isSelected) Color(0XFFF8E2E7) else Color(0XFFF8E2E7)
            )
    ) {

    }
}


@Preview(showBackground = true)
@Composable
fun BottomScreenPreview() {
    BottomSection(page = 0)
}
@Preview(showBackground = true)
@Composable
fun OnBoardingItemPreview(){
    OnBoardingItem(listOf(OnBoardingItems.FirstPage, OnBoardingItems.SecondPage, OnBoardingItems.ThirdPage),1)
}
@Preview(showBackground = true)
@Composable
fun Test(){
    Column() {

        Column() {
            Row() {
                Text(text = "Baris")
            }
            Text(text = "Kolom")
            Text(text = "Kolom2")
        }
    }
}