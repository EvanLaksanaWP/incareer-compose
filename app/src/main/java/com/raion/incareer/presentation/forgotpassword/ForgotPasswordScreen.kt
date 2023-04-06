package com.raion.incareer.presentation.forgotpassword

import android.content.Context
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.raion.incareer.R
import com.raion.incareer.presentation.navigation.Screen
import com.raion.incareer.presentation.registration.isEmailValid
import com.raion.incareer.util.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel
import androidx.compose.ui.platform.LocalContext

@Composable
fun ForgotPasswordScreen (
    navController: NavController,
    viewModel: ForgotPasswordViewModel = getViewModel(),
) {

    val scope: CoroutineScope = rememberCoroutineScope()
    val state: StateFlow<Resource<Unit>> = viewModel.resetPasswordState
    val context: Context = LocalContext.current

    var email by remember{ mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .scrollable(
                    rememberScrollState(),
                    orientation = Orientation.Vertical
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.forgot_password_image),
                    contentDescription = "forget password image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(300.dp)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ){
                Text(
                    text = "Lupa Kata Sandi?",
                    fontFamily = FontFamily(Font(R.font.poppins_extrabold)),
                    fontSize = 30.sp,
                    modifier = Modifier
                        .width(200.dp),
                    textAlign = TextAlign.Start
                )
            }

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
            
            Row(
                modifier = Modifier.fillMaxHeight(),
                verticalAlignment = Alignment.Bottom
            ) {
                Button(
                    onClick = {
                        viewModel.resetPassword(email)

                        scope.launch {
                            if (state.value is Resource.Success){
                                Toast.makeText(context, "Email Reset Password Terikirim", Toast.LENGTH_LONG).show()

                                navController.popBackStack()
                                navController.navigate(Screen.Login.route)
                            }
                            else if (state.value is Resource.Error){
                                val message = state.value.message
                                Toast.makeText(context, "$message", Toast.LENGTH_LONG).show()
                            }
                        }
                    },
                    modifier  = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 20.dp),
                    colors = ButtonDefaults.buttonColors(Color(0XFF1877F2)),
                    shape = RoundedCornerShape(50.dp),
                    enabled =  isEmailValid(email)
                ) {
                    Text(
                        text = "Kirim",
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


