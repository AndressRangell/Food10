package andres.rangel.food10.presentation

import andres.rangel.food10.R
import andres.rangel.food10.components.Header
import andres.rangel.food10.components.SocialMedia
import andres.rangel.food10.navigation.AppScreens
import andres.rangel.food10.ui.theme.DarkGray
import andres.rangel.food10.ui.theme.YellowButton
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun LoginScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Header()
        LoginForm(navController)
        Spacer(modifier = Modifier.height(16.dp))
        SocialMedia()
        SignUp(navController)
    }
}

@Composable
fun LoginForm(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            text = "Correo electrónico",
            fontWeight = FontWeight.Bold,
            color = DarkGray
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(bottom = 10.dp),
            value = email,
            onValueChange = { email = it },
            shape = ShapeDefaults.Large,
            maxLines = 1
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            text = "Contraseña",
            fontWeight = FontWeight.Bold,
            color = DarkGray
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(bottom = 10.dp),
            value = password,
            onValueChange = { password = it },
            shape = ShapeDefaults.Large,
            maxLines = 1,
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        painter = painterResource(
                            if (isPasswordVisible)
                                R.drawable.icon_visibility
                            else
                                R.drawable.icon_visibility_off
                        ),
                        contentDescription = if (isPasswordVisible) "Hide Password" else "Show Password"
                    )
                }
            }
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(top = 10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = YellowButton),
            shape = ShapeDefaults.Large,
            onClick = {
                if (validateUser(email, password)) {
                    navController.navigate(AppScreens.HomeScreen.route)
                } else {
                    //
                }
            }
        ) {
            Text(
                text = "Iniciar Sesión",
                color = DarkGray,
                fontSize = 16.sp
            )
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            text = "Olvidaste tu contraseña",
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            color = DarkGray
        )
    }
}

fun validateUser(email: String, password: String): Boolean =
    email == "ixel@gmail.com" && password == "12345"

@Composable
fun SignUp(navController: NavHostController) {
    Row {
        Text(
            modifier = Modifier
                .padding(30.dp),
            text = "¿No tienes una cuenta?",
            color = DarkGray
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
                .clickable {
                    navController.navigate(AppScreens.RegisterScreen.route)
                },
            text = "Regístrate",
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            color = DarkGray
        )
    }
}