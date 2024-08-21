package io.github.dkexception.portfolio.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.ic_arrow_outward
import portfolio.composeapp.generated.resources.ic_heart

@Preview
@Composable
fun Footer() {

    val uriOpener = LocalUriHandler.current

    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Text("Made with ", style = MaterialTheme.typography.button)

            Icon(painter = painterResource(Res.drawable.ic_heart), null, tint = Color.Red)

            Text(" using ", style = MaterialTheme.typography.button)

            TextButton(
                onClick = {
                    uriOpener.openUri("https://kotl.in/wasm")
                }
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Kotlin/Wasm")
                    Icon(
                        painter = painterResource(Res.drawable.ic_arrow_outward),
                        contentDescription = null
                    )
                }
            }
        }
    }
}
