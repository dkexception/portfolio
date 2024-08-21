package io.github.dkexception.portfolio.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import io.github.dkexception.portfolio.domain.SocialLinkData
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun SocialLinksRow(
    linksToDisplay: List<SocialLinkData> = SocialLinkData.DEFAULT
) {

    val uriOpener = LocalUriHandler.current

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        linksToDisplay.forEach {
            IconButton(
                onClick = {
                    uriOpener.openUri(it.destinationUrl)
                }
            ) {
                Icon(
                    painter = painterResource(it.icon),
                    contentDescription = it.contentDescription,
                    tint = Color.Black,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}
