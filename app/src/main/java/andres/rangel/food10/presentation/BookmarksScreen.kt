package andres.rangel.food10.presentation

import andres.rangel.food10.R
import andres.rangel.food10.data.model.Dish
import andres.rangel.food10.data.model.Restaurant
import andres.rangel.food10.ui.theme.BackgroundLight
import andres.rangel.food10.ui.theme.DarkGray
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun BookmarksScreen(navController: NavController) {
    val favoriteDishes = listOf(
        Dish(
            "Cheese Burge doble carne",
            "Descripción corta del plato 1",
            5.0,
            20,
            "$25.000",
            R.drawable.burger
        ),
        Dish(
            "Tacos Mexicanos",
            "Descripción corta del plato 3",
            4.5,
            10,
            "$20.000",
            R.drawable.tacos
        )
    )
    val bestRestaurants = listOf(
        Restaurant(
            "Donde Luigi",
            "15.000 - 35.000",
            4.8,
            R.drawable.luigi
        ),
        Restaurant(
            "Clasicos Forever",
            "12.000 - 45.000",
            4.7,
            R.drawable.clasicos
        ),
        Restaurant(
            "Nativos Burger",
            "15.000 - 35.000",
            4.8,
            R.drawable.nativos
        ),
        Restaurant(
            "Zirus Pizza",
            "15.000 - 35.000",
            4.5,
            R.drawable.zirus
        ),
        Restaurant(
            "McDonald's",
            "15.000 - 35.000",
            4.8,
            R.drawable.mcdonalds
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
            .padding(
                start = 16.dp,
                end = 16.dp,
                bottom = 40.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "Favoritos",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = DarkGray
        )
        LazyColumn {
            items(favoriteDishes.size) { index ->
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
                            painter = painterResource(id = favoriteDishes[index].image),
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
                                text = favoriteDishes[index].name,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = favoriteDishes[index].price,
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
                                    text = favoriteDishes[index].rating.toString(),
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
                                text = "${favoriteDishes[index].discount}% off"
                            )
                        }
                    }
                }
            }
        }

        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "Mejores Restaurantes",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = DarkGray
        )
        LazyColumn {
            items(bestRestaurants.size) { index ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
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
                            painter = painterResource(id = bestRestaurants[index].image),
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
                                text = bestRestaurants[index].name,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Precios: ${bestRestaurants[index].priceRange}",
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
                                    text = bestRestaurants[index].rating.toString(),
                                    fontSize = 14.sp
                                )
                            }
                            Button(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                onClick = { /*TODO: Handle click*/ },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = YellowButton,
                                    contentColor = DarkGray
                                )
                            ) {
                                Text(text = "Ir al restaurante")
                            }
                        }
                    }
                }
            }
        }
    }
}