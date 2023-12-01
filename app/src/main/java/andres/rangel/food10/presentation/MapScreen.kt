package andres.rangel.food10.presentation

import andres.rangel.food10.R
import andres.rangel.food10.data.model.Dish
import andres.rangel.food10.ui.theme.BackgroundLight
import andres.rangel.food10.ui.theme.GreenLight
import andres.rangel.food10.ui.theme.YellowButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

val dish = Dish(
    "Ceviche de mango",
    "Descripción corta del plato 3",
    4.5,
    10,
    "$15.000",
    R.drawable.ceviche
)

@Composable
fun MapScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.map),
            contentDescription = "Map",
            contentScale = ContentScale.FillWidth
        )
        DishCardMap()
    }
}

@Composable
fun DishCardMap() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(125.dp)
            .padding(
                start = 10.dp,
                end = 10.dp,
                top = 10.dp
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .fillMaxHeight(),
                painter = painterResource(id = dish.image),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 20.dp,
                        vertical = 10.dp
                    )
            ) {
                Text(
                    text = dish.name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = dish.price,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Row {
                    Icon(
                        Icons.Default.Star,
                        contentDescription = "Rating",
                        tint = YellowButton
                    )
                    Text(
                        modifier = Modifier.padding(
                            top = 2.dp,
                            start = 10.dp
                        ),
                        text = dish.rating.toString(),
                        fontSize = 14.sp
                    )
                }
                Text(
                    modifier = Modifier
                        .height(50.dp)
                        .background(
                            color = GreenLight,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(3.dp),
                    text = "${dish.discount}% off"
                )
            }
        }
    }
}