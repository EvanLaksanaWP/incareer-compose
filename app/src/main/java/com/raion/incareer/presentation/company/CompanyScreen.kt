package com.raion.incareer.presentation.company

import android.content.pm.ActivityInfo
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import com.google.firebase.auth.FirebaseAuth
import com.raion.incareer.R
import com.raion.incareer.presentation.ui.components.LockScreenOrientation
import kotlinx.coroutines.launch

@Composable
fun CompanyScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(0xFFF8F8F8)
            )

    ) {


    }


    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)



    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .background(
            Brush.verticalGradient(
                listOf(Color(0XFF1877F2), Color.Transparent),
                startY = -250f,
                endY = 650f,

                )
        )

    ) {
        Column(modifier = Modifier
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
            
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp, end = 40.dp),
                horizontalArrangement = Arrangement.SpaceBetween,) {

                Text(
                    buildAnnotatedString {
                        withStyle(SpanStyle(color = Color(0xFF00359E), fontSize = 20.sp)) {
                            append("450+ ")
                        }
                        append("perusahaan Indo teratas sedang menunggu Anda")
                    },
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.poppins_extrabold)),
                    textAlign = TextAlign.Start,
                    modifier = Modifier.width(330.dp)

                )
                Column(modifier = Modifier
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

            Spacer(Modifier.height(27.dp))

            Text(
                text = "Menjelajahi Perusahaan Top",
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                fontSize = 16.sp,
            )






        }

        Row(modifier = Modifier
            .padding(top = 18.dp)
            .horizontalScroll(rememberScrollState())
        ) {
            Spacer(Modifier.width(40.dp))

            Card(
                modifier = Modifier
                    .width(200.dp)
                    .height(195.dp)
                    .background(
                        Color.Transparent
                    ),
                elevation = 5.dp,
                shape = RoundedCornerShape(15.dp),
                backgroundColor = Color(0xFF92C5EC)
            ) {

                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp),

                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.klikcair_logo),
                        contentDescription = "Logo Klikcair",
                        modifier = Modifier.size(110.dp)
                    )

                    Text(
                        text = "1 pekerjaan baru",
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 13.sp,
                        textAlign = TextAlign.Center
                    )

                }




            }
            Spacer(Modifier.width(20.dp))


            Card(
                modifier = Modifier
                    .width(200.dp)
                    .height(195.dp)
                    .background(
                        Color.Transparent
                    ),
                elevation = 5.dp,
                shape = RoundedCornerShape(15.dp),
                backgroundColor = Color(0xFFFCD5A8)
            ) {

                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp),

                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.whiz_logo),
                        contentDescription = "Logo whiz",
                        modifier = Modifier.size(110.dp)
                    )

                    Text(
                        text = "4 pekerjaan baru",
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 13.sp,
                        textAlign = TextAlign.Center
                    )

                }

            }

            Spacer(Modifier.width(20.dp))


            Card(
                modifier = Modifier
                    .width(200.dp)
                    .height(195.dp)
                    .background(
                        Color.Transparent
                    ),
                elevation = 5.dp,
                shape = RoundedCornerShape(15.dp),
                backgroundColor = Color(0xFFD2D2D2)
            ) {

                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp),

                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.scarlett_logo),
                        contentDescription = "Logo scarlett",
                        modifier = Modifier.size(110.dp)
                    )

                    Text(
                        text = "2 pekerjaan baru",
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 13.sp,
                        textAlign = TextAlign.Center
                    )

                }

            }
            Spacer(Modifier.width(20.dp))


            Card(
                modifier = Modifier
                    .width(200.dp)
                    .height(195.dp)
                    .background(
                        Color.Transparent
                    ),
                elevation = 5.dp,
                shape = RoundedCornerShape(15.dp),
                backgroundColor = Color(0xFFFF9F81)
            ) {

                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp),

                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.shopee_logo),
                        contentDescription = "Logo shopee",
                        modifier = Modifier
                            .height(110.dp)
                            .width(50.dp)
                    )

                    Text(
                        text = "2 pekerjaan baru",
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 13.sp,
                        textAlign = TextAlign.Center
                    )

                }

            }

            Spacer(Modifier.width(20.dp))


            Card(
                modifier = Modifier
                    .width(200.dp)
                    .height(195.dp)
                    .background(
                        Color.Transparent
                    ),
                elevation = 5.dp,
                shape = RoundedCornerShape(15.dp),
                backgroundColor = Color(0xFFFF9999)
            ) {

                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp),

                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.uniqlo_logo),
                        contentDescription = "Logo uniqlo",
                        modifier = Modifier
                            .height(110.dp)
                            .width(50.dp)
                    )

                    Text(
                        text = "3 pekerjaan baru",
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 13.sp,
                        textAlign = TextAlign.Center
                    )

                }

            }

            Spacer(Modifier.width(20.dp))


            Card(
                modifier = Modifier
                    .width(200.dp)
                    .height(195.dp)
                    .background(
                        Color.Transparent
                    ),
                elevation = 5.dp,
                shape = RoundedCornerShape(15.dp),
                backgroundColor = Color(0xFF67C16B)
            ) {

                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp),

                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.gojek_logo),
                        contentDescription = "Logo uniqlo",
                        modifier = Modifier
                            .height(110.dp)
                            .width(50.dp)
                    )

                    Text(
                        text = "1 pekerjaan baru",
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 13.sp,
                        textAlign = TextAlign.Center
                    )

                }

            }

            Spacer(Modifier.width(40.dp))

        }

        Spacer(Modifier.height(50.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Card(

                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 20.dp)
                    ,
                backgroundColor = Color.Transparent,
                border = BorderStroke(width = 2.dp, color = Color(0xFF737373)),
                shape = RoundedCornerShape(20.dp),

                ) {
                Row() {
                    Spacer(Modifier.width(10.dp))

                    Image(
                        painter = painterResource(id = R.drawable.filter_icon),
                        contentDescription = "Icon Filter",
                        modifier = Modifier
                            .size(30.dp)
                            .padding(end = 10.dp)

                    )

                    Text(
                        text = "Filter",
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = Color.Black,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .padding(top = 6.dp, end = 10.dp),
                    )
                }



            }
        }

        Spacer(Modifier.height(40.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                //.verticalScroll(rememberScrollState())
        ) {

            Card(
                modifier = Modifier
                    .width(440.dp)
                    .align(CenterHorizontally),
                shape = RoundedCornerShape(20.dp),
                backgroundColor = Color.Transparent,

                ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = Brush.radialGradient(
                                colors = listOf(Color(0xFF82AAE3), Color(0xFFFFFFFF)),
                                center = Offset(x = 1200f, y = -300f),
                                radius = 3500f
                            )
                        )
                        .padding(all = 20.dp)


                ) {

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(140.dp)
                            .background(
                                Color.Transparent
                            ),
                        elevation = 5.dp,
                        shape = RoundedCornerShape(15.dp),
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Column() {
                                Spacer(Modifier.height(20.dp))

                                Image(
                                    painter = painterResource(id = R.drawable.esmod_logo),
                                    contentDescription = "Esmod Logo",
                                    modifier = Modifier
                                        .height(40.dp)
                                        .width(100.dp)
                                        .padding(end = 10.dp)

                                )

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                ) {
                                    Text(
                                        text = "ESMOD Jakarta",
                                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                        color = Color.Black,
                                        fontSize = 14.sp,
                                    )
                                    Spacer(Modifier.width(7.dp))

                                    Image(
                                        painter = painterResource(id = R.drawable.check_icon),
                                        contentDescription = "Check Icon",
                                        modifier = Modifier
                                            .size(25.dp)
                                            .padding(bottom = 3.dp, end = 10.dp)

                                    )


                                }

                                Spacer(Modifier.height(15.dp))

                                Card(
                                    modifier = Modifier
                                        .wrapContentSize(),
                                    backgroundColor = Color(0xFFBFEAF5),
                                    shape = RoundedCornerShape(20.dp),

                                    ) {
                                    Text(
                                        text = "1 posisi",
                                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                                        color = Color(0xFF00359E),
                                        fontSize = 12.sp,
                                        modifier = Modifier
                                            .padding(horizontal = 20.dp),
                                        textAlign = TextAlign.Center
                                    )
                                }


                            }

                            Image(
                                painter = painterResource(id = R.drawable.bookmark_icon),
                                contentDescription = "Bookmark Icon",
                                modifier = Modifier
                                    .size(55.dp)
                                    .padding(top = 2.dp)

                            )


                        }

                    }

                    Spacer(Modifier.height(17.dp))

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(140.dp)
                            .background(
                                Color.Transparent
                            ),
                        elevation = 5.dp,
                        shape = RoundedCornerShape(15.dp),
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Column() {
                                Spacer(Modifier.height(20.dp))

                                Image(
                                    painter = painterResource(id = R.drawable.btp_logo),
                                    contentDescription = "Btp Logo",
                                    modifier = Modifier
                                        .height(40.dp)
                                        .width(100.dp)
                                        .padding(end = 10.dp),
                                    alignment = CenterStart

                                )

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                ) {
                                    Text(
                                        text = "PT Sumber Bintang Perkasa",
                                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                        color = Color.Black,
                                        fontSize = 14.sp,
                                    )
                                    Spacer(Modifier.width(7.dp))

                                    Image(
                                        painter = painterResource(id = R.drawable.check_icon),
                                        contentDescription = "Check Icon",
                                        modifier = Modifier
                                            .size(25.dp)
                                            .padding(bottom = 3.dp, end = 10.dp),


                                        )


                                }

                                Spacer(Modifier.height(15.dp))

                                Card(
                                    modifier = Modifier
                                        .wrapContentSize(),
                                    backgroundColor = Color(0xFFBFEAF5),
                                    shape = RoundedCornerShape(20.dp),

                                    ) {
                                    Text(
                                        text = "3 posisi",
                                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                                        color = Color(0xFF00359E),
                                        fontSize = 12.sp,
                                        modifier = Modifier
                                            .padding(horizontal = 20.dp),
                                        textAlign = TextAlign.Center
                                    )
                                }


                            }

                            Image(
                                painter = painterResource(id = R.drawable.bookmark_icon),
                                contentDescription = "Bookmark Icon",
                                modifier = Modifier
                                    .size(55.dp)
                                    .padding(top = 2.dp)

                            )


                        }

                    }

                    Spacer(Modifier.height(17.dp))

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(140.dp)
                            .background(
                                Color.Transparent
                            ),
                        elevation = 5.dp,
                        shape = RoundedCornerShape(15.dp),
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Column() {
                                Spacer(Modifier.height(20.dp))

                                Image(
                                    painter = painterResource(id = R.drawable.agate_logo),
                                    contentDescription = "Agate Logo",
                                    modifier = Modifier
                                        .height(40.dp)
                                        .width(100.dp)
                                        .padding(end = 10.dp),
                                    alignment = CenterStart

                                )

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                ) {
                                    Text(
                                        text = "Agate",
                                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                        color = Color.Black,
                                        fontSize = 14.sp,
                                    )
                                    Spacer(Modifier.width(7.dp))

                                    Image(
                                        painter = painterResource(id = R.drawable.check_icon),
                                        contentDescription = "Check Icon",
                                        modifier = Modifier
                                            .size(25.dp)
                                            .padding(bottom = 3.dp, end = 10.dp),


                                        )


                                }

                                Spacer(Modifier.height(15.dp))

                                Card(
                                    modifier = Modifier
                                        .wrapContentSize(),
                                    backgroundColor = Color(0xFFBFEAF5),
                                    shape = RoundedCornerShape(20.dp),

                                    ) {
                                    Text(
                                        text = "2 posisi",
                                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                                        color = Color(0xFF00359E),
                                        fontSize = 12.sp,
                                        modifier = Modifier
                                            .padding(horizontal = 20.dp),
                                        textAlign = TextAlign.Center
                                    )
                                }


                            }

                            Image(
                                painter = painterResource(id = R.drawable.bookmark_icon),
                                contentDescription = "Bookmark Icon",
                                modifier = Modifier
                                    .size(55.dp)
                                    .padding(top = 2.dp)

                            )


                        }

                    }

                    Spacer(Modifier.height(17.dp))

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(140.dp)
                            .background(
                                Color.Transparent
                            ),
                        elevation = 5.dp,
                        shape = RoundedCornerShape(15.dp),
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Column() {
                                Spacer(Modifier.height(20.dp))

                                Image(
                                    painter = painterResource(id = R.drawable.whiz_logo),
                                    contentDescription = "Whiz Logo",
                                    modifier = Modifier
                                        .height(40.dp)
                                        .width(100.dp)
                                        .padding(end = 10.dp),
                                    alignment = CenterStart

                                )

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                ) {
                                    Text(
                                        text = "Whiz (YC W22)",
                                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                        color = Color.Black,
                                        fontSize = 14.sp,
                                    )
                                    Spacer(Modifier.width(7.dp))

                                    Image(
                                        painter = painterResource(id = R.drawable.check_icon),
                                        contentDescription = "Check Icon",
                                        modifier = Modifier
                                            .size(25.dp)
                                            .padding(bottom = 3.dp, end = 10.dp),


                                        )


                                }

                                Spacer(Modifier.height(15.dp))

                                Card(
                                    modifier = Modifier
                                        .wrapContentSize(),
                                    backgroundColor = Color(0xFFBFEAF5),
                                    shape = RoundedCornerShape(20.dp),

                                    ) {
                                    Text(
                                        text = "1 posisi",
                                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                                        color = Color(0xFF00359E),
                                        fontSize = 12.sp,
                                        modifier = Modifier
                                            .padding(horizontal = 20.dp),
                                        textAlign = TextAlign.Center
                                    )
                                }


                            }

                            Image(
                                painter = painterResource(id = R.drawable.bookmark_icon),
                                contentDescription = "Bookmark Icon",
                                modifier = Modifier
                                    .size(55.dp)
                                    .padding(top = 2.dp)

                            )


                        }

                    }

                    Spacer(Modifier.height(17.dp))

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(140.dp)
                            .background(
                                Color.Transparent
                            ),
                        elevation = 5.dp,
                        shape = RoundedCornerShape(15.dp),
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Column() {
                                Spacer(Modifier.height(20.dp))

                                Image(
                                    painter = painterResource(id = R.drawable.grammable_logo),
                                    contentDescription = "Grammable Logo",
                                    modifier = Modifier
                                        .height(40.dp)
                                        .width(100.dp)
                                        .padding(end = 10.dp),
                                    alignment = CenterStart

                                )

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                ) {
                                    Text(
                                        text = "Grammable",
                                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                        color = Color.Black,
                                        fontSize = 14.sp,
                                    )
                                    Spacer(Modifier.width(7.dp))

                                    Image(
                                        painter = painterResource(id = R.drawable.check_icon),
                                        contentDescription = "Check Icon",
                                        modifier = Modifier
                                            .size(25.dp)
                                            .padding(bottom = 3.dp, end = 10.dp),


                                        )


                                }

                                Spacer(Modifier.height(15.dp))

                                Card(
                                    modifier = Modifier
                                        .wrapContentSize(),
                                    backgroundColor = Color(0xFFBFEAF5),
                                    shape = RoundedCornerShape(20.dp),

                                    ) {
                                    Text(
                                        text = "2 posisi",
                                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                                        color = Color(0xFF00359E),
                                        fontSize = 12.sp,
                                        modifier = Modifier
                                            .padding(horizontal = 20.dp),
                                        textAlign = TextAlign.Center
                                    )
                                }


                            }

                            Image(
                                painter = painterResource(id = R.drawable.bookmark_icon),
                                contentDescription = "Bookmark Icon",
                                modifier = Modifier
                                    .size(55.dp)
                                    .padding(top = 2.dp)

                            )


                        }

                    }

                    Spacer(Modifier.height(17.dp))

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(140.dp)
                            .background(
                                Color.Transparent
                            ),
                        elevation = 5.dp,
                        shape = RoundedCornerShape(15.dp),
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Column() {
                                Spacer(Modifier.height(20.dp))

                                Image(
                                    painter = painterResource(id = R.drawable.klikcair_logo),
                                    contentDescription = "Klikcair Logo",
                                    modifier = Modifier
                                        .height(40.dp)
                                        .width(100.dp)
                                        .padding(end = 10.dp),
                                    alignment = CenterStart

                                )

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                ) {
                                    Text(
                                        text = "KlikCair",
                                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                        color = Color.Black,
                                        fontSize = 14.sp,
                                    )
                                    Spacer(Modifier.width(7.dp))

                                    Image(
                                        painter = painterResource(id = R.drawable.check_icon),
                                        contentDescription = "Check Icon",
                                        modifier = Modifier
                                            .size(25.dp)
                                            .padding(bottom = 3.dp, end = 10.dp),


                                        )


                                }

                                Spacer(Modifier.height(15.dp))

                                Card(
                                    modifier = Modifier
                                        .wrapContentSize(),
                                    backgroundColor = Color(0xFFBFEAF5),
                                    shape = RoundedCornerShape(20.dp),

                                    ) {
                                    Text(
                                        text = "1 posisi",
                                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                                        color = Color(0xFF00359E),
                                        fontSize = 12.sp,
                                        modifier = Modifier
                                            .padding(horizontal = 20.dp),
                                        textAlign = TextAlign.Center
                                    )
                                }


                            }

                            Image(
                                painter = painterResource(id = R.drawable.bookmark_icon),
                                contentDescription = "Bookmark Icon",
                                modifier = Modifier
                                    .size(55.dp)
                                    .padding(top = 2.dp)

                            )


                        }

                    }


                }

            }

            Spacer(Modifier.height(80.dp))
        }
    }

}


@Preview
@Composable
fun PreviewCompanyScreen (){
    CompanyScreen()
}