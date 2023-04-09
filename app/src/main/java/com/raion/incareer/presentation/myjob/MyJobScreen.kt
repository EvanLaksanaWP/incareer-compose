package com.raion.incareer.presentation.myjob

import android.content.pm.ActivityInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raion.incareer.R
import com.raion.incareer.presentation.company.CompanyScreen
import com.raion.incareer.presentation.ui.components.LockScreenOrientation

@Composable
fun MyJob() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(0xFFF8F8F8)
            ),
        contentAlignment = Alignment.Center
    ) {

    }


    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    Column(modifier = Modifier
        .fillMaxSize()
        .background(
            Brush.verticalGradient(
                listOf(Color(0XFF1877F2), Color.Transparent),
                startY = -250f,
                endY = 650f,

                )
        )

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 40.dp)

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                horizontalArrangement = Arrangement.Center,
            ) {

                Image(
                    painter = painterResource(id = R.drawable.profile_picture_dummy),
                    contentDescription = "Foto Profile",
                    modifier = Modifier.size(60.dp)
                )

                Spacer(Modifier.width(10.dp))

                Column(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(top = 3.dp),
                    verticalArrangement = Arrangement.Center

                ) {
                    Row() {
                        Text(
                            text = "Halo ",
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            fontSize = 15.sp,
                            color = Color(0xFF555353)
                        )

                        Image(
                            painter = painterResource(id = R.drawable.halo_icon),
                            contentDescription = "Halo Icon",
                            modifier = Modifier
                                .size(25.dp)
                                .padding(bottom = 3.dp, end = 10.dp)

                        )


                    }

                    Text(
                        text = "Elang Muh I ",
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        fontSize = 16.sp,
                    )
                }
                Spacer(Modifier.width(200.dp))

                Image(
                    painter = painterResource(id = R.drawable.others_icon),
                    contentDescription = "Others Icon",
                    modifier = Modifier.size(40.dp),

                    )


            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp, end = 40.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

                Text(
                    buildAnnotatedString {
                        append("Jangan biarkan ")
                        withStyle(SpanStyle(color = Color(0xFF00359E), fontSize = 20.sp)) {
                            append("kesulitan dalam mencari pekerjaan ")
                        }
                        append("menjadi kendala bagi karirmu")
                    },
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    textAlign = TextAlign.Start,
                    modifier = Modifier.width(300.dp)

                )
                Column(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .wrapContentSize()
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.bell_icon),
                        contentDescription = "Bell Icon",
                        modifier = Modifier
                            .size(45.dp)
                    )
                }

            }

            Spacer(Modifier.height(40.dp))

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(end = 40.dp),
                horizontalArrangement = Arrangement.Center

            ) {
                Card(
                    modifier = Modifier
                        .wrapContentSize()
                        .background(
                            Color.Transparent
                        ),
                    elevation = 5.dp,
                    shape = RoundedCornerShape(20.dp),

                    ) {
                    Text(
                        text = "Tersimpan",
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        fontSize = 14.sp,
                        modifier = Modifier
                            .width(150.dp)
                            .padding(
                                vertical = 5.dp,
                                horizontal = 10.dp
                            ),
                        textAlign = TextAlign.Center,
                        color = Color(0xFF1877F2)
                    )

                }

                Spacer(Modifier.width(20.dp))

                Card(
                    modifier = Modifier
                        .wrapContentSize()
                        .background(
                            Color.Transparent
                        )
                        .padding(
                            bottom = 5.dp
                        ),

                    shape = RoundedCornerShape(20.dp),
                    elevation = 5.dp


                ) {

                    Text(
                        text = "Terdaftar",
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        fontSize = 14.sp,
                        modifier = Modifier
                            .width(150.dp)
                            .padding(
                                vertical = 5.dp,
                                horizontal = 10.dp
                            ),
                        textAlign = TextAlign.Center
                    )

                }
            }

            Spacer(Modifier.height(70.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 40.dp),
                horizontalArrangement = Arrangement.Center,
            ) {

                Text(
                    text = "Simpan pekerjaan dan jangan lewatkan kesempatan untuk melamar.",
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.width(400.dp)

                )

            }

            Spacer(Modifier.height(15.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 40.dp),
                horizontalArrangement = Arrangement.Center,
            ) {

                Image(
                    painter = painterResource(id = R.drawable.job_icon_1),
                    contentDescription = "Job Image",
                    modifier = Modifier
                        .size(248.dp)


                )

            }

            Spacer(Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 40.dp),
                horizontalArrangement = Arrangement.Center,
            ) {

                Text(
                    text = "Anda akan menerima pengingat notifikasi setelah slot kandidat prioritas habis",
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.width(280.dp)

                )

            }



        }





    }
}

@Preview
@Composable
fun PreviewMyJob(){
    MyJob()
}