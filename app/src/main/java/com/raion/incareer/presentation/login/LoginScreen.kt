import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.chenzfall.incareer.R


@Composable
fun LoginScreen(){

    EllipseBackground()

    Column(
        modifier = Modifier
            .padding(top = 150.dp)
            .padding(horizontal = 20.dp)
            .fillMaxSize()
        ,
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 50.dp),
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
        Row(){
            EmailAndPasswordInput()
        }

        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxWidth()
        ){
            TextButton(onClick = { /*TODO*/ }){
                Text(
                    text = "Forgot Password",
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    color = Color(0XFF1877F2),
                    fontSize = 12.sp,
                    modifier = Modifier
                )
            }
        }

        LoginSeparator()

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
            onClick = { /*TODO*/ },
            modifier  = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp),
            colors = ButtonDefaults.buttonColors(Color(0XFF1877F2)),
            shape = RoundedCornerShape(50.dp)
        ) {
            Text(
                text = "Masuk",
                fontFamily = FontFamily(Font(R.font.poppins_extrabold)),
                color = Color.White,
                fontSize = 20.sp,
                letterSpacing = 0.5.sp
            )
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
                onClick = { /*TODO*/ },
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
fun EmailAndPasswordInput() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = { newEmail ->
                email = newEmail
            },
            label = { Text("Email") },
            leadingIcon = {
                Icon(Icons.Outlined.Email, contentDescription = "Email")
            },
            placeholder = { Text("Email") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { /* action on 'Next' button pressed */ }),
            isError = !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        )
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.isNotEmpty()) {
            Text("Format email tidak valid", color = MaterialTheme.colors.error)
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { newPassword ->
                password = newPassword
            },
            label = { Text("Kata Sandi") },
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
            placeholder = { Text("Kata Sandi") },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { /* action on 'Done' button pressed */ }),
            isError = password.length < 8 && password.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        )
        if (password.length < 8 && password.isNotEmpty()) {
            Text("Kata sandi minimal 8 karakter", color = MaterialTheme.colors.error)
        }
    }
}

@Composable
fun LoginSeparator() {
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



@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}

@Preview(showBackground = true)
@Composable
fun FormLoginPreview() {
    EmailAndPasswordInput()
}