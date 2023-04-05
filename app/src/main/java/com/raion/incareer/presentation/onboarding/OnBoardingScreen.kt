package com.raion.incareer.presentation.onboarding

import android.content.pm.ActivityInfo
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
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
import com.raion.incareer.R
import com.raion.incareer.presentation.navigation.Screen
import com.raion.incareer.presentation.ui.components.LockScreenOrientation
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel


const val LAST_PAGE = 2

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
    navController: NavController,
    viewModel: OnBoardingViewModel = getViewModel()
) {

    val pages = listOf(
        OnBoardingItems.FirstPage,
        OnBoardingItems.SecondPage,
        OnBoardingItems.ThirdPage
    )
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState()

    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    Column(
        modifier = Modifier.fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(Color(0xFF82AAE3), Color(0xFF00359E)),
                    center = Offset(x = 1000f, y = -300f),
                    radius = 2500f
                )
            ),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
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
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 15.sp,
            fontFamily = FontFamily(Font(R.font.poppins_extrabold)),
            modifier = Modifier.padding(horizontal = 50.dp)
        )

        Text(
            text = items[currentPage].description,
            color = Color.White,
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
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 25.dp, vertical = 15.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ){
        Indicators(size = 3, page)
        Row(){
            LeftButton (page = page, backOnClickListener = backOnClickListener, skipOnClickListener = skipOnClickListener)
            Spacer(modifier = Modifier.width(10.dp))
            RightButton (page, nextOnClickListener = nextOnClickListener, startOnClickListener = startOnClickListener)
        }

    }
}
@Composable
fun RightButton(page: Int,
                startOnClickListener: () -> Unit,
                nextOnClickListener: () -> Unit
){

    val (text, onClick) = if (page == LAST_PAGE) {
        "Mulai" to startOnClickListener
    } else {
        "Lanjut" to nextOnClickListener
    }

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF1877F2),
            contentColor = Color.White
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 4.dp,
            pressedElevation = 8.dp,
            disabledElevation = 0.dp
        ),
        shape = RoundedCornerShape(12.dp),
    ) {
        Text(
            text = text,
            fontFamily = FontFamily(Font(R.font.poppins_bold)),
        )
    }
}

@Composable
fun LeftButton(
    page: Int,
    backOnClickListener: () -> Unit,
    skipOnClickListener: () -> Unit
){

    val (text, onClick) = if (page == LAST_PAGE) {
        "Kembali" to backOnClickListener
    } else {
        "Lewati" to skipOnClickListener
    }

    TextButton(onClick = onClick) {
       Text(
           fontFamily = FontFamily(Font(R.font.poppins_bold)),
           text = text,
           color = Color.LightGray,
       )
    }
}

@Composable
fun Indicators(size: Int, index: Int) {
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
                color = if (isSelected) Color(0XFFF8F8F8) else Color(0XFFF8F8F8).copy(alpha = 0.5f)
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