package andres.rangel.food10.data.model

import androidx.annotation.DrawableRes

data class Dish(
    val name: String,
    val description: String,
    val rating: Double,
    val discount: Int,
    val price: String,
    @DrawableRes val image: Int
)