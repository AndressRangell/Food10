package andres.rangel.food10.data.model

import androidx.annotation.DrawableRes

data class DishCategory(
    val name: String,
    @DrawableRes val image: Int
)