package com.raion.incareer.presentation.forgotpasswordconfirm

import android.annotation.SuppressLint
import android.service.autofill.OnClickAction
import android.widget.ImageButton
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.raion.incareer.R
import com.raion.incareer.presentation.bottombar.BottomNavItem
import com.raion.incareer.presentation.bottombar.BottomNavigationBar
import com.raion.incareer.presentation.bottombar.Navigation
import com.raion.incareer.presentation.navigation.Screen
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ForgotPasswordConfirmScreen(
    navController: NavController
) {

    val scope = rememberCoroutineScope()

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
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            Image(
                painter = painterResource(id = R.drawable.splash_screen_logo),
                contentDescription = "logo",
                modifier = Modifier
                    .width(430.dp)


            )

            Image(
                painter = painterResource(id = R.drawable.forgot_password_confirm_image),
                contentDescription = "security confirm image",
                modifier = Modifier
                    .size(350.dp)


            )



            Text(
                text = "Selamat, Email ubah Password berhasil dikirim. Silahkan\n" +
                        "klik tombol dibawah ini untuk masuk kembali ke\n" +
                        "InCareer.",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                modifier = Modifier.padding(horizontal = 0.dp)
            )

            Spacer(modifier = Modifier.height(80.dp))


            Image(

                painter = painterResource (id = R.drawable.continue_button),
                contentDescription = "security confirm image",
                modifier = Modifier
                    .size(70.dp)
                    .clickable {

                        navController.navigate(Screen.Login.route)

                    }

            )


        }
    }
}

@Preview
@Composable
fun PreviewForgotPasswordConfirmScreen(){
   // ForgotPasswordConfirmScreen()
}

