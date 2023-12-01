package andres.rangel.food10.data.model

import androidx.annotation.DrawableRes

data class Restaurant(
    val name: String,
    val priceRange: String,
    val rating: Double,
    @DrawableRes val image: Int
)