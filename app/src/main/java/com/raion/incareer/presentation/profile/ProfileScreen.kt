package com.raion.incareer.presentation.profile

import android.content.pm.ActivityInfo
import android.graphics.BlurMaskFilter
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.raion.incareer.R
import com.raion.incareer.presentation.navigation.Screen
import com.raion.incareer.presentation.ui.components.LockScreenOrientation
import kotlinx.coroutines.launch


@Composable
fun ProfileScreen(
    ) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color.White
            ),
        contentAlignment = Alignment.Center
    ) {

    }

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current



    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)



    Column(
        modifier = Modifier
            .padding(top = 60.dp)
            .padding(horizontal = 10.dp)
            .fillMaxSize()

    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, end = 100.dp),
            horizontalArrangement = Arrangement.Center,
        ) {

            Image(
                painter = painterResource(id = R.drawable.profile_picture_dummy),
                contentDescription = "Foto Profile",
                modifier = Modifier.size(85.dp)
            )

            Spacer(Modifier.width(20.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp)
            ) {

                Text(
                    text = "Elang Muh I ",
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    fontSize = 17.sp,
                )

                Text(
                    text = "UI/UX Designer",
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 16.sp,
                )
            }

        }

        Spacer(Modifier.height(15.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {
            Card(
                modifier = Modifier
                    .wrapContentSize()
                    .background(
                        Color.White
                    ),
                border = BorderStroke(1.dp, Color.Gray),
                shape = RoundedCornerShape(20.dp),

                ) {
                Text(
                    text = "UI/UX Designer Intern at PT. Bank CIMB Niaga Tbk | Google DSC Core Team UI/UX Design",
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontSize = 12.sp,
                    modifier = Modifier
                        .width(250.dp)
                        .padding(
                            vertical = 10.dp,
                            horizontal = 10.dp
                        ),

                    )
            }

            Spacer(Modifier.width(15.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally


            ) {
                Card(
                    modifier = Modifier
                        .wrapContentSize()
                        .background(
                            Color.White
                        ),
                    border = BorderStroke(1.dp, Color.Gray),
                    shape = RoundedCornerShape(20.dp),

                    ) {

                    Row(
                        Modifier
                            .wrapContentSize()
                            .padding(start = 5.dp)
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.logo_ub),
                            contentDescription = "Logo Univ",
                            modifier = Modifier
                                .size(30.dp)
                                .padding(vertical = 4.dp),

                            )

                        Text(
                            text = "Universitas Brawijaya",
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 10.sp,
                            modifier = Modifier
                                .width(80.dp)
                                .padding(
                                    vertical = 0.dp,
                                    horizontal = 4.dp
                                ),

                            )

                    }

                }

                Spacer(Modifier.height(8.dp))

                Card(
                    modifier = Modifier
                        .wrapContentSize()
                        .background(
                            Color.White
                        ),
                    border = BorderStroke(1.dp, Color.Gray),

                    shape = RoundedCornerShape(20.dp),

                    ) {
                    Row(
                        Modifier
                            .wrapContentSize()
                            .padding(start = 5.dp)
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.message_icon),
                            contentDescription = "Logo Message",
                            modifier = Modifier
                                .size(32.dp)
                                .padding(top = 2.dp),
                        )

                        Text(
                            text = "Pesan",
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 12.sp,
                            modifier = Modifier
                                .width(80.dp)
                                .padding(
                                    vertical = 6.dp,
                                    horizontal = 4.dp
                                ),

                            )

                    }
                }

            }
        }

        Spacer(Modifier.height(20.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Card(
                modifier = Modifier
                    .wrapContentSize()
                    .background(
                        Color.White
                    ),
                border = BorderStroke(1.dp, Color.Gray),
                shape = RoundedCornerShape(20.dp),

                ) {
                Row(
                    Modifier
                        .wrapContentSize()
                        .padding(start = 15.dp)
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.gmail_icon),
                        contentDescription = "Logo Gmail",
                        modifier = Modifier
                            .size(25.dp)
                            .padding(vertical = 4.dp),
                    )

                    Text(
                        text = "celine@gmail.com",
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 10.sp,
                        modifier = Modifier
                            .width(125.dp)
                            .padding(
                                vertical = 4.dp,
                                horizontal = 10.dp
                            ),

                        )

                }
            }

            Spacer(Modifier.width(20.dp))

            Card(
                modifier = Modifier
                    .wrapContentSize()
                    .background(
                        Color.White
                    ),
                border = BorderStroke(1.dp, Color.Gray),
                shape = RoundedCornerShape(20.dp),

                ) {
                Row(
                    Modifier
                        .wrapContentSize()
                        .padding(start = 15.dp)
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.phone_icon),
                        contentDescription = "Logo Phone",
                        modifier = Modifier
                            .size(25.dp)
                            .padding(vertical = 4.dp),
                    )

                    Text(
                        text = "+62823277382324",
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 10.sp,
                        modifier = Modifier
                            .width(125.dp)
                            .padding(
                                vertical = 4.dp,
                                horizontal = 5.dp
                            ),

                        )

                }
            }
        }

        Spacer(Modifier.height(20.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Card(
                modifier = Modifier
                    .wrapContentSize()
                    .background(
                        Color.White
                    )
                    .shadow(
                        color = Color.Black,
                        offsetY = 15.dp,
                        blurRadius = 10.dp,
                        borderRadius = 20.dp

                    ),
                border = BorderStroke(1.dp, Color.Gray),
                shape = RoundedCornerShape(20.dp),

                ) {
                Text(
                    text = "Tentang Saya",
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    fontSize = 11.sp,
                    modifier = Modifier
                        .width(125.dp)
                        .padding(
                            vertical = 5.dp,
                            horizontal = 10.dp
                        ),
                    textAlign = TextAlign.Center
                )

            }

            Spacer(Modifier.width(20.dp))

            Card(
                modifier = Modifier
                    .wrapContentSize()
                    .background(
                        Color.White
                    )
                    .padding(
                        bottom = 5.dp
                    ),

                border = BorderStroke(1.dp, Color.Gray),
                shape = RoundedCornerShape(20.dp),


                ) {

                Text(
                    text = "Ulasan",
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    fontSize = 11.sp,
                    modifier = Modifier
                        .width(125.dp)
                        .padding(
                            vertical = 5.dp,
                            horizontal = 5.dp
                        ),
                    textAlign = TextAlign.Center
                )


            }

            Spacer(Modifier.width(20.dp))

            Card(
                modifier = Modifier
                    .wrapContentSize()
                    .background(
                        Color.White
                    ),
                border = BorderStroke(1.dp, Color.Gray),
                shape = RoundedCornerShape(20.dp),

                ) {

                Text(
                    text = "Karir",
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    fontSize = 11.sp,
                    modifier = Modifier
                        .width(125.dp)
                        .padding(
                            vertical = 5.dp,
                            horizontal = 5.dp
                        ),
                    textAlign = TextAlign.Center
                )


            }
        }

        Spacer(Modifier.height(20.dp))


        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {


            Row(Modifier.fillMaxWidth()) {
                Text(
                    text = "Ringkasan",
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 15.sp,
                    modifier = Modifier
                        .width(125.dp)
                        .padding(
                            vertical = 10.dp,
                            horizontal = 20.dp
                        ),

                    )
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color(0xF0F0F0)
                    )
                    .padding(horizontal = 22.dp),
                border = BorderStroke(1.dp, Color.Gray),
                shape = RoundedCornerShape(20.dp),
            ) {
                Text(
                    text = "UI/UX Designer Intern at PT. Bank CIMB Niaga Tbk | Google DSC Core Team UI/UX Design",
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            vertical = 10.dp,
                            horizontal = 10.dp
                        ),

                    )
            }

            Spacer(Modifier.height(10.dp))

            Row(Modifier.fillMaxWidth()) {
                Text(
                    text = "Minat",
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 14.sp,
                    modifier = Modifier
                        .width(125.dp)
                        .padding(
                            vertical = 10.dp,
                            horizontal = 20.dp
                        ),

                    )
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Card(
                    modifier = Modifier
                        .wrapContentSize()
                        .background(
                            Color.White
                        ),
                    border = BorderStroke(1.dp, Color.Gray),
                    shape = RoundedCornerShape(20.dp),

                    ) {
                    Text(
                        text = "UI/UX Designer",
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 11.sp,
                        modifier = Modifier
                            .width(115.dp)
                            .padding(
                                vertical = 5.dp,
                                horizontal = 10.dp
                            ),
                        textAlign = TextAlign.Center
                    )

                }

                Spacer(Modifier.width(20.dp))

                Card(
                    modifier = Modifier
                        .wrapContentSize()
                        .background(
                            Color.White
                        )
                        .padding(
                            bottom = 5.dp
                        ),

                    border = BorderStroke(1.dp, Color.Gray),
                    shape = RoundedCornerShape(20.dp),


                    ) {

                    Text(
                        text = "Programmer",
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 11.sp,
                        modifier = Modifier
                            .width(115.dp)
                            .padding(
                                vertical = 5.dp,
                                horizontal = 5.dp
                            ),
                        textAlign = TextAlign.Center
                    )


                }

                Spacer(Modifier.width(20.dp))

                Card(
                    modifier = Modifier
                        .wrapContentSize()
                        .background(
                            Color.White
                        ),
                    border = BorderStroke(1.dp, Color.Gray),
                    shape = RoundedCornerShape(20.dp),

                    ) {

                    Text(
                        text = "",
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 11.sp,
                        modifier = Modifier
                            .width(115.dp)
                            .padding(
                                vertical = 5.dp,
                                horizontal = 5.dp
                            ),
                        textAlign = TextAlign.Center
                    )


                }
            }

            Spacer(Modifier.height(10.dp))

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Card(
                    modifier = Modifier
                        .wrapContentSize()
                        .background(
                            Color.White
                        ),
                    border = BorderStroke(1.dp, Color.Gray),
                    shape = RoundedCornerShape(20.dp),

                    ) {
                    Text(
                        text = "",
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 11.sp,
                        modifier = Modifier
                            .width(115.dp)
                            .padding(
                                vertical = 5.dp,
                                horizontal = 10.dp
                            ),
                        textAlign = TextAlign.Center
                    )

                }

                Spacer(Modifier.width(20.dp))

                Card(
                    modifier = Modifier
                        .wrapContentSize()
                        .background(
                            Color.White
                        )
                        .padding(
                            bottom = 5.dp
                        ),

                    border = BorderStroke(1.dp, Color.Gray),
                    shape = RoundedCornerShape(20.dp),


                    ) {

                    Text(
                        text = "",
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 11.sp,
                        modifier = Modifier
                            .width(115.dp)
                            .padding(
                                vertical = 5.dp,
                                horizontal = 5.dp
                            ),
                        textAlign = TextAlign.Center
                    )


                }

                Spacer(Modifier.width(20.dp))

                Card(
                    modifier = Modifier
                        .wrapContentSize()
                        .background(
                            Color.White
                        ),
                    border = BorderStroke(1.dp, Color.Gray),
                    shape = RoundedCornerShape(20.dp),

                    ) {

                    Text(
                        text = "",
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 11.sp,
                        modifier = Modifier
                            .width(115.dp)
                            .padding(
                                vertical = 5.dp,
                                horizontal = 5.dp
                            ),
                        textAlign = TextAlign.Center
                    )


                }
            }

            Spacer(Modifier.height(10.dp))

            Row(Modifier.fillMaxWidth()) {
                Text(
                    text = "Pendidikan",
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 15.sp,
                    modifier = Modifier
                        .width(125.dp)
                        .padding(
                            vertical = 10.dp,
                            horizontal = 20.dp
                        ),

                    )
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color(0xF0F0F0)
                    )
                    .padding(horizontal = 22.dp),
                border = BorderStroke(1.dp, Color.Gray),
                shape = RoundedCornerShape(20.dp),
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo_ub),
                        contentDescription = "Logo Univ",
                        modifier = Modifier
                            .size(75.dp)
                            .padding(vertical = 10.dp),

                        )

                    Column(
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Universitas Brawijaya",
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            fontSize = 16.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(

                                    horizontal = 10.dp
                                ),

                            )

                        Text(
                            text = "S1 Teknik Informatika",
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 14.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(

                                    horizontal = 10.dp
                                ),

                            )

                        Text(
                            text = "2020 - 2024",
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 12.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(

                                    horizontal = 10.dp
                                ),

                            )
                    }

                }

            }

            Spacer(Modifier.height(10.dp))

            Row(Modifier.fillMaxWidth()) {
                Text(
                    text = "Penghargaan",
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 15.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            vertical = 10.dp,
                            horizontal = 20.dp
                        ),

                    )
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color(0xF0F0F0)
                    )
                    .padding(horizontal = 22.dp),
                border = BorderStroke(1.dp, Color.Gray),
                shape = RoundedCornerShape(20.dp),
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.certificate_icon),
                        contentDescription = "Icon Sertifikat",
                        modifier = Modifier
                            .size(60.dp)
                            .padding(vertical = 15.dp),

                        )

                    Column(
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .fillMaxWidth()
                    ) {

                        Text(
                            text = "1st Winner UI/UX Design Competition",
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 14.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(

                                    horizontal = 10.dp
                                ),

                            )

                        Text(
                            text = " HITECH-5",
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 14.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(

                                    horizontal = 10.dp
                                ),

                            )
                    }

                }

            }

            Spacer(Modifier.height(10.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color(0xF0F0F0)
                    )
                    .padding(horizontal = 22.dp),
                border = BorderStroke(1.dp, Color.Gray),
                shape = RoundedCornerShape(20.dp),
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.certificate_icon),
                        contentDescription = "Icon Sertifikat",
                        modifier = Modifier
                            .size(60.dp)
                            .padding(vertical = 15.dp),

                        )

                    Column(
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .fillMaxWidth()
                    ) {

                        Text(
                            text = "Finalist UX Design Competition",
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 14.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(

                                    horizontal = 10.dp
                                ),

                            )

                        Text(
                            text = "GEMASTIK 2023",
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 14.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(

                                    horizontal = 10.dp
                                ),

                            )
                    }

                }


            }

            Spacer(Modifier.height(10.dp))

            Row(Modifier.fillMaxWidth()) {
                Text(
                    text = "Keahlian Bahasa",
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 15.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            vertical = 10.dp,
                            horizontal = 20.dp
                        ),

                    )
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color(0xF0F0F0)
                    )
                    .padding(horizontal = 22.dp),
                border = BorderStroke(1.dp, Color.Gray),
                shape = RoundedCornerShape(20.dp),
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Bahasa Indonesia",
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            fontSize = 16.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(

                                    horizontal = 10.dp
                                ),

                            )

                        Text(
                            text = "Tingkat fasih atau bahasa asli",
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 14.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(

                                    horizontal = 10.dp
                                ),

                            )

                    }

                }

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 80.dp),
                horizontalAlignment = Alignment.End
            ){
                Button(
                    onClick = {
                        scope.launch {
                            FirebaseAuth.getInstance().signOut()
                        }
                    },
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(horizontal = 20.dp, vertical = 20.dp),

                    colors = ButtonDefaults.buttonColors(Color(0XFF1877F2)),
                    shape = RoundedCornerShape(50.dp),


                    ) {
                    Text(
                        text = "Keluar",
                        fontFamily = FontFamily(Font(R.font.poppins_extrabold)),
                        color = Color.White,
                        fontSize = 20.sp,
                        letterSpacing = 0.5.sp
                    )


                }
            }

        }
    }





    }
fun Modifier.shadow(
    color: Color = Color.Black,
    borderRadius: Dp = 0.dp,
    blurRadius: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp,
    spread: Dp = 0f.dp,
    modifier: Modifier = Modifier
) = this.then(
    modifier.drawBehind {
        this.drawIntoCanvas {
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            val spreadPixel = spread.toPx()
            val leftPixel = (0f - spreadPixel) + offsetX.toPx()
            val topPixel = (0f - spreadPixel) + offsetY.toPx()
            val rightPixel = (this.size.width + spreadPixel)
            val bottomPixel = (this.size.height + spreadPixel)

            if (blurRadius != 0.dp) {
                frameworkPaint.maskFilter =
                    (BlurMaskFilter(blurRadius.toPx(), BlurMaskFilter.Blur.NORMAL))
            }

            frameworkPaint.color = color.toArgb()
            it.drawRoundRect(
                left = leftPixel,
                top = topPixel,
                right = rightPixel,
                bottom = bottomPixel,
                radiusX = borderRadius.toPx(),
                radiusY = borderRadius.toPx(),
                paint
            )
        }
    }
)


@Preview
@Composable
fun PreviewProfileScreen(){
   ProfileScreen()
}