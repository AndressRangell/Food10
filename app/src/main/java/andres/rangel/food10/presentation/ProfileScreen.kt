package andres.rangel.food10.presentation

import andres.rangel.food10.R
import andres.rangel.food10.data.model.DishCategory
import andres.rangel.food10.navigation.AppScreens
import andres.rangel.food10.ui.theme.BackgroundLight
import andres.rangel.food10.ui.theme.DarkGray
import andres.rangel.food10.ui.theme.YellowButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

val dishCategories = listOf(
    DishCategory("Burgers", R.drawable.burger),
    DishCategory("Sushi", R.drawable.sushi),
    DishCategory("Tacos", R.drawable.tacos)
)

@Composable
fun ProfileScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Perfil",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = DarkGray
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Foto del usuario"
        )
        Text(
            text = "Ixel Suarez",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = DarkGray
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "ixel@gmail.com",
            fontSize = 16.sp,
            color = DarkGray
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 80.dp),
            onClick = { /*TODO: Handle click*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = YellowButton,
                contentColor = DarkGray
            )
        ) {
            Text(
                "Editar perfil",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Intereses",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = DarkGray
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(dishCategories.size) { index ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = dishCategories[index].image),
                        contentDescription = "Category",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                    )
                    Text(
                        text = dishCategories[index].name,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(110.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .clickable {  }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        modifier = Modifier
                            .size(40.dp)
                            .padding(bottom = 10.dp),
                        painter = painterResource(id = R.drawable.creditcard),
                        contentDescription = "Credit card",
                        tint = YellowButton
                    )
                    Text(
                        text = "Agregar tarjeta",
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Box(
                modifier = Modifier
                    .size(110.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .clickable {  }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        modifier = Modifier
                            .size(40.dp)
                            .padding(bottom = 10.dp),
                        painter = painterResource(id = R.drawable.help),
                        contentDescription = "Help",
                        tint = YellowButton
                    )
                    Text(
                        text = "Pedir ayuda",
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Box(
                modifier = Modifier
                    .size(110.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .clickable {
                        navController.navigate(AppScreens.LoginScreen.route)
                    }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        modifier = Modifier
                            .size(40.dp)
                            .padding(bottom = 10.dp),
                        painter = painterResource(id = R.drawable.logout),
                        contentDescription = "Log out",
                        tint = YellowButton
                    )
                    Text(
                        text = "Cerrar sesión",
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}