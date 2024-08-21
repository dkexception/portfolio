package io.github.dkexception.portfolio

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.window.ComposeViewport
import io.github.dkexception.portfolio.theme.Lora
import io.github.dkexception.portfolio.theme.Montserrat
import io.github.dkexception.portfolio.theme.Typography
import io.github.dkexception.portfolio.utils.loadImage
import io.github.dkexception.portfolio.utils.toByteArray
import kotlinx.browser.document
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import org.jetbrains.compose.resources.configureWebResources

@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    configureWebResources {
        // same as default - this is not necessary to add here. It's here to show this feature
        resourcePathMapping { path -> "./$path" }
    }

    ComposeViewport(document.body!!) {

        var loading: Boolean by remember { mutableStateOf(true) }

        if (loading) {

            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        } else {

            MaterialTheme(
                typography = Typography
            ) {
                App()
            }
        }

        LaunchedEffect(Unit) {
            listOf(
                async {
                    loadMontserratFont()
                },
                async {
                    loadLoraFont()
                }
            ).awaitAll()
            loading = false
        }
    }
}

private suspend fun loadMontserratFont() {

    val regular = loadResource("Montserrat-Regular.ttf")
    val bold = loadResource("Montserrat-Bold.ttf")

    Montserrat = FontFamily(
        Font(identity = "MontserratRegular", data = regular, weight = FontWeight.Normal),
        Font(identity = "MontserratBold", data = bold, weight = FontWeight.Bold)
    )
}

private suspend fun loadLoraFont() {

    val regular = loadResource("Lora-Regular.ttf")

    Lora = FontFamily(
        Font(identity = "LoraRegular", data = regular, weight = FontWeight.Normal)
    )
}

internal suspend fun loadResource(path: String): ByteArray {
    return loadImage(path).toByteArray()
}
