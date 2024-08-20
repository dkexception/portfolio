@file:OptIn(ExperimentalTextApi::class, ExperimentalComposeUiApi::class)

package io.github.dkexception.portfolio

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.UrlAnnotation
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.dp
import portfolio.composeapp.generated.resources.ic_heart

@Preview
@Composable
fun App() = MaterialTheme {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Made with ", style = MaterialTheme.typography.body1)
                    Icon(painter = painterResource(Res.drawable.ic_heart), null, tint = Color.Red)
                    Text(" using", style = MaterialTheme.typography.body1)

                    val annotatedString = buildAnnotatedString {
                        pushUrlAnnotation(UrlAnnotation("https://kotl.in/wasm"))
                        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                            append("Kotlin/Wasm")
                        }
                        pop()
                    }

                    ClickableText(
                        text = annotatedString,
                        style = MaterialTheme.typography.body1,
                        onClick = { offset ->
                            annotatedString.getUrlAnnotations(offset, offset).firstOrNull()?.let {
                                getPlatform().openUrlExternally(it.item.url)
                            }
                        }
                    )
                }
            }
        }
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            Row(
                modifier = Modifier.fillMaxSize().weight(1f).background(Color(0xFFDEDEDE)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier.fillMaxSize().weight(1f),
                    contentAlignment = Alignment.Center
                ) {

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {

                        Box(
                            modifier = Modifier
                                .wrapContentSize()
                                .clip(CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                modifier = Modifier.size(LocalWindowInfo.current.containerSize.width.dp / 12),
                                painter = painterResource(Res.drawable.dp),
                                contentDescription = "Profile Picture"
                            )
                        }

                        Text("DHANESH KATRE", style = MaterialTheme.typography.h1)

                        Text("Mobile applications developer", style = MaterialTheme.typography.h3)

                        val portfolioText =
                            "Hey there! I'm a seasoned Android Developer with over 5 years of experience crafting top-tier mobile apps. From leading the development of high-impact apps to engineering innovative features for next-gen technologies, my journey in mobile development is a blend of creativity, precision, and cutting-edge technology. Dive into my GitHub to see how Kotlin, Jetpack Compose, and more come together to deliver seamless, user-centric experiences."

                        Text(portfolioText, style = MaterialTheme.typography.body1)
                    }
                }

                Spacer(
                    modifier = Modifier
                        .width(1.dp)
                        .height(LocalWindowInfo.current.containerSize.height.dp / 2)
                        .background(Color.Black)
                )

                Box(
                    modifier = Modifier.fillMaxSize().weight(1f),
                    contentAlignment = Alignment.Center
                ) {

                }
            }
        }
    }
}
