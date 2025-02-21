package com.cheng.valeera.ui


import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.cheng.valeera.getPlatform
import org.jetbrains.compose.ui.tooling.preview.Preview


private object NesPalette {
    val BLACK = Color(0xFF000000)
    val YELLOW = Color(0xFFf8d878)
    val WHITE = Color(0xFFffffff)
}


@Composable
@Preview
fun HomeScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = NesPalette.BLACK,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            NesStyleMainMenu()
        }
    }
}

@Composable
private fun NesStyleMainMenu(
) {
    Column(
        Modifier.sizeIn(
            minHeight = 200.dp,
        ),
        verticalArrangement = Arrangement.Center,
    ) {
        NesStyleMenuText("01. WHEEL OF NAMES")
        NesStyleMenuText("02. ROSTER GENERATOR FOR TOASTMASTERS")
        NesStyleMenuText("03. SPEAKING ORDER FOR TOASTMASTERS")
    }
}

@Composable
private fun NesStyleMenuText(
    text: String,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val isPressed by interactionSource.collectIsPressedAsState()
    val isHighlighted = isHovered || isPressed
    val localIndication = LocalIndication.current

    Text(
        text = text,
        modifier = Modifier
            .hoverable(interactionSource = interactionSource)
            .clickable(interactionSource = interactionSource, indication = localIndication, onClick = {})
            .padding(vertical = 8.dp),
        color = if (isHighlighted) NesPalette.WHITE else NesPalette.YELLOW,
    )
}
