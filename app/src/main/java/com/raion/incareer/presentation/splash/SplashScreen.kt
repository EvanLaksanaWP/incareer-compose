package com.raion.incareer.presentation.ui.screens

import android.content.pm.ActivityInfo
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.chenzfall.incareer.R
import com.raion.incareer.presentation.ui.components.LockScreenOrientation
import com.raion.incareer.presentation.splash.SplashViewModel
import com.raion.incareer.util.Constants
import kotlinx.coroutines.delay
import org.koin.androidx.compose.getViewModel


@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel = getViewModel()
) {

    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    var startAnimation by remember{
        mutableStateOf(false)
    }
    val alphaAnim by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    val nextDestination by viewModel.nextDestination

    LaunchedEffect(key1 = true){
        startAnimation = true;
        delay(Constants.SPLASH_SCREEN_DURATION)

        navController.popBackStack()
        navController.navigate(nextDestination)
    }
    Splash(alpha = alphaAnim)
}


@Composable
fun Splash(alpha: Float) {
    Box(
        modifier = Modifier
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(Color(0xFF82AAE3), Color(0xFF00359E)),
                    center = Offset(x = 1000f, y = -300f),
                    radius = 2500f
                )
            )
            .fillMaxSize(),
        contentAlignment = Alignment.Center

    ){
        Image(painter = painterResource(id = R.drawable.splash_screen_logo),
            contentDescription = "splash screen logo",
            modifier = Modifier
                .wrapContentSize()
                .alpha(alpha = alpha)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun SplashScreenPreview(){
    Splash(alpha = 1f)
}