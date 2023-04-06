import android.content.pm.ActivityInfo
import android.widget.Toast
import androidx.compose.foundation.*
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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.raion.incareer.R
import com.raion.incareer.presentation.login.LoginViewModel
import com.raion.incareer.presentation.navigation.Screen
import com.raion.incareer.presentation.ui.components.LockScreenOrientation
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel


@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = getViewModel()
){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val state = viewModel.loginState.collectAsState(initial = null)


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
                text = "Masuk",
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
                isError = !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.isNotEmpty(),
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


        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxWidth()
        ){
            TextButton(onClick = {
                navController.popBackStack()
                navController.navigate(Screen.ForgotPassword.route)
            }){
                Text(
                    text = "Lupa Kata Sandi?",
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    color = Color(0XFF1877F2),
                    fontSize = 12.sp,
                    modifier = Modifier
                )
            }
        }

        Separator()

        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.Center,
        ){
            IconButton(
                onClick = {}
            ){
                Icon(
                    painter = painterResource(id = R.drawable.google_icon),
                    contentDescription = "google icon",
                    modifier = Modifier.size(70.dp),
                    tint = Color.Unspecified
                )
            }

            Spacer(modifier = Modifier.width(50.dp))
            

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.facebook_icon),
                    contentDescription = "facebook icon",
                    modifier = Modifier.size(70.dp),
                    tint = Color.Unspecified
                )
            }
        }
        Button(
            onClick = {
                scope.launch {
                    viewModel.loginUser(email, password)
                }
            },
            modifier  = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp),
            colors = ButtonDefaults.buttonColors(Color(0XFF1877F2)),
            shape = RoundedCornerShape(50.dp),
            enabled =  isEmailValid(email) && isPasswordValid(password)

        ) {
            Text(
                text = "Masuk",
                fontFamily = FontFamily(Font(R.font.poppins_extrabold)),
                color = Color.White,
                fontSize = 20.sp,
                letterSpacing = 0.5.sp
            )
            LaunchedEffect(key1 = state.value?.isSuccess){
                scope.launch {
                    if(state.value?.isSuccess?.isNotEmpty() == true){
                        val success = state.value?.isSuccess
                        Toast.makeText(context, "$success", Toast.LENGTH_LONG).show()

                        navController.popBackStack()
                        navController.navigate(Screen.Home.route)

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
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Baru di InCareer?",
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                fontSize = 12.sp,
                letterSpacing = 0.5.sp
            )
            TextButton(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Screen.Register.route)
                },
                modifier = Modifier
                    .padding(start = 0.5.dp)
                    .align(Alignment.Top)
            ) {
                Text(
                    text = "Daftar di sini",
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



@Composable
fun Separator() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            color = Color.Gray,
            modifier = Modifier
                .weight(1f)
        )
        Text(
            fontFamily = FontFamily(Font(R.font.poppins_bold)),
            text = "Atau",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 8.dp),
            fontSize = 15.sp
        )
        Divider(
            color = Color.Gray,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
        )
    }
}

fun isPasswordValid(password: String): Boolean{
    return password.length >= 8 && password.isNotEmpty()
}

fun isEmailValid(email: String): Boolean{
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.isNotEmpty()
}
