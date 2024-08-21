package io.github.dkexception.portfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.github.dkexception.portfolio.presentation.CareerColumn
import io.github.dkexception.portfolio.presentation.Footer
import io.github.dkexception.portfolio.presentation.ProfileColumn
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun App() = Scaffold(
    modifier = Modifier.fillMaxSize(),
    bottomBar = { Footer() },
    backgroundColor = MaterialTheme.colors.background
) { paddings ->
    Row(
        modifier = Modifier.fillMaxSize().padding(paddings),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier.fillMaxSize().weight(1.5f),
            contentAlignment = Alignment.Center
        ) {
            ProfileColumn()
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(49.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Spacer(
                modifier = Modifier
                    .width(1.dp)
                    .background(Color.Black)
                    .weight(2f)
            )
            Spacer(modifier = Modifier.weight(1f))
        }

        Box(
            modifier = Modifier.fillMaxSize().weight(1f),
            contentAlignment = Alignment.Center
        ) {
            CareerColumn()
        }
    }
}
