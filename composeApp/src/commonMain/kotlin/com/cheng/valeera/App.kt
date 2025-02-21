package com.cheng.valeera

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.cheng.valeera.ui.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        AppView()
    }
}

@Composable
private fun AppView() {
    HomeScreen()
}
