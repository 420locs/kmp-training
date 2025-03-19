package org.example.test1

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import org.example.test1.feature.AppNavHost
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        AppNavHost()
    }
}