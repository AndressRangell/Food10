package andres.rangel.food10.components

import andres.rangel.food10.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Header() {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(30.dp),
        painter = painterResource(id = R.drawable.food10),
        contentDescription = "Logo Food10"
    )
}