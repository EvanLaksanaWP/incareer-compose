package com.raion.incareer.presentation.registration

import android.content.pm.ActivityInfo
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.raion.incareer.R
import com.raion.incareer.presentation.navigation.Screen
import com.raion.incareer.presentation.ui.components.LockScreenOrientation
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = getViewModel()
){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var fullName by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val state = viewModel.registerState.collectAsState(initial = null)

    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    EllipseBackground()

    Column(
        modifier = Modifier
            .padding(top = 175.dp)
            .padding(horizontal = 20.dp)
            .fillMaxSize()
        ,
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 35.dp),
            horizontalArrangement = Arrangement.Center,
        ){
            Image(
                painter = painterResource(id = R.drawable.colorized_logo),
                contentDescription = "Logo Berwarna",
                modifier = Modifier.width(300.dp)
            )
        }

        Row (Modifier.fillMaxWidth()){
            Text(
                text = "Daftar",
                fontFamily = FontFamily(Font(R.font.poppins_extrabold)),
                fontSize = 26.sp,
            )
        }

        Spacer(Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            //Full Name
            OutlinedTextField(
                value = fullName,
                onValueChange = { newFullName ->
                    fullName = newFullName
                },
                leadingIcon = {
                    Icon(Icons.Outlined.Person, contentDescription = "Person")
                },
                placeholder = { Text(
                    text = "Nama Lengkap",
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontSize = 18.sp
                ) },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { /* action on 'Next' button pressed */ }),
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1,
                shape = RoundedCornerShape(25.dp),
            )


            Spacer(modifier = Modifier.height(30.dp))

            //Email
            OutlinedTextField(
                value = email,
                onValueChange = { newEmail ->
                    email = newEmail
                },
                leadingIcon = {
                    Icon(Icons.Outlined.Email, contentDescription = "Email")
                },
                placeholder = { Text(
                    text = "Email",
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontSize = 18.sp
                ) },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { /* action on 'Next' button pressed */ }),
                isError = !Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.isNotEmpty(),
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1,
                shape = RoundedCornerShape(25.dp),
            )

            Spacer(modifier = Modifier.height(30.dp))

            //Password
            OutlinedTextField(
                value = password,
                onValueChange = { newPassword ->
                    password = newPassword
                },
                leadingIcon = {
                    Icon(Icons.Outlined.Lock, contentDescription = "Kata Sandi")
                },
                trailingIcon = {
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(
                            if (passwordVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            contentDescription = "Toggle Password Visibility"
                        )
                    }
                },
                placeholder = {
                    Text(
                        text = "Kata Sandi",
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 18.sp
                    ) },
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = { /* action on 'Done' button pressed */ }),
                isError = password.length < 8 && password.isNotEmpty(),
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1,
                shape = RoundedCornerShape(25.dp),
            )
        }

        Text(
            buildAnnotatedString {
                append("Dengan mendaftar. Anda menyetujui ")
                withStyle(SpanStyle(color = Color(0xFF1877F2), fontSize = 12.sp)) {
                    append("Syarat & Ketentuan ")
                }
                append("dan ")
                withStyle(SpanStyle(color = Color(0xFF1877F2), fontSize = 12.sp)) {
                    append("Kebijakan Privasi")
                }
                append(" kami")
            },
            fontSize = 12.sp,
            color = Color(0xFFA7A7A7),
            modifier = Modifier.padding(start = 10.dp, end = 30.dp, top = 20.dp, bottom = 20.dp),
            textAlign = TextAlign.Start
        )


        Button(
            onClick = {
                scope.launch {
                    viewModel.registerUser(email = email, password = password)
                    viewModel.saveDataUser(fullName = fullName, email = email)
                }
            },
            modifier  = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp),
            colors = ButtonDefaults.buttonColors(Color(0XFF1877F2)),
            shape = RoundedCornerShape(50.dp),
            enabled =  isEmailValid(email) && isPasswordValid(password) && isFullNameValid(fullName)

        ) {
            Text(
                text = "Daftar",
                fontFamily = FontFamily(Font(R.font.poppins_extrabold)),
                color = Color.White,
                fontSize = 20.sp,
                letterSpacing = 0.5.sp
            )
        }

        LaunchedEffect(key1 = state.value?.isSuccess){
            scope.launch {
                if(state.value?.isSuccess?.isNotEmpty() == true){
                    val success = state.value?.isSuccess
                    Toast.makeText(context, "$success", Toast.LENGTH_LONG).show()
                }
            }
        }

        LaunchedEffect(key1 = state.value?.isError){
            scope.launch {
                if(state.value?.isError?.isNotEmpty() == true){
                    val error = state.value?.isError
                    Toast.makeText(context, "$error", Toast.LENGTH_LONG).show()
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Sudah daftar sebelumnya?",
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                fontSize = 12.sp,
                letterSpacing = 0.5.sp
            )
            TextButton(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Screen.Login.route)
                },
                modifier = Modifier
                    .padding(start = 0.5.dp)
                    .align(Alignment.Top)
            ) {
                Text(
                    text = "Masuk",
                    color = Color(0XFF1877F2),
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    fontSize = 12.sp,
                    letterSpacing = 0.5.sp
                )
            }
        }
    }
}

@Composable
fun EllipseBackground() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .zIndex(Float.MIN_VALUE)
            .offset(y = (-50).dp)
    ) {
        val ellipseColor = Color(0x3382AAE3)

        drawEllipse(
            color = ellipseColor,
            topLeft = Offset(x = -77.dp.toPx(), y = -197.dp.toPx()),
            size = size.copy(width = 445.dp.toPx(), height = 406.dp.toPx())
        )

        drawEllipse(
            color = ellipseColor,
            topLeft = Offset(x = 167.dp.toPx(), y = -162.dp.toPx()),
            size = size.copy(width = 342.dp.toPx(), height = 342.dp.toPx())
        )
    }
}

private fun DrawScope.drawEllipse(color: Color, topLeft: Offset, size: androidx.compose.ui.geometry.Size) {
    drawOval(color = color, topLeft = topLeft, size = size)
}

fun isPasswordValid(password: String): Boolean{
    return password.length >= 8 && password.isNotEmpty()
}

fun isEmailValid(email: String): Boolean{
    return Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.isNotEmpty()
}

fun isFullNameValid(fullName: String): Boolean{
    return fullName.isNotEmpty()
}