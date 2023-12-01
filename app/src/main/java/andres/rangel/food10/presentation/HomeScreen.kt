package andres.rangel.food10.presentation

import andres.rangel.food10.R
import andres.rangel.food10.data.model.Dish
import andres.rangel.food10.data.model.DishCategory
import andres.rangel.food10.navigation.AppScreens
import andres.rangel.food10.ui.theme.BackgroundLight
import andres.rangel.food10.ui.theme.DarkGray
import andres.rangel.food10.ui.theme.LightGray
import andres.rangel.food10.ui.theme.YellowButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 60.dp)
            .background(BackgroundLight)
            .verticalScroll(scrollState)
    ) {
        HomeHeader()
        SearchBar()
        Banner()
        Categories()
        SpecialDishes(navController)
    }
}

@Composable
fun HomeHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(id = R.drawable.location),
            contentDescription = "Location",
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
        )
        Text(
            modifier = Modifier.width(250.dp),
            text = "Real de minas",
            fontSize = 18.sp
        )
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
    }
}

@Composable
fun SearchBar() {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        shape = RoundedCornerShape(20),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(50.dp),
        leadingIcon = {
            Icon(
                modifier = Modifier.size(25.dp),
                painter = painterResource(id = R.drawable.loupe),
                contentDescription = "Search Icon"
            )
        },
        placeholder = {
            Text(text = "Buscar")
        }
    )
}

@Composable
fun Banner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        val gradient = Brush.horizontalGradient(
            colors = listOf(Color(0xFFFFDE59), Color(0xFFFFF9CC))
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 20.dp)
                .background(
                    shape = RoundedCornerShape(20.dp),
                    brush = gradient
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, start = 10.dp),
                text = "Hasta 40% de descuento",
                color = DarkGray,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 10.dp),
                text = "Haz tu primer orden",
                color = DarkGray,
                fontSize = 20.sp
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 10.dp,
                        start = 10.dp,
                        end = 180.dp
                    ),
                onClick = { /*TODO: Handle click*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = DarkGray
                )
            ) {
                Text(
                    "Ordenar ahora",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun Categories() {
    val dishCategories = listOf(
        DishCategory("Burgers", R.drawable.burger),
        DishCategory("HotDogs", R.drawable.hotdog),
        DishCategory("Pasta", R.drawable.pasta),
        DishCategory("Ensalada", R.drawable.ensalada),
        DishCategory("Sushi", R.drawable.sushi),
        DishCategory("Tacos", R.drawable.tacos)
    )

    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = "Categorías populares",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
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
    }
}

@Composable
fun SpecialDishes(navController: NavHostController) {
    val dishes = listOf(
        Dish(
            "Ceviche de mango",
            "Descripción corta del plato 1",
            5.0,
            20,
            "$15.000",
            R.drawable.ceviche
        ),
        Dish(
            "Ceviche de mango",
            "Descripción corta del plato 2",
            4.0,
            15,
            "$15.000",
            R.drawable.ceviche
        ),
        Dish(
            "Ceviche de mango",
            "Descripción corta del plato 3",
            4.5,
            10,
            "$15.000",
            R.drawable.ceviche
        )
    )

    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = "Especiales de hoy",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        LazyRow {
            items(dishes.size) { index ->
                DishCard(dishes[index], navController)
            }
        }
    }
}

@Composable
fun DishCard(dish: Dish, navController: NavHostController) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .width(280.dp)
            .clickable {
                navController.navigate(AppScreens.MapScreen.route)
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = dish.image),
                contentDescription = "Dish Image",
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            )
            Text(
                text = dish.name,
                modifier = Modifier.padding(8.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = dish.price,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${dish.discount}% off",
                    color = Color.Magenta,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = dish.description,
                modifier = Modifier.padding(8.dp),
                color = LightGray,
                fontSize = 16.sp
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    Icons.Filled.Star,
                    contentDescription = "Star",
                    tint = YellowButton
                )
                Text(
                    text = dish.rating.toString(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}