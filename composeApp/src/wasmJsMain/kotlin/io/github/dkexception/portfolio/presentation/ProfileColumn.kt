package io.github.dkexception.portfolio.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.cutout

@Composable
fun ProfileColumn() = Column(
    modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
) {

    Image(
        modifier = Modifier.size(400.dp),
        painter = painterResource(Res.drawable.cutout),
        contentDescription = null,
        contentScale = ContentScale.FillBounds
    )

    Spacer(modifier = Modifier.height(16.dp))

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "DHANESH KATRE",
            style = MaterialTheme.typography.h1,
            fontWeight = FontWeight.Bold
        )

        Text("Mobile applications developer", style = MaterialTheme.typography.h3)

        val portfolioText =
            "Hey there! I'm a seasoned Android Developer with over 5 years of experience crafting top-tier mobile apps. From leading the development of high-impact apps to engineering innovative features for next-gen technologies, my journey in mobile development is a blend of creativity, precision, and cutting-edge technology. Dive into my GitHub to see how Kotlin, Jetpack Compose, and more come together to deliver seamless, user-centric experiences."

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = portfolioText,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Justify
        )

        Spacer(modifier = Modifier.height(8.dp))

        SocialLinksRow()
    }
}
