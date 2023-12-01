package andres.rangel.food10.components

import andres.rangel.food10.R
import andres.rangel.food10.ui.theme.LightGray
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun SocialMedia() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        SocialMediaButton(
            modifier = Modifier.weight(1f),
            painter = painterResource(id = R.drawable.facebook),
            onClick = { /* Manejar inicio de sesión con Facebook */ }
        )
        SocialMediaButton(
            modifier = Modifier.weight(1f),
            painter = painterResource(id = R.drawable.google),
            onClick = { /* Manejar inicio de sesión con Google */ }
        )
    }
}

@Composable
fun SocialMediaButton(modifier: Modifier = Modifier, painter: Painter, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .height(30.dp)
            .border(1.dp, LightGray, ShapeDefaults.Large)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp),
            painter = painter,
            contentDescription = "Social media"
        )
    }
}